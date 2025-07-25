import React, { useState, useEffect } from 'react'; 
import { ButtonBlue } from '@/components/custom/button';

const AsignarAuditor = ({isOpen, onClose}) =>{
    const [lideres, setLideres] = useState([]);



    useEffect(() => {
        if (isOpen) {
            fetchLideres();
        }
    }, [isOpen]);

    const fetchLideres = async()=>{
        try {
            const response = await fetch("http://localhost:8080/api/usuarios/tipoUsuario/4")
            if (response.ok) {
                console.log("Lideres auditores obtenidos correctamente")
                const data = await response.json();
                setLideres(data);
            } else {
                console.log("Error en la respuesta")
            }
        } catch (error) {
            console.log("Error al hacer fetch", error)
        }
    }
    useEffect(() => {
        console.log("Lideres actualizados:", lideres);
    }, [lideres]);

    if (!isOpen) return null;
    return(
        <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 text-black z-50">
            <div className="bg-white rounded-lg shadow-lg w-2/6 max-w-4xl p-6 relative">
                <button className="absolute top-2 right-2 text-black text-xl font-bold" onClick={onClose}>X</button>
                <h1 className="text-2xl font-bold mb-4">Crear auditoria por solicitud</h1>
                <p>Seleccione el auditor lider correspondiente a la solicitud</p>
                <select className="border border-gray-300 rounded-lg p-2 w-full mt-4 mb-4">
                    {lideres.map((lider)=>(
                        <option value={lider.codigoUsuario}>{lider.nombreUsuario} {lider.apellidoPat} {lider.apellidoMat}</option>
                    ))}
                </select>
                <p>Seleccione la norma ISO</p>
                <select className="border border-gray-300 rounded-lg p-2 w-full my-4">
                    <option value="1">ISO 9001</option>
                    <option value="2">ISO 17025</option>
                    <option value="3">ISO 21001</option>
                </select>
                <div className='w-full flex justify-end'>
                    <ButtonBlue className="px-6">Asignar</ButtonBlue>
                </div>
            </div>
        </div>
    );
}
export default AsignarAuditor;