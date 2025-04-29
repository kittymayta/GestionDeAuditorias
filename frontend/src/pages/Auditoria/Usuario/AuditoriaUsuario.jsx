import { NuevaSolicitud } from "./components/ModalShdcn";
import { useState, useEffect } from "react";

const Auditoria = () => {
    const [usuario, setUsuario] = useState([]);
    useEffect(() => {
        const usuarioStorage = localStorage.getItem("usuario");
        const usuarioParsed = JSON.parse(usuarioStorage);
        setUsuario(usuarioParsed);
    }, []);

    return (
        <div className="w-full">
            <div className="flex items-center justify-between mt-4">
                <h1 className="text-3xl text-black font-bold ml-4">Pedir Una Auditoría</h1>
                <NuevaSolicitud className="w-w-68"/>
            </div>

            <div className="min-h-screen flex flex-col p-4 text-black">
                <div className="overflow-x-auto mt-6">
                    <table className="min-w-full border-collapse border border-gray-300">
                        <thead className="bg-custom-blue text-white">
                            <tr>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal w-1/6">Número</th>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Nombre</th>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal w-1/6">Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td className="border border-gray-300 px-4 py-2">2312321783</td>
                                <td className="border border-gray-300 px-4 py-2">DOC-Auditoria del Grupo de Laboratorio 90232</td>
                                <td className="border border-gray-300 px-4 py-2 flex justify-center">
                                    <img src="/images/pendiente.png" alt="Pendiente" className="w-6 h-6" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    );
};

export default Auditoria;
