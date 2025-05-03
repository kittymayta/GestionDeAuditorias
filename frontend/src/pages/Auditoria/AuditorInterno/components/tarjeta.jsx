import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
  } from "@/components/ui/card"
  

const Tarjeta =({numero})=>{
    return (
        <div className="h-ful w-full m-0">
            <Card className="my-2 w-full h-full border-none shadow-none bg-transparent">
                <CardHeader>
                    <CardTitle>Auditoría Proceso {numero}</CardTitle>
                    <CardDescription>Card Description</CardDescription>
                </CardHeader>
                <CardContent>
                    <p>Card Content</p>
                </CardContent>
                <CardFooter>
                    <p>Card Footer</p>
                    <p>           </p>
                </CardFooter>
            </Card>
        </div>
      
    );
}
export default Tarjeta;
