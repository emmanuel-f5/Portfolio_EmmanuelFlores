export class Proyectos {
    id?: number;
    nombreProy: string;
    descripcionProy: string;

    constructor(nombreProy: string, descripcionProy: string) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
    }
}
