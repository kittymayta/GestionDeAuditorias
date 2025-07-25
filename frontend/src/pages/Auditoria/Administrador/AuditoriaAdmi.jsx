import React, { useState, useEffect } from 'react'; 
import ModalCrear from '../Administrador/components/ModalCrear';

const Auditoria = () => {
    const [isModalCrearOpen, setIsModalCrearOpen] = useState(false);

    const openModalCrear = () => setIsModalCrearOpen(true);
    const closeModalCrear = () => setIsModalCrearOpen(false);

    return (
            <div className="min-h-screen flex flex-col font-lato w-full">
                <h1 className="text-3xl text-black mt-4 font-bold ml-7">Solicitud de Auditorías</h1>
                <div className="flex-grow mt-4 mx-4 border text-black border-black rounded-3xl p-4">
                        <div className="w-full flex flex-auto">
                            <h2 className="text-2xl text-black mt-2 font-bold ml-7 mr-80">Auditorías</h2>
                            <button 
                                className="w-w-68 bg-custom-blue text-white rounded-lg py-2 px-4 mr-4 ml-96"
                                onClick={openModalCrear}
                            >
                                Crear Auditoría
                            </button>
                        </div>
                        {/* Segunda tabla */}
                        <div className="h-1/2 overflow-y-auto mt-4">
                            <table className="min-w-full border-collapse border border-gray-300">
                                <thead className="bg-custom-blue text-white font-normal">
                                    <tr>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal w-2/12">N°</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal">Nombre Auditoria</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal">Lab/Ins</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal">Auditor</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal w-2/12">Nombre</th>
                                        <th className="border border-gray-300 px-4 py-2 text-left font-normal w-2/12">Estado Auditor</th>
                                    </tr>
                                </thead>
                                <tbody className="bg-gray-300">
                                    <tr>
                                        <td className="border border-gray-300 px-4 py-2 text-center">987654321</td>
                                        <td className="border border-gray-300 px-4 py-2">Auditoria de procesos</td>
                                        <td className="border border-gray-300 px-4 py-2">Instituto NEXUS de la UNSA</td>
                                        <td className="border border-gray-300 px-4 py-2">Juan Gonzales</td>
                                        <td className="border border-gray-300 px-4 py-2">Ernesto Aguirre</td>
                                        <td className="border border-gray-300 px-4 py-2">
                                            <div className="bg-yellow-300 border rounded-full flex text-center justify-center text-white">Iniciada</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td className="border border-gray-300 px-4 py-2 text-center">987654321</td>
                                        <td className="border border-gray-300 px-4 py-2">Auditoria de procesos</td>
                                        <td className="border border-gray-300 px-4 py-2">Instituto NEXUS de la UNSA</td>
                                        <td className="border border-gray-300 px-4 py-2">Juan Gonzales</td>
                                        <td className="border border-gray-300 px-4 py-2">Ernesto Aguirre</td>
                                        <td className="border border-gray-300 px-4 py-2">
                                            <div className="bg-green-800 border rounded-full flex text-center justify-center text-white">En Proceso</div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                    </div>
                </div>
                <ModalCrear isOpen={isModalCrearOpen} onClose={closeModalCrear} />
            </div>
    );
}

export default Auditoria;