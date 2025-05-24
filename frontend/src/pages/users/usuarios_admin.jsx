import React, { useState, useEffect } from 'react';
import Modal from './components/Modal';
import ModalEditar from './components/ModalEditar';
import ModalEliminar from './components/ModalEliminar';
import { ButtonBlue } from "@/components/custom/button"


const getTipoUsuarioLabel = (codigoTipoUsuario) => {
  switch (codigoTipoUsuario) {
    case 1:
      return 'Administrador';
    case 2:
      return 'Coordinador';
    case 3:
      return 'Operador';
    case 4:
      return 'Lider Auditor';
    case 5:
      return 'Auditor';
    default:
      return 'Desconocido';
  }
};
const SomePage = () => {
  const [isModalOpen, setModalOpen] = useState(false);
  const [isDeleteModalOpen, setDeleteModalOpen] = useState(false);
  const [isModalEditarOpen, setModalEditarOpen] = useState(false);
  const [usuarioDesactivated, setUsuarioDesactivated] = useState(null);
  const [selectedUser, setSelectedUser] = useState(null);

  
  // Estados para filtros
  const [tipoUsuario, setTipoUsuario] = useState('');
  const [nombre, setNombre] = useState('');
  const [apellido, setApellido] = useState('');
  const [laboratorioInstituto, setLaboratorioInstituto] = useState('');
  const [correo, setCorreo] = useState('');

  // Estado para usuarios
  const [usuarios, setUsuarios] = useState([]);
  const [usuariosFiltrados, setUsuariosFiltrados] = useState([]);

  //Estados para el mensaje de confirmacion de operacion
  const [operacionMensaje, setOperacionMensaje] = useState('');
  const [mensajeTipo, setMensajeTipo] = useState('');

  // Función para mostrar mensaje
  const mostrarMensaje = (mensaje, tipo) => {
    setOperacionMensaje(mensaje);
    setMensajeTipo(tipo);
    setTimeout(() => {
      setOperacionMensaje('');
      setMensajeTipo('');
    }, 5000);
  };
  
  const fetchUsuarios = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/usuarios');
      if (response.ok) {
        const data = await response.json();
        setUsuarios(data);
        const usuariosActivos = data.filter(usuario => usuario.estadoUso === true);
        setUsuariosFiltrados(usuariosActivos);
      } else {
        console.error('Error fetching usuarios:', response.statusText);
      }
    } catch (error) {
      console.error('Error en la solicitud:', error);
    }
  };

  useEffect(() => {
    fetchUsuarios();
  }, []);

  const aplicarFiltros = () => {
    const filtros = {
      codigoTipoUsuario: tipoUsuario,
      nombre: nombre.toLowerCase(),
      apellido: apellido.toLowerCase(),
      laboratorioInstituto: laboratorioInstituto.toLowerCase(),
      correo: correo.toLowerCase(),
    };
  
    const filtrados = usuarios.filter(usuario => {
      return (
        // Filtrar por tipo de usuario
        (filtros.codigoTipoUsuario ? usuario.tipoUsuario.codigoTipoUsuario.toString() === filtros.codigoTipoUsuario : true) &&
        (filtros.nombre ? usuario.nombreUsuario.toLowerCase().includes(filtros.nombre) : true) &&
        (filtros.apellido ? `${usuario.apellidoPat} ${usuario.apellidoMat}`.toLowerCase().includes(filtros.apellido) : true) &&
        (filtros.laboratorioInstituto ? (usuario.entidad?.nombreEntidad || '').toLowerCase().includes(filtros.laboratorioInstituto) : true) &&
        (filtros.correo ? usuario.correoElectronico.toLowerCase().includes(filtros.correo) : true)
      );
    });
  
    setUsuariosFiltrados(filtrados);
  };

  // Efecto para aplicar filtros al cambiar los valores de los filtros o la lista de usuarios
  useEffect(() => {
    aplicarFiltros();
  }, [tipoUsuario, nombre, apellido, laboratorioInstituto, correo]); 

  const handleOpenModal = () => {setModalOpen(true);};
  const handleCloseModal = () => {setModalOpen(false); fetchUsuarios();};
  const handleOpenModalEditar = (user) => {setSelectedUser(user); setModalEditarOpen(true);};
  const handleCloseModalEditar = () => {setModalEditarOpen(false); setSelectedUser(null); fetchUsuarios();};
  const handleOpenDeleteModal = (user) => {setUsuarioDesactivated(user); setDeleteModalOpen(true);};
  const handleCloseDeleteModal = () => {setDeleteModalOpen(false); setUsuarioDesactivated(null);
  };

  const handleDesactivated = async () => {
    console.log("Usuario a desactivar: ", usuarioDesactivated);
    console.log(`http://localhost:8080/api/usuarios/update/${usuarioDesactivated.codigoUsuario}`);
    const dataDesactivated ={
          nombreUsuario: usuarioDesactivated.nombreUsuario,
          apellidoPat: usuarioDesactivated.apellidoPat,
          apellidoMat: usuarioDesactivated.apellidoMat,
          dni: usuarioDesactivated.dni,
          correoElectronico: usuarioDesactivated.correoElectronico,
          telefono: usuarioDesactivated.telefono,
          tipoUsuario: {
            codigoTipoUsuario: usuarioDesactivated.tipoUsuario.codigoTipoUsuario,
          },
          entidad: (usuarioDesactivated.tipoUsuario.codigoTipoUsuario === 2 || usuarioDesactivated.tipoUsuario.codigoTipoUsuario === 3) ? {
            codigoEntidad: usuarioDesactivated.entidad.codigoEntidad
          } : null,
          estadoUso: false
    }
    console.log("Datos enviados, ", dataDesactivated);
    try { 
        const response = await fetch(`http://localhost:8080/api/usuarios/update/${usuarioDesactivated.codigoUsuario}`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(dataDesactivated),
        });
        if (!response.ok) {
          mostrarMensaje('Error en la solicitud de desactivacion', 'error');
          throw new Error('Error updating user data');
        }
        mostrarMensaje('Usuario desactivado correctamente', 'exito');
        handleCloseDeleteModal();
      } catch (error) {
        console.error('Error al desactivaasaar:', error);
        mostrarMensaje('Error al desactivar usuario', 'error');
        handleCloseDeleteModal();
      }
      document.body.style.overflow = 'auto';
  }

  return (
      <div className="max-h-full flex flex-col font-lato w-full">
        <h1 className="text-3xl text-black text-center mt-4 font-bold">Usuarios</h1>
        <div className="flex-grow mt-4 mx-2 border text-black border-black rounded-3xl p-4">
          <div className="mb-4">
            <div className="flex items-center mb-4">
              <div className="flex-1">
                <label className="block text-sm font-semibold mb-1">Tipo de Usuario</label>
                <select value={tipoUsuario} onChange={(e) => setTipoUsuario(e.target.value)} className="w-w-68 border border-gray-300 rounded-lg p-2">
                  <option value="">Seleccionar</option>
                  <option value="1">Administrador</option>
                  <option value="2">Coordinador</option>
                  <option value="3">Operador</option>
                  <option value="4">Lider Auditor</option>
                  <option value="5">Auditor Interno</option>
                </select>
              </div>
              <div className="flex-1 flex items-center justify-end">
                <ButtonBlue className="rounded-lg w-w-68" onClick={() => handleOpenModal()}>Registrar</ButtonBlue>
              </div>
            </div>
            <div className="flex space-x-4">
              <div className="flex-1">
                <label className="block text-sm font-semibold mb-1">Nombre</label>
                <div className="relative">
                  <input type="text" value={nombre} onChange={(e) => setNombre(e.target.value)} className="w-full border border-gray-300 rounded-lg p-2 pr-10" />
                  <img src="/images/incono_lupa.png" alt="Icono Lupa" className="absolute right-2 top-1/2 transform -translate-y-1/2 w-5 h-5" />
                </div>
              </div>
              <div className="flex-1">
                <label className="block text-sm font-semibold mb-1">Apellido</label>
                <div className="relative">
                  <input type="text" value={apellido} onChange={(e) => setApellido(e.target.value)} className="w-full border border-gray-300 rounded-lg p-2 pr-10" />
                  <img src="/images/incono_lupa.png" alt="Icono Lupa" className="absolute right-2 top-1/2 transform -translate-y-1/2 w-5 h-5" />
                </div>
              </div>
              <div className="flex-1">
                <label className="block text-sm font-semibold mb-1">Laboratorio/Instituto</label>
                <div className="relative">
                <input type="text" value={laboratorioInstituto} onChange={(e) => setLaboratorioInstituto(e.target.value)} className="w-full border border-gray-300 rounded-lg p-2 pr-10" />
                  <img src="/images/incono_lupa.png" alt="Icono Lupa" className="absolute right-2 top-1/2 transform -translate-y-1/2 w-5 h-5" />
                </div>
              </div>
              <div className="flex-1">
                <label className="block text-sm font-semibold mb-1">Correo Electrónico</label>
                <div className="relative">
                  <input type="text" value={correo} onChange={(e) => setCorreo(e.target.value)} className="w-full border border-gray-300 rounded-lg p-2 pr-10" />
                  <img src="/images/incono_lupa.png" alt="Icono Lupa" className="absolute right-2 top-1/2 transform -translate-y-1/2 w-5 h-5" />
                </div>
              </div>
            </div>
          </div>
          {operacionMensaje && (
            <div
              className={`mt-4 p-3 rounded ${
                mensajeTipo === 'exito' ? 'bg-green-200 text-green-800' : 'bg-red-200 text-red-800'
              }`}
            >
              {operacionMensaje}
            </div>
          )}
          <div className="h-full flex flex-col p-4">
            <div className="overflow-x-auto">
              <table className="min-w-full border-collapse border border-gray-300 ">
                <thead className="bg-custom-blue text-white font-normal">
                  <tr>
                    <th className="border border-gray-300 px-4 py-2 text-left font-normal">Nombre</th>
                    <th className="border border-gray-300 px-4 py-2 text-left font-normal">Apellido</th>
                    <th className="border border-gray-300 px-4 py-2 text-left font-normal">Correo Electrónico</th>
                    <th className="border border-gray-300 px-4 py-2 text-left font-normal">DNI</th>
                    <th className="border border-gray-300 px-4 py-2 text-left font-normal">Laboratorio/Instituto</th>
                    <th className="border border-gray-300 px-4 py-2 text-left font-normal">Tipo</th>
                    <th className="border border-gray-300 px-2 py-2 text-left font-normal">Opciones</th>
                  </tr>
                </thead>
                <tbody>
                {usuariosFiltrados.length === 0 ? (
                  <tr>
                    <td colSpan="7" className="border border-gray-300 px-4 py-2 text-center">
                      No hay usuarios que coincidan con los filtros.
                    </td>
                  </tr>
                ) : (
                  usuariosFiltrados.map((usuario) => (
                    <tr key={usuario.codigoUsuario}>
                      <td className="border border-gray-300 px-4 py-2">{usuario.nombreUsuario}</td>
                      <td className="border border-gray-300 px-4 py-2">{`${usuario.apellidoPat} ${usuario.apellidoMat}`}</td>
                      <td className="border border-gray-300 px-4 py-2">{usuario.correoElectronico}</td>
                      <td className="border border-gray-300 px-4 py-2">{usuario.dni}</td>
                      <td className="border border-gray-300 px-4 py-2">{usuario.codigoTipoUsuario === 1 || usuario.codigoTipoUsuario === 2 ? '--------' : usuario.entidad?.nombreEntidad || '--------'}</td>
                      <td className="border border-gray-300 px-4 py-2">{getTipoUsuarioLabel(usuario.tipoUsuario.codigoTipoUsuario)}</td>
                      <td className="border border-gray-300 px-2 py-2 justify-center space-x-2">
                        <button className="ml-1" onClick={() => {handleOpenModalEditar(usuario)}}><img src="/images/icono_editar.png" alt="Editar" className="w-6 h-6" /></button>
                        <button onClick={() => handleOpenDeleteModal(usuario)}><img src="/images/icono_borrar.png" alt="Eliminar" className="w-6 h-6" /></button></td>
                    </tr>
                  ))
                )}
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <Modal isOpen={isModalOpen} onClose={handleCloseModal} onConfirm={() => mostrarMensaje('Usuario creado con éxito', 'exito')}  />
        <ModalEliminar isOpen={isDeleteModalOpen} onClose={handleCloseDeleteModal} onConfirm={handleDesactivated}  />
        <ModalEditar isOpen={isModalEditarOpen} onClose={handleCloseModalEditar} user={selectedUser} onConfirm={() => mostrarMensaje('Usuario editado con éxito', 'exito')}/>
      </div>
  );
};

export default SomePage;