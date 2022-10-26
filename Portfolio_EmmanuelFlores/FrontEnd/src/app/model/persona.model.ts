export class persona {
    id?: number;
    nombre: string;
    apellido: string;
    descripcionPers: string;
    img: string;

    constructor(nombre: string,apellido: string, descripcionPers: string, img: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcionPers = descripcionPers;
        this.img = img;
    }
}