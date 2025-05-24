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
import { SquareX } from 'lucide-react';

export const ModalDesaprobar = ({procesoDesaprobar}) => {
  const [open, setOpen] = useState(false);

  const aprobarProceso = async() =>{
    const data = {
      nombre: procesoDesaprobar.nombre,
      descripcion: procesoDesaprobar.descripcion,
      codigoEntidad: procesoDesaprobar.codigoEntidad,
      estado: "Desaprobado"
    };
    try {
      const url = `http://localhost:8080/api/procesos/update/${procesoDesaprobar.codigoProceso}`;
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
      <button onClick={() => setOpen(true)}><SquareX className="w-6 h-6" /></button>
      <Dialog className="text-lg" open={open} onOpenChange={setOpen}>
        <DialogTrigger />
        <DialogContent className="bg-white rounded-lg shadow-lg text-xl"> 
          <DialogHeader>
            <DialogTitle className="text-black">Desaprobar proceso</DialogTitle>
          </DialogHeader>
            <h1 className="text-black text-lg">Seguro que desea desaprobar este proceso</h1>
            <div className="mt-6 flex justify-center">
                <ButtonGray  className="mr-24 w-40" onClick={() => setOpen(false)}>Cancelar</ButtonGray>
                <ButtonBlue className="ml-2 w-40" onClick={() => {
                aprobarProceso();
                setOpen(false); 
                }}>
                Desaprobar
                </ButtonBlue>
            </div>
        </DialogContent>
      </Dialog>
    </>
  );
};