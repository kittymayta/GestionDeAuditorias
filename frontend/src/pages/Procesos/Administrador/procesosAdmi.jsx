import { SquareCheckBig, SquareX  } from 'lucide-react';
import { useState, useEffect } from 'react';
import { ModalAprobar } from './components/ModalAprobar';
import { ModalDesaprobar } from './components/ModalDesaprobar';

const ProcesosAdministrador = () => {
  const [entidades, setEntidades] = useState([]);
  const [selectedEntity, setSelectedEntity] = useState(1);
  const [procesos, setProcesos] = useState([]);
  const [selectedState, setSelectedState] = useState("Todos");
  const [procesosFiltrados, setProcesosFiltrados] = useState([]);  

  useEffect(() => {
    fetchEntidades();
    fetchProcesos(selectedEntity);
  }, [selectedEntity]);

  useEffect(() => {
    if(selectedState=="Todos"){
      setProcesosFiltrados(procesos);
    } else {
      setProcesosFiltrados(procesos.filter((proceso) => proceso.estado === selectedState));
    }
  }, [selectedState]);

  const getEstadoStyle = (estado) => {
    switch (estado) {
      case "Sin enviar":
        return "bg-gray-500 text-white";
      case "En evaluación":
        return "bg-yellow-400 text-white";
      case "Aprobado":
        return "bg-green-500 text-white";
      case "Desaprobado":
        return "bg-red-500 text-white";
      default:
        return "";
    }
  };

  const handleOptionChange = (e) => {
    const selectedId = e.target.value;
    setSelectedEntity(parseInt(selectedId));
  };
  const handleOptionStateChange = (e) => {
    setSelectedState(e.target.value);
  };

  const fetchProcesos = async(codigoEntidad) =>{
    try{
        const response = await fetch(`http://localhost:8080/api/procesos/entidad/${codigoEntidad}`)
        if (!response.ok) {
            throw new Error('Error en la red');
        } else {
            const data = await response.json();
            setProcesos(data);
            setProcesosFiltrados(data);
            console.log("Procesos obtenidas correctamente");
        }
    } catch(error){
        console.error('Error fetching entities: ', error);
    }
  }
  
  const fetchEntidades = async() => {
    try{
        const response = await fetch('http://localhost:8080/api/entidades')
        if (!response.ok) {
            throw new Error('Error en la red');
        } else {
            const data = await response.json();
            setEntidades(data);
            console.log("Entidades obtenidas correctamente");
        }
    } catch(error){
        console.error('Error fetching procedures: ', error);
    }
}

  return (
    <div className="h-full flex flex-col p-4">
      <h1 className="text-3xl text-black text-left mt-4 font-bold">
        Procesos de Laboratorios e Institutos
      </h1>
      <div className="flex-grow mt-4 mx-2 border text-black border-black rounded-3xl p-4"> 
        <div className='flex space-x-4'>
            <div className="flex-1 text-black w-1/3">
                <label className="block font-bold mb-2">
                    Laboratorio/Instituto
                </label>
                <select
                    value={selectedEntity}
                    onChange={handleOptionChange}
                    className="border border-gray-300 rounded-lg p-2 w-full"
                >
                    {entidades.map((entity) => (
                    <option key={entity.id} value={entity.codigoEntidad}>
                        {entity.nombreEntidad}
                    </option>
                    ))}
                </select>
            </div>
            <div className="flex-1 text-black w-1/3">
                <label className="block font-bold mb-2">
                    Estado Proceso
                </label>
                <select
                    value={selectedState}
                    onChange={handleOptionStateChange}
                    className="border border-gray-300 rounded-lg p-2 w-full"
                >
                    <option value={"Todos"}>
                        Todos
                    </option>
                    <option value={"En evaluación"}>
                        En evaluación
                    </option>
                    <option value={"Aprobado"}>
                        Aprobados
                    </option>
                    <option value={"Desaprobado"}>
                        Desaprobados
                    </option>
                    {/*<option value={"Sin enviar"}>
                        Sin enviar
                    </option>*/}
                </select>
            </div>
        </div>
        <div className="overflow-x-auto mt-4 text-base">
          <table className="min-w-full border-collapse border border-gray-300">
            <thead className="bg-custom-blue text-white">
              <tr>
                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Codigo</th>
                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Nombre</th>
                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Descripción</th>
                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Estado de Asignación</th>
                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Opciones</th>
              </tr>
            </thead>
            <tbody>
            {procesos.length === 0 ? (
                  <tr>
                    <td colSpan="5" className="border border-gray-300 px-4 py-2 text-center">
                      No hay procesos para esta entidad.
                    </td>
                  </tr>
                ) : (
                  procesosFiltrados.length === 0 ? (
                    <tr>
                        <td colSpan="5" className="border border-gray-300 px-4 py-2 text-center">
                        No hay procesos que coincidan con los filtros.
                        </td>
                    </tr>
                    ) : (
                      procesosFiltrados
                      .filter((proceso) => proceso.estado !== "Sin enviar")
                      .map((proceso) => (
                        <tr className="hover:bg-gray-100" key={proceso.codigoProceso}>
                          <td className="border border-gray-300 px-4 py-2">{proceso.codigoProceso}</td>
                          <td className="border border-gray-300 px-4 py-2">{proceso.nombre}</td>
                          <td className="border border-gray-300 px-4 py-2">{proceso.descripcion}</td>
                          <td className="border border-gray-300 px-4 py-2 text-center">
                            <div className={`border rounded-full px-3 py-1 ${getEstadoStyle(proceso.estado)}`}>
                              {proceso.estado}
                            </div>
                          </td>
                          <td className="border border-gray-300 px-4 py-2 text-center">
                            {proceso.estado === "En evaluación" && (
                              <div className="flex justify-center space-x-4">
                                <ModalAprobar procesoAprobar={proceso} />
                                <ModalDesaprobar procesoDesaprobar={proceso} />
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
    </div>
  );
};

export default ProcesosAdministrador;