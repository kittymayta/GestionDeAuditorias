import React, { useState } from 'react';
import { ButtonBlue } from "@/components/custom/button";
import {
  ResizableHandle,
  ResizablePanel,
  ResizablePanelGroup,
} from "@/components/ui/resizable";
import { Button } from "@/components/ui/button";
import { ScrollArea } from "@/components/ui/scroll-area";
import Tarjeta from './components/tarjeta';

const auditoriaData = [
  { id: 1, numero: "001" },
  { id: 2, numero: "002" },
  { id: 3, numero: "003" },
  { id: 4, numero: "004" },
  { id: 5, numero: "005" },
  { id: 6, numero: "006" },
  { id: 7, numero: "007" },
  { id: 8, numero: "008" },
  { id: 9, numero: "009" },
  { id: 10, numero: "010" }
];

const AuditoriaAuditorInterno = () => {
  const [selectedAuditoria, setSelectedAuditoria] = useState(null);

  const handleTarjetaClick = (auditoria) => {
    setSelectedAuditoria(auditoria);
  };

  return (
    <div className="flex items-center justify-center min-h-screen flex-col w-full pr-6 pt-8">
      <h2 className="text-center text-2xl font-semibold mb-4">Auditorias Proceso</h2>
      
      <div className="w-full p-4 bg-white shadow-lg rounded-lg border border-black">
        <div className="flex justify-between mb-4 w-full flex-col">
          <label>Seleccione una Auditoria</label>
          <select className="w-1/2 mr-2 p-2 border border-gray-300 rounded-lg" onChange={(e) => handleTarjetaClick(auditoriaData.find(audit => audit.id === parseInt(e.target.value)))}>
            {auditoriaData.map((audit) => (
              <option key={audit.id} value={audit.id}>
                Auditoria {audit.numero}
              </option>
            ))}
          </select>
        </div>

          <ResizablePanelGroup
            direction="horizontal"
            className="min-h-[400px] max-w-full bg-white border border-t-black border-x-white border-b-white"
          >
            <ResizablePanel defaultSize={25} minSize={20} className="h-[601px]">
              <ScrollArea className="h-full w-full border-r border-gray-300 overflow-auto">
                <div className="flex flex-col h-full w-full">
                  {auditoriaData.map((auditoria) => (
                    <Button
                      key={auditoria.id}
                      variant="outline"
                      className="w-full h-auto bg-white hover:bg-slate-200 border-0 m-0 p-0 flex-grow mb-0"
                      onClick={() => handleTarjetaClick(auditoria)}
                    >
                      <Tarjeta numero={auditoria.numero} />
                    </Button>
                  ))}
                </div>
              </ScrollArea>
            </ResizablePanel>

            <ResizableHandle withHandle className="bg-black" />

            <ResizablePanel defaultSize={75} minSize={40}>
              <div className="flex h-full flex-col items-start justify-start p-6 space-y-6">
                {selectedAuditoria ? (
                  <>
                    <div className="space-y-2 w-full">
                      {[
                        { label: "Proceso", value: `Auditoría ${selectedAuditoria.numero}` },
                        { label: "Auditor Líder", value: "Nombre del Auditor" },
                        { label: "Fecha", value: "2024-01-15" },
                        { label: "Item", value: "Ejemplo de Item" },
                        { label: "Sub Item", value: "Ejemplo de Sub Item" },
                      ].map((field, index) => (
                        <div key={index} className="flex items-center space-x-2"> {/* Reducir el espacio horizontal */}
                          <span className="font-semibold w-1/4">{field.label}:</span>
                          <div className="border border-gray-300 p-2 rounded-md flex-1 bg-gray-100">
                            {field.value}
                          </div>
                        </div>
                      ))}
                    </div>

                    <div className="mt-8 w-full">
                      <table className="table-auto w-full border border-gray-300">
                        <thead>
                          <tr className="bg-gray-200">
                            <th className="p-2 border border-gray-300 text-left">Preguntas</th>
                            <th className="p-2 border border-gray-300 text-left">Etiqueta</th>
                            <th className="p-2 border border-gray-300 text-left">Observaciones</th>
                          </tr>
                        </thead>
                        <tbody>
                          {[
                            { pregunta: "¿La documentación está completa?", etiqueta: "Pendiente", observaciones: "Revisar documentos faltantes" },
                            { pregunta: "¿Los procesos están definidos?", etiqueta: "Aprobado", observaciones: "Cumple con los requisitos" },
                            { pregunta: "¿Existen registros actualizados?", etiqueta: "Rechazado", observaciones: "Actualizar registros antiguos" },
                          ].map((row, index) => (
                            <tr key={index}>
                              <td className="p-2 border border-gray-300">{row.pregunta}</td>
                              <td className="p-2 border border-gray-300">
                                <select className="border border-gray-300 p-1 rounded-md w-full">
                                  <option value="Pendiente" selected={row.etiqueta === "Pendiente"}>Pendiente</option>
                                  <option value="Aprobado" selected={row.etiqueta === "Aprobado"}>Aprobado</option>
                                  <option value="Rechazado" selected={row.etiqueta === "Rechazado"}>Rechazado</option>
                                </select>
                              </td>
                              <td className="p-2 border border-gray-300">{row.observaciones}</td>
                            </tr>
                          ))}
                        </tbody>
                      </table>
                    </div>
                    <div className="flex justify-center items-center w-full mt-4">
                      <ButtonBlue className="p-3 px-20 text-center text-lg">Cargar</ButtonBlue>
                    </div>

                  </>
                ) : (
                  <span className="font-semibold">Seleccione una auditoría para ver los detalles</span>
                )}
              </div>
            </ResizablePanel>
        </ResizablePanelGroup>
      </div>
    </div>
  );
};

export default AuditoriaAuditorInterno;

