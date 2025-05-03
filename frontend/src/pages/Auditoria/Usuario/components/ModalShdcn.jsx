import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"
import { ButtonBlue, ButtonGray } from "@/components/custom/button"
 
export function NuevaSolicitud() {
  return (
    <Dialog>
      <DialogTrigger asChild>
        <ButtonBlue className="w-w-68 rounded-lg py-2 px-4 mr-4">Nuevo</ButtonBlue>
      </DialogTrigger>
      <DialogContent className="sm:max-w-4xl bg-white text-black">
        <DialogHeader>
          <DialogTitle>Nueva Solicitud de Auditoria</DialogTitle>
          <DialogDescription>
            En este espacio usted puede solicitar una auditoria para su Laboratorio/Instituto correspondiente.
          </DialogDescription>
        </DialogHeader>
            {/* Cuadros para mostrar datos */}
            <div className="mt-4">
                {/* Títulos y datos en cuadros */}
                <div className="flex mb-4">
                    <div className="w-1/2 mr-5">
                        <h3 className="font-semibold mb-1">Nombre</h3>
                        <div className="border border-black p-2 rounded-lg text-black">
                            <p>Carlos Zambrano Royola</p>
                        </div>
                    </div>
                    <div className="w-1/2">
                        <h3 className="font-semibold mb-1">Cargo</h3>
                        <div className="border border-black p-2 rounded-lg text-black">
                            <p>Coordinador de Laboratorio</p>
                        </div>
                    </div>
                </div>
                <div className="w-1/2 mr-5">
                    <h3 className="font-semibold mb-1">Laboratorio/Instituto</h3>
                    <div className="border border-black p-2 rounded-lg text-black">
                        <p>Lab. de Investigación y servicios espectroscópicos con equipos para determinación de estructuras químicas</p>
                    </div>
                </div>
            </div>
            {/* Cuadro de entrada para comentarios */}
            <h3 className="font-semibold mb-1">Comentario</h3>
            <textarea className="w-full h-24 p-2 rounded-lg  border border-gray-700" />
        <DialogFooter className="sm:justify-center">
          <DialogClose asChild>
            <ButtonGray className="w-52 mr-8">Close</ButtonGray>
          </DialogClose>
          <ButtonBlue className="w-52">Guardar</ButtonBlue>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  )
}