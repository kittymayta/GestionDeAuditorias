import React, { useState, useEffect } from 'react'; 


const VerSoli = ({isOpen, onClose}) =>{

    if (!isOpen) return null;

    return(
        <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 text-black z-50">
            <div className="bg-white rounded-lg shadow-lg w-2/6 max-w-4xl p-6 relative">
            <button className="absolute top-2 right-2 text-black text-xl font-bold" onClick={onClose}>X</button>
            <div className='flex space-x-6'>
                            <div className="mb-4 w-1/2">
                                <label className="block mb-2 font-bold">Nombre:</label>
                                <input value="Carlos Zambrano Royola" type="text" id="nombre" className="mt-1 block w-full border border-gray-300 rounded-md p-2" placeholder="Ingrese su nombre" />
                            </div>
                            <div className="mb-4 w-1/2">
                                <label className="block mb-2 font-bold">Cargo:</label>
                                <input value="Coordinador" type="text" id="cargo" className="mt-1 block w-full border border-gray-300 rounded-md p-2" placeholder="Ingrese su cargo" />
                            </div>
                        </div>
                        <div className='flex'>
                            <div className="mb-4 w-full">
                                <label className="block mb-2 font-bold">Laboratorio:</label>
                                <input value="Instituto de Investigación Geofísica de la UNSA-IDIGUNSA" type="text" id="laboratorio" className="mt-1 block w-full border border-gray-300 rounded-md p-2" placeholder="Ingrese el laboratorio" />
                            </div>
                        </div>
                        <div className="mb-4">
                            <label className="block mb-2 font-bold">Comentarios:</label>
                            <textarea value="Quisiera una auditoria para mi instituto" id="comentarios" className="mt-1 block w-full border border-gray-300 rounded-md p-2" placeholder="Ingrese sus comentarios"></textarea>
                        </div>
            </div>
        </div>
    );
}
export default VerSoli;