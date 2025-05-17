import { ModalProcesosCoordinador } from "./components/ModalProceso";
import { ModalEditarProceso } from "./components/ModalEditar";
import { ModalEliminarProceso } from "./components/ModalEliminar";
import { ModalEnviarProceso } from "./components/ModalEnviar";
import { useState, useEffect } from 'react';
import {
  Select,
  SelectContent,
  SelectGroup,
  SelectItem,
  SelectLabel,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select'; // Asegúrate de que la ruta es correcta
import { set } from "date-fns";

const ProcesosCoordinador = () => {
  const [estadoFiltro, setEstadoFiltro] = useState("Todos");
  const [usuario, setUsuario] = useState([]);
  const [procesos, setProcesos]=useState([]);
  const [procesosFiltrados, setProcesosFiltrados]=useState([]);
  const [entidad, setEntidad] = useState(null);

  useEffect(() => {
    const usuarioStorage = localStorage.getItem("usuario");
    const usuarioParsed = JSON.parse(usuarioStorage);
    setUsuario(usuarioParsed);
  }, []);

  useEffect(()=>{
    fetchProcesos(usuario.entidad?.codigoEntidad);
    setEntidad(usuario.entidad?.codigoEntidad)
  },[usuario])


  const fetchProcesos = async(codigoEntidad) =>{
    console.log("Entidad a buscar: ", codigoEntidad);
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

  const getEstadoStyle = (estado) => {
    switch (estado) {
      case "Sin enviar":
        return "bg-gray-500 text-white"; // gris medio oscuro
      case "En evaluación":
        return "bg-yellow-400 text-white"; // amarillo
      case "Aprobado":
        return "bg-green-500 text-white"; // verde
      case "Desaprobado":
        return "bg-red-500 text-white"; // rojo
      default:
        return "";
    }
  };

  const handleFiltroChange = (value) => {
    setEstadoFiltro(value);
    if(value == "Todos"){
      setProcesosFiltrados(procesos);
    } else {
      setProcesosFiltrados(procesos.filter((proceso) => proceso.estado === value));
    }
  };

  return (
    <div className="h-full flex flex-col p-4 w-full">
      <h1 className="text-3xl text-black text-left mt-4 font-bold">
        Creación de procesos
      </h1>
      <div className="flex-grow mt-4 mx-2 border text-black border-black rounded-3xl p-4"> 
      {/* wii */}
      <div className="flex items-center mt-4">
      {/* Selector alineado a la izquierda */}
      <Select onValueChange={handleFiltroChange} value={estadoFiltro}>
        <SelectTrigger className="border border-gray-400 rounded p-4 text-lg w-48 bg-gray-100 text-gray-700">
          <SelectValue placeholder="Seleccionar estado" />
        </SelectTrigger>
        <SelectContent className="bg-white border border-gray-300 rounded shadow-lg">
          <SelectGroup>
            <SelectItem value="Todos" className="text-gray-700 hover:bg-gray-200">Todos</SelectItem>
            <SelectItem value="Sin enviar" className="text-gray-700 hover:bg-gray-200">Sin enviar</SelectItem>
            <SelectItem value="En evaluación" className="text-gray-700 hover:bg-gray-200">En Evaluación</SelectItem>
            <SelectItem value="Aprobado" className="text-gray-700 hover:bg-gray-200">Aprobada</SelectItem>
            <SelectItem value="Desaprobado" className="text-gray-700 hover:bg-gray-200">Desaprobado</SelectItem>
          </SelectGroup>
        </SelectContent>
      </Select>

      {/* Botón del modal alineado a la derecha */}
      <div className="ml-auto">
        <ModalProcesosCoordinador codigoEntidad={entidad}/>
      </div>
    </div>

        <div className="overflow-x-auto mt-4 text-base">
          <table className="min-w-full border-collapse border border-gray-300">
            <thead className="bg-custom-blue text-white">
              <tr>
                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Codigoº</th>
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
                    procesosFiltrados.map((proceso) => (
                    <tr className="hover:bg-gray-100">
                        <td className="border border-gray-300 px-4 py-2">{proceso.codigoProceso}</td>
                        <td className="border border-gray-300 px-4 py-2">{proceso.nombre}</td>
                        <td className="border border-gray-300 px-4 py-2">{proceso.descripcion}</td>
                        <td className="border border-gray-300 px-4 py-2 text-center">
                            <div className={`border rounded-full px-3 py-1 ${getEstadoStyle(proceso.estado)}`}>{proceso.estado}</div>
                        </td>
                        <td className="border border-gray-300 px-4 py-2 text-center">
                            {proceso.estado === "Sin enviar" && (
                              <div className="flex justify-center space-x-2">
                                <ModalEditarProceso procesoEditar={proceso}/>
                                <ModalEliminarProceso procesoEliminar={proceso}/>
                                <ModalEnviarProceso procesoEnviar={proceso}/>
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

export default ProcesosCoordinador;