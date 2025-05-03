import React, { useState } from 'react'; 
import {
    ResizableHandle,
    ResizablePanel,
    ResizablePanelGroup,
  } from "@/components/ui/resizable"
import { ButtonBlue } from "@/components/custom/button"
import { ScrollArea } from "@/components/ui/scroll-area"
import CardMicro from './Card';
import CrearMicroAuditoria from './creacion';


const ModalGestion = ({isOpen, onClose}) => {
    const [visibleMicro, setVisibleMicro] = useState(false);
    const [visibleCreate, setVisibleCreate] = useState(false);
    const [numeroM, setNumeroM] = useState("");
    const [procesoM, setProcesoM] = useState("");
    const [subitemM, setSubitemM] = useState("");
    const [fechaM, setFechaM] = useState("");
    const [auditoriaIniciada, setAuditoriaIniciada] = useState(false);

    const handleSelect = (numero, proceso, subitem, fecha) => {
        setNumeroM(numero);
        setProcesoM(proceso);
        setSubitemM(subitem);
        setFechaM(fecha);
        setVisibleMicro(true);
        setVisibleCreate(false);
    }
    const handleCreate = () => {
        setVisibleCreate(true);
        setVisibleMicro(false);
    }

    const handleClose = () => {
        setVisibleCreate(false);
        setVisibleMicro(false);
        onClose();
    }
    
    const handleStart = () => {
        setAuditoriaIniciada(true);
        setVisibleCreate(false);
        setVisibleMicro(false);
    }

    if (!isOpen) return null;

    return (
        <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 text-black z-50">
            <div className="bg-white rounded-lg shadow-lg w-4/6 p-6 relative h-5/6">
                <div className='w-full flex justify-center mb-6'>
                    <button className="absolute top-2 right-2 text-black text-xl font-bold" onClick={handleClose}>X</button>
                    <h2 className="text-2xl font-bold mb-4">Gestión de auditoría</h2>
                </div>
                <div className='h-5/6'>
                    <ResizablePanelGroup
                        direction="horizontal"
                        className="min-h-full max-w-full rounded-lg border border-black md:min-w-[450px]"
                        >
                        <ResizablePanel defaultSize={40} minSize={20}>
                            { !auditoriaIniciada &&
                                <div className='flex justify-center space-x-3 py-2'>
                                    <ButtonBlue className="px-10" onClick={()=>{handleCreate()}}>Nuevo</ButtonBlue>
                                    <ButtonBlue className="px-4" onClick={handleStart}>Iniciar Auditoria</ButtonBlue>
                                </div>
                            }
                            <ScrollArea className="h-[473px] w-full rounded-md">
                                <CardMicro Numero={"1"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("1","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                <CardMicro Numero={"2"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("2","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                <CardMicro Numero={"3"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("3","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                <CardMicro Numero={"4"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("4","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                <CardMicro Numero={"5"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("5","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                <CardMicro Numero={"6"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("6","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                <CardMicro Numero={"7"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("7","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                <CardMicro Numero={"8"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("8","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                <CardMicro Numero={"9"} Proceso={"Proceso de gestion"} SubItem={"Sub item de ejemplo"} Fecha={"Ahorita"} onClick={()=>{handleSelect("9","Proceso de Gestion", "Subitem de Ejemplo", "HOYYYYY")}}/>
                                
                            </ScrollArea>
                        </ResizablePanel>
                        <ResizableHandle withHandle />
                        <ResizablePanel defaultSize={75} minSize={40}>
                        {visibleMicro && !visibleCreate &&
                            <div className="flex flex-col h-full items-start p-6 w-full">
                                <div className="flex items-center justify-center p-6 w-full">
                                    <h1>Numero: {numeroM}</h1>
                                </div>
                                <div>
                                    <h2>Proceso: {procesoM}</h2>
                                </div>
                                <div>
                                    <h2>SubItem: {subitemM}</h2>
                                </div>
                                <div>
                                    <h2>Fecha: {fechaM}</h2>
                                </div>
                            </div>
                        }
                        {visibleCreate && !visibleMicro &&
                            <CrearMicroAuditoria/>
                        }
                        </ResizablePanel>
                    </ResizablePanelGroup>
                </div>
            </div>
        </div>
    );
}

export default ModalGestion;