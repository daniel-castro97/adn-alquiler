import { Cliente } from './cliente';
import { Moto } from './moto';

export class Reserva{
    fechaSolicitud: Date;
    fechaInicio: Date;
    fechaFin: Date;
    valorTotal: number;
    moto: Moto;
    cliente: Cliente;
}