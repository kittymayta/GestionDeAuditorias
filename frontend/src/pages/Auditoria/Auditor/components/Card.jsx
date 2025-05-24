
import * as React from "react";
import { Card, CardHeader, CardTitle, CardDescription, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";


const CardMicro = React.forwardRef(({ Numero, Proceso, SubItem, Fecha, ...props }, ref) => {
  return (
    <Button
      className="h-auto w-full p-1 bg-blue-50 hover:bg-blue-200 my-1"
      ref={ref}
      {...props}
    >
      <Card className="my-2 w-full h-auto shadow-none bg-transparent border-0">
        <CardHeader className="flex items-start justify-start p-2">
            <CardTitle>Micro Auditoria {Numero}</CardTitle>
            <CardDescription>{Proceso}</CardDescription>
        </CardHeader>
        <CardContent>
                <p>SubItem: {SubItem}</p>
                <p>Fecha: {Fecha}</p>
        </CardContent>
      </Card>
    </Button>
  );
});
CardMicro.displayName = "CardMicro";
export default CardMicro;