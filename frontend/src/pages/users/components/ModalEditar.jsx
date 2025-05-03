import { useState, useEffect } from 'react';
import { ButtonBlue, ButtonGray } from "@/components/custom/button"

const ModalEditar = ({isOpen, onClose, user, onConfirm } ) => {
  if (!isOpen) return null;
  const [id, setId] = useState(user.codigoUsuario || null);
  const [role, setRole] = useState(user.tipoUsuario.codigoTipoUsuario || 1);
  const [labOrInstitute, setLabOrInstitute] = useState(user.entidad?.codigoEntidad || null);
  const [entities, setEntities] = useState([]);
  const [nombre, setNombre] = useState(user.nombreUsuario);
  const [email, setEmail] = useState(user.correoElectronico);
  const [apellidoPat, setApellidoPat] = useState(user.apellidoPat);
  const [apellidoMat, setApellidoMat] = useState(user.apellidoMat);
  const [dni, setDni] = useState(user.dni);
  const [telefono, setTelefono] = useState(user.telefono);
  const [error, setError] = useState('');
  

  document.body.style.overflow = 'hidden';

  useEffect(() => {
    if (role === 2 || role === 3) {
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
    setRole(Number(event.target.value));
    setLabOrInstitute('');
  };

  const handleOptionChange = (e) => {
    setLabOrInstitute(e.target.value);
    console.log('Código de la entidad seleccionada:', labOrInstitute);
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
    try {
        const response = await fetch(`http://localhost:8080/api/usuarios/update/${id}`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            nombreUsuario: nombre,
            apellidoPat: apellidoPat,
            apellidoMat: apellidoMat,
            dni: dni,
            correoElectronico: email,
            telefono: telefono,
            tipoUsuario: {
              codigoTipoUsuario: role
            },
            entidad: (role === 2 || role === 3) ? {
              codigoEntidad: labOrInstitute
            } : null,
            estadoUso: true,
          }),
        });
        console.log("Datos nuevos del usuario: ", JSON.stringify);
        if (!response.ok) {
          throw new Error('Error updating user data');
        }
    
        const data = await response.json();
        console.log('Usuario actualizado:', data);
        onClose();
        onConfirm();
      } catch (error) {
        console.error('Error updating user:', error);
      }
      document.body.style.overflow = 'auto';
  }


  const handleCancel = () => {
    setNombre('');
    setEmail('');
    setApellidoPat('');
    setApellidoMat('');
    setDni('');
    setTelefono('');
    setRole(1); 
    setLabOrInstitute('');
    onClose();
    document.body.style.overflow = 'auto';
  };
  return (
    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
      <div className="bg-white w-1/2 p-8 rounded-lg shadow-lg relative">
        <h2 className="text-2xl font-bold mb-4 text-black text-center">EDITAR USUARIO</h2>
        
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
                <option value="2">Auditor</option>
                <option value="3">Coordinador</option>
                <option value="4">Operador</option>
              </select>
            </div>

            <div className="flex-1 text-black">
              <label className="block font-bold mb-2">
                {role === 2 || role === 3 ? 'Laboratorio/Instituto' : ''}
              </label>
              <select
                value={labOrInstitute} 
                onChange={handleOptionChange}
                className="border border-gray-300 rounded-lg p-2 w-full"
                style={{ display: role === 2 || role === 3 ? 'block' : 'none' }}
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
        <div className="border border-black rounded-lg p-4 mb-6 text-black">
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
  )};

  export default ModalEditar;