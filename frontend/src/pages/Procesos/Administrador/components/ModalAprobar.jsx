import { useState } from "react";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { ButtonBlue, ButtonGray } from "@/components/custom/button";
import { SquareCheckBig } from 'lucide-react';

export const ModalAprobar = ({procesoAprobar}) => {
  const [open, setOpen] = useState(false);

  const aprobarProceso = async() =>{
    const data = {
      nombre: procesoAprobar.nombre,
      descripcion: procesoAprobar.descripcion,
      codigoEntidad: procesoAprobar.codigoEntidad,
      estado: "Aprobado"
    };
    try {
      const url = `http://localhost:8080/api/procesos/update/${procesoAprobar.codigoProceso}`;
      const method = 'POST';
      const response = await fetch(url, {
        method,
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      });
      if(!response.ok){
        console.log("Error al aprobar el proceso")
      } else {
        console.log("Proceso aprobado correctamente");
      }
    } catch (error) {
      console.log("Error en la solicitud", error)
    }
  }

  return (
    <>
      <button onClick={() => setOpen(true)}><SquareCheckBig className="w-6 h-6" /></button>
      <Dialog className="text-lg" open={open} onOpenChange={setOpen}>
        <DialogTrigger />
        <DialogContent className="bg-white rounded-lg shadow-lg text-xl"> 
          <DialogHeader>
            <DialogTitle className="text-black">Aprobar proceso</DialogTitle>
          </DialogHeader>
            <h1 className="text-black text-lg">Seguro que desea aprobar este proceso</h1>
            <div className="mt-6 flex justify-center">
                <ButtonGray  className="mr-24 w-40" onClick={() => setOpen(false)}>Cancelar</ButtonGray>
                <ButtonBlue className="ml-2 w-40" onClick={() => {
                aprobarProceso();
                setOpen(false); 
                }}>
                Aprobar
                </ButtonBlue>
            </div>
        </DialogContent>
      </Dialog>
    </>
  );
};