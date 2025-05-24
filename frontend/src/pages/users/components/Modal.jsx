import { useState, useEffect } from 'react';
import { ButtonBlue, ButtonGray } from "@/components/custom/button"

const Modal=({isOpen, onClose, onConfirm } )=> {
  if (!isOpen) return null; 

  const [role, setRole] = useState(1);
  const [selectedEntity, setSelectedEntity] = useState(2); 
  const [entities, setEntities] = useState([]);
  const [nombre, setNombre] = useState('');
  const [email, setEmail] = useState('');
  const [apellidoPat, setApellidoPat] = useState('');
  const [apellidoMat, setApellidoMat] = useState('');
  const [dni, setDni] = useState('');
  const [telefono, setTelefono] = useState('');
  const [error, setError] = useState('');

  // Prevenir scroll cuando el modal está abierto
  useEffect(() => {
    if (isOpen) {
      document.body.style.overflow = 'hidden';
    } else {
      document.body.style.overflow = 'auto';
    }
  }, [isOpen]);

  useEffect(() => {
    if (role === '2' || role === '3') {
      fetch('http://localhost:8080/api/entidades', {
        method: 'GET',
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then((data) => {
            setEntities(data);
        })
        .catch((error) => {
          console.error('Error fetching entities:', error);
        });
    } else {
      setEntities([]);
    }
  }, [role]);


  const handleRoleChange = (event) => {
    setRole(event.target.value);
    setSelectedEntity(null);
  };

  const handleOptionChange = (e) => {
    const selectedId = e.target.value;
    const entity = entities.find((entity) => entity.codigoEntidad === parseInt(selectedId));
    setSelectedEntity(entity);
  };

  const handleSubmit = async () => {
    // Validación de campos
    if (nombre!="") {
      if (!/^[a-zA-Z\s]+$/.test(nombre)) {
        setError('El nombre solo debe contener letras.');
        return;
      }
    }
    if (!email.includes('@')) {
      setError('El correo electrónico debe contener un "@" válido.');
      return;
    }
    if(apellidoPat!=""){
      if (!/^[a-zA-Z\s]+$/.test(apellidoPat)) {
        setError('El apellido paterno solo debe contener letras.');
        return;
      }
    }
    if(apellidoMat!=""){
      if (!/^[a-zA-Z\s]+$/.test(apellidoMat)) {
        setError('El apellido materno solo debe contener letras.');
        return;
      }
    }
    if(dni!=""){
      if (!/^\d+$/.test(dni)) {
        setError('El DNI debe contener solo números.');
        return;
      }
    }
    if(telefono!=""){
      if (!/^\d+$/.test(telefono)) {
        setError('El teléfono debe contener solo números.');
        return;
      }
    }
    setError('');

    const userData = {
      nombreUsuario: nombre,
      apellidoPat: apellidoPat,
      apellidoMat: apellidoMat,
      dni: dni,
      correoElectronico: email, 
      telefono: telefono,  
      tipoUsuario: {
        codigoTipoUsuario: parseInt(role)
      },
      entidad: (role === '2' || role === '3') ? {
        codigoEntidad: selectedEntity?.codigoEntidad
      } || null : null,
      estadoUso: true
    };
  
    try {
      const url = 'http://localhost:8080/api/usuarios/create';
      const method = 'POST';
  
      // Primero creamos el usuario
      const userResponse = await fetch(url, {
        method,
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
      });
  
      if (!userResponse.ok) {
        throw new Error('Error al guardar los datos del usuario');
      }
      setRole(1);
      setSelectedEntity(2);
      setNombre('');
      setEmail('');
      setApellidoPat('');
      setApellidoMat('');
      setDni('');
      setTelefono('');
      onConfirm();
      onClose();
    } catch (error) {
      console.error('Error al enviar los datos:', error);
    }
  };

  const handleCancel = () => {
    // Limpiar los datos al cerrar
    setRole(1);
    setSelectedEntity(2);
    setNombre('');
    setEmail('');
    setApellidoPat('');
    setApellidoMat('');
    setDni('');
    setTelefono('');
    setError('');
    onClose(); 
  };
  
  return (
    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 font-lato z-50">
      <div className="bg-white w-1/2 p-8 rounded-lg shadow-lg relative">
        <h2 className="text-2xl font-bold mb-4 text-black text-center">REGISTRAR USUARIO</h2>

        {/* Primer div con borde negro y esquinas redondeadas */}
        <div className="border border-black rounded-lg p-4 mb-6 text-black">
          <h3 className="text-xl font-semibold mb-4 ">Roles</h3>
          {/* Primera fila: Seleccionar Rol */}
          <div className="flex space-x-4 mb-4">
            <div className="flex-1">
              <label className="block mb-2 font-bold">Seleccionar Rol:</label>
              <select
                className="border border-gray-300 rounded-lg p-2 w-full"
                value={role}
                onChange={handleRoleChange}
              >
                <option value="1">Administrador</option>
                <option value="2">Coordinador</option>
                <option value="3">Operador</option>
                <option value="4">Lider Auditor</option>
                <option value="5">Auditor Interno</option>
              </select>
            </div>

            <div className="flex-1 text-black">
              <label className="block font-bold mb-2">
                {role === '2' || role === '3' ? 'Laboratorio/Instituto' : ''}
              </label>
              <select
                value={selectedEntity?.codigoEntidad || ''}
                onChange={handleOptionChange}
                className="border border-gray-300 rounded-lg p-2 w-full"
                style={{ display: role === '2' || role === '3' ? 'block' : 'none' }}
              >
                {/* Renderizar las opciones dinámicamente */}
                {entities.map((entity) => (
                  <option key={entity.id} value={entity.codigoEntidad}> {/* Usar codigoEntidad como valor */}
                    {entity.nombreEntidad}
                  </option>
                ))}
              </select>
            </div>
           </div>
        </div>

        {/* Segundo div para almacenar más campos en dos filas */}
        <div className="border border-black rounded-lg p-4 mb-3 text-black">
        <div className="flex-grow">
          <h3 className="text-xl font-bold mb-4">Datos</h3>
          
          {/* Primera fila de campos */}
          <div className="flex space-x-4 mb-4">
            <div className="flex-1">
              <label className="block mb-2 font-bold">Nombres</label>
              <input
                type="text"
                value={nombre}
                onChange={(e) => setNombre(e.target.value)}
                className="border border-gray-300 rounded-lg p-2 w-full"
              />
            </div>
            <div className="flex-1">
              <label className="block mb-2 font-bold">Correo electronico</label>
              <input
                type="text"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                className="border border-gray-300 rounded-lg p-2 w-full"
              />
            </div>
          </div>

          {/* Segunda fila de campos */}
          <div className="flex space-x-4 mb-4">
            <div className="flex-1">
              <label className="block mb-2 font-bold">Apellido Paterno</label>
              <input
                type="text"
                value={apellidoPat}
                onChange={(e) => setApellidoPat(e.target.value)}
                className="border border-gray-300 rounded-lg p-2 w-full"
              />
            </div>
            <div className="flex-1">
              <label className="block mb-2 font-bold">Apellido Materno</label>
              <input 
                type="text"
                value={apellidoMat}
                onChange={(e) => setApellidoMat(e.target.value)}
                className="border border-gray-300 rounded-lg p-2 w-full"
              />
            </div>
          </div>

          {/* Tercera fila de campos */}
          <div className="flex space-x-4 mb-4">
            <div className="flex-1">
              <label className="block mb-2 font-bold">DNI</label>
              <input
                type="text"
                value={dni}
                onChange={(e) => setDni(e.target.value)}
                className="border border-gray-300 rounded-lg p-2 w-full"
              />
            </div>
            <div className="flex-1">
              <label className="block mb-2 font-bold">Telefono</label>
              <input 
                type="text"
                value={telefono}
                onChange={(e) => setTelefono(e.target.value)}
                className="border border-gray-300 rounded-lg p-2 w-full"
                />
            </div>
          </div>
          </div>
        </div>
        {error && <div className="text-red-600 mb-6 justify-center w-full items-center text-center">{error}</div>}
        {/* Botones de Guardar y Cancelar */}
        <div className="flex justify-center mt-4 space-x-12">
          <ButtonGray className="px-16" onClick={handleCancel}>Cancelar</ButtonGray>
          <ButtonBlue className="px-16" onClick={handleSubmit}>Guardar</ButtonBlue>
        </div>
      </div>
    </div>
  );
  }
  export default Modal;