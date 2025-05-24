import { ButtonBlue, ButtonGray } from "@/components/custom/button";

const CrearMicroAuditoria = () => {
    return (
        <div className="flex flex-col h-full items-start p-6 w-full space-y-4">
            <div className="mb-4 flex align-middle justify-center items-center w-full">
                <h1 className="text-xl font-bold">Crear Auditoría - Proceso</h1>
            </div>
            <div className="grid grid-cols-2 gap-4 w-full">
                <div className="flex items-center">
                    <label className="block font-bold mr-4">Proceso:</label>
                    <select className="border border-gray-300 rounded-lg p-2 w-full">
                        <option value="1">Proceso 1</option>
                        <option value="2">Proceso 2</option>
                        <option value="3">Proceso 3</option>
                        <option value="4">Proceso 4</option>
                    </select>
                </div>
                <div className="flex items-center">
                    <label className="block font-bold mr-4">Ítem:</label>
                    <select className="border border-gray-300 rounded-lg p-2 w-full">
                        <option value="1">Ítem 1</option>
                        <option value="2">Ítem 2</option>
                        <option value="3">Ítem 3</option>
                        <option value="4">Ítem 4</option>
                    </select>
                </div>
                <div className="flex items-center">
                    <label className="block font-bold mr-4">SubItem:</label>
                    <select className="border border-gray-300 rounded-lg p-2 w-full">
                        <option value="1">SubItem 1</option>
                        <option value="2">SubItem 2</option>
                        <option value="3">SubItem 3</option>
                        <option value="4">SubItem 4</option>
                    </select>
                </div>
                <div className="flex items-center">
                    <label className="block font-bold mr-4">Fecha y Hora:</label>
                    <input type="datetime-local" className="border border-gray-300 rounded-lg p-2 w-full"/>
                </div>
                <div className="flex items-center">
                    <label className="block font-bold mr-4">Auditor:</label>
                    <select className="border border-gray-300 rounded-lg p-2 w-full">
                        <option value="1">Auditor 1</option>
                        <option value="2">Auditor 2</option>
                        <option value="3">Auditor 3</option>
                        <option value="4">Auditor 4</option>
                    </select>
                </div>
            </div>
            <div className="space-x-4 w-full flex justify-center">
                <ButtonBlue className="px-8">Guardar</ButtonBlue>
                <ButtonGray className="px-8">Cancelar</ButtonGray>
            </div>
        </div>
    );
}

export default CrearMicroAuditoria;