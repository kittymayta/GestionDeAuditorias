import React, { useState, useEffect } from 'react'; 
import ModalAudi from "../Auditor/components/ModalAudi";
import ModalGestion from "./components/ModalGestion";

const Auditoria = () =>{
    const [isModalAudiOpen, setIsModalAudiOpen] = useState(false);
    const [isModalGesOpen, setIsModalGesOpen] = useState(false);

    const openModalAudi = () => setIsModalAudiOpen(true);
    const closeModalAudi = () => setIsModalAudiOpen(false);
    const openModalGes = () => setIsModalGesOpen(true);
    const closeModalGes = () => setIsModalGesOpen(false);

    return(
            <div className="min-h-screen flex flex-col font-lato w-full">
                <h1 className="text-3xl text-black mt-4 font-bold ml-7">Lista de Auditorias</h1>
                    <div className="overflow-x-auto mt-5 mx-6 text-black">
                        <table className="w-full border-collapse border border-gray-300">
                            <thead className="bg-custom-blue text-white font-normal">
                            <tr>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal w-2/12">N°</th>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Nombre Auditoria</th>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Nombre</th>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Lab/Ins</th>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal">Estado</th>
                                <th className="border border-gray-300 px-4 py-2 text-left font-normal w-2/12">Opciones</th>
                            </tr>
                            </thead>
                            <tbody className="bg-gray-300">
                                <tr>
                                    <td className="border border-gray-300 px-4 py-2 text-center">123456789</td>
                                    <td className="border border-gray-300 px-4 py-2">Auditoria</td>
                                    <td className="border border-gray-300 px-4 py-2">Alfredo Aguirre</td>
                                    <td className="border border-gray-300 px-4 py-2">Instituto de Materiales</td>
                                    <td className="border border-gray-300 px-4 py-2">
                                        <div className="bg-yellow-300 border rounded-full flex text-center justify-center text-white">Iniciada</div>
                                    </td>
                                    <td className="border border-gray-300 px-4 py-2 text-center flex items-center justify-center space-x-3">
                                        <button onClick={openModalAudi}><img src="/images/incono_lupa.png" alt="Asignar Auditor" className="w-6 h-6" /></button>
                                        <button onClick={openModalGes}><img src="/images/icon-interroga.png" alt="Procesos" className="w-6 h-6" /></button>
                                    </td>
                                </tr>
                                <tr>
                                    <td className="border border-gray-300 px-4 py-2 text-center">123456789</td>
                                    <td className="border border-gray-300 px-4 py-2">Auditoria</td>
                                    <td className="border border-gray-300 px-4 py-2">Alfredo Aguirre</td>
                                    <td className="border border-gray-300 px-4 py-2">Instituto de Materiales</td>
                                    <td className="border border-gray-300 px-4 py-2">
                                        <div className="bg-yellow-300 border rounded-full flex text-center justify-center text-white">Iniciada</div>
                                    </td>
                                    <td className="border border-gray-300 px-4 py-2 text-center flex items-center justify-center space-x-3">
                                        <button onClick={openModalAudi}><img src="/images/incono_lupa.png" alt="Asignar Auditor" className="w-6 h-6" /></button>
                                        <button onClick={openModalGes}><img src="/images/icon-interroga.png" alt="Procesos" className="w-6 h-6" /></button>
                                    </td>
                                </tr>
                                <tr>
                                    <td className="border border-gray-300 px-4 py-2 text-center">123456789</td>
                                    <td className="border border-gray-300 px-4 py-2">Auditoria</td>
                                    <td className="border border-gray-300 px-4 py-2">Alfredo Aguirre</td>
                                    <td className="border border-gray-300 px-4 py-2">Instituto de Materiales</td>
                                    <td className="border border-gray-300 px-4 py-2">
                                        <div className="bg-yellow-300 border rounded-full flex text-center justify-center text-white">Iniciada</div>
                                    </td>
                                    <td className="border border-gray-300 px-4 py-2 text-center flex items-center justify-center space-x-3">
                                        <button onClick={openModalAudi}><img src="/images/incono_lupa.png" alt="Asignar Auditor" className="w-6 h-6" /></button>
                                        <button onClick={openModalGes}><img src="/images/icon-interroga.png" alt="Procesos" className="w-6 h-6" /></button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <ModalAudi isOpen={isModalAudiOpen} onClose={closeModalAudi}  />
                    <ModalGestion isOpen={isModalGesOpen} onClose={closeModalGes}  />
                </div>
    );
}
export default Auditoria;