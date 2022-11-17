import { LineaFactura } from "./linea-factura";

export class Factura {
    id: number;
    descripcion: string;
    observacion: string;
    fechaFacturacion: string;
    lineafactura: LineaFactura [] = [];
}
