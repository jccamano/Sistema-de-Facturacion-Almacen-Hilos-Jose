import { Factura } from "./factura";

export class Cliente {
    id: number;
    nombre: string;
    apellido: string;
    celular: string;
    direccion: string;
    correo: string;
    fechaCreacion: string;
    facturas: Factura[] = [];

}
