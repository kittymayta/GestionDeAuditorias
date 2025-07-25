import React, { useState, useEffect } from 'react'; 
import ModalAsignar from '../Administrador/components/ModalAsignar';
import ModalVer from '../Administrador/components/ModalVer';

const getEstado = (condicional) => {
    if(condicional==true){
        return(<div className="bg-green-800 border rounded-full flex text-center justify-center text-white">Procesada</div>);
    } else {
        return(<div className="bg-yellow-300 border rounded-full flex text-center justify-center text-white">En Espera</div>)
    }
}

const SolicitudesAuditoria = () => {
    const [isModalAsignarOpen, setIsModalAsignarOpen] = useState(false);
    const [isModalVerOpen, setIsModalVerOpen] = useState(false);
    const [solicitudes, setSolicitudes] = useState([]);
    const [solicitudesFiltradas, setSolicitudesFiltradas] = useState([]);
    const [selectedState, setSelectedState] = useState("Todos");

    const openModalAsignar = () => setIsModalAsignarOpen(true);
    const closeModalAsignar = () => setIsModalAsignarOpen(false);
    const openModalVer = () => setIsModalVerOpen(true);
    const closeModalVer = () => setIsModalVerOpen(false);

    function formatFecha(fechaFormatear) {
        const fecha = new Date(fechaFormatear);
        
        const dia = String(fecha.getDate()).padStart(2, '0'); // Día con dos dígitos
        const mes = String(fecha.getMonth() + 1).padStart(2, '0'); // Mes (indexado desde 0)
        const año = fecha.getFullYear();
        const horas = String(fecha.getHours()).padStart(2, '0');
        const minutos = String(fecha.getMinutes()).padStart(2, '0');
        
        return `${dia}-${mes}-${año} ${horas}:${minutos}`;
    }
    
    const fetchAuditorias = async() =>{
        try {
            const response = await fetch("http://localhost:8080/api/solicitudAuditorias")
            if(!response.ok){
            console.log("Error en la respuesta de la solicitud");
            } else {
            console.log("Solicitudes recuperadas correctamente");
            const data = await response.json();
            setSolicitudes(data);
            setSolicitudesFiltradas(data);
        }
        } catch (error) {
            console.log("Error al obtener las solicitudes", error);
        }
    }
    useEffect(() => {
        fetchAuditorias();
    }, []);

    useEffect(() => {
        if(selectedState=="Todos"){
          setSolicitudesFiltradas(solicitudes);
        } else if(selectedState =="En Espera") {
            setSolicitudesFiltradas(solicitudes.filter((solicitud) => solicitud.estadoAsignacion === false));
        } else{
            setSolicitudesFiltradas(solicitudes.filter((solicitud) => solicitud.estadoAsignacion === true));
        }
      }, [selectedState]);
    
    const fetchSolicitante = async(codigo)=>{
        const response = await fetch(`http://localhost:8080/api/usuarios/${codigo}`);
    }

    return (
            <div className="h-full pb-20 flex flex-col font-lato w-full">
                <h1 className="text-3xl text-black mt-4 font-bold ml-7">Solicitudes de Auditorías</h1>
                    <div className="flex mt-4 mx-4 border text-black border-black rounded-3xl p-4 min-h-full flex-col">
                        <div className="flex-1 text-black w-1/3">
                            <label className="block font-bold mb-2">
                                Estado Proceso
                            </label>
                            <select value={selectedState} onChange={(e)=>setSelectedState(e.target.value)} className="border border-gray-300 rounded-lg p-2 w-full">
                                <option value="Todos" >Todos</option>
                                <option value="En Espera" >En Espera</option>
                                <option value="Procesada" >Procesada</option>
                            </select>
                        </div>
                        <div className="h-full overflow-h-auto mt-4 w-full">
                            <table className="min-w-full border-collapse border border-gray-300">
                                <thead className="bg-custom-blue text-white font-normal">
                                    <tr>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal w-2/12">N°</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal">Fecha de Solicitud</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal">Descripcion</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal">Estado Asignación</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal w-2/12">Opciones</th>
                                    </tr>
                                </thead>
                                <tbody className="bg-gray-300">
                                {solicitudes.length === 0 ? (
                                    <tr>
                                        <td colSpan="5" className="border border-gray-300 px-4 py-2 text-center">
                                        No hay solicitudes de auditoria.
                                        </td>
                                    </tr>
                                    ) : (
                                    solicitudesFiltradas.length === 0 ? (
                                        <tr>
                                            <td colSpan="5" className="border border-gray-300 px-4 py-2 text-center">
                                            No hay solicitudes que coincidan con los filtros.
                                            </td>
                                        </tr>
                                        ) : (
                                        solicitudesFiltradas.map((solicitud) => (
                                            <tr className="hover:bg-gray-100" key={solicitud.id}>
                                                <td className="border border-gray-300 px-4 py-2 text-center">{solicitud.codigoSolicitudAuditoria}</td>
                                                <td className="border border-gray-300 px-4 py-2">{formatFecha(solicitud.fechaSolicitudAuditoria)}</td>
                                                <td className="border border-gray-300 px-4 py-2">{solicitud.descripcion}</td>
                                                <td className="border border-gray-300 px-4 py-2 text-center">
                                                    {getEstado(solicitud.estadoAsignacion)}
                                                </td>
                                                <td className="border border-gray-300 px-4 py-2 text-center">
                                                    {solicitud.estadoAsignacion == false && (
                                                        <div className="flex justify-center space-x-4">
                                                            <button onClick={openModalVer}><img src="/images/icon-ojo.png" alt="Asignar Auditor" className="w-6 h-6" /></button>
                                                            <button onClick={openModalAsignar}><img src="/images/icono-personacheck.png" alt="Asignar Auditor" className="w-6 h-6" /></button>
                                                        </div>
                                                    )}
                                                </td>
                                            </tr>
                                        )))
                                    )}
                                </tbody>
                            </table>
                        </div>
                </div>
                <ModalAsignar isOpen={isModalAsignarOpen} onClose={closeModalAsignar} />
                <ModalVer isOpen={isModalVerOpen} onClose={closeModalVer} />
            </div>
    );
}

export default SolicitudesAuditoria;