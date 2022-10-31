export class persona {
    id?: number;
    nombre: string;
    apellido: string;
    titulo: string;
    descripcionPers: string;
    img: string;

    constructor(nombre: string, apellido: string, titulo: string, descripcionPers: string, img: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcionPers = descripcionPers;
        this.img = img;
    }
}