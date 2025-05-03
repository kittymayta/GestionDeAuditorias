import React, { useState, useEffect } from 'react'; 
import { ButtonBlue } from '@/components/custom/button';

const CrearAuditoria = ({isOpen, onClose}) =>{

    if (!isOpen) return null;

    return(
        <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 text-black z-50">
            <div className="bg-white rounded-lg shadow-lg w-2/6 max-w-4xl p-6 relative">
                <button className="absolute top-2 right-2 text-black text-xl font-bold" onClick={onClose}>X</button>
                <h1 className="text-2xl font-bold mb-4">Crear auditoria</h1>
                <p>Laboratorio/Instituto</p>
                <select className="border border-gray-300 rounded-lg p-2 w-full mt-4 mb-4">
                    <option value="1">Lab</option>
                    <option value="2">Ins</option>
                    <option value="3">Ins</option>
                    <option value="4">Lab</option>
                </select>
                <p>Auditor Lider</p>
                <select className="border border-gray-300 rounded-lg p-2 w-full mt-4 mb-4">
                    <option value="1">Auditor Lider 1</option>
                    <option value="2">Auditor Lider 2</option>
                    <option value="3">Auditor Lider 3</option>
                    <option value="4">Auditor Lider 4</option>
                </select>
                <div className='w-full flex justify-end'>
                    <ButtonBlue className="px-6">Asignar</ButtonBlue>
                </div>
            </div>
        </div>
    );
}
export default CrearAuditoria;