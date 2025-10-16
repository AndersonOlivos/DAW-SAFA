interface Usuario {
    nombre: string;
    edad: number;
    imprimirUsuario():string;
}

class ImplUsuario implements Usuario{
    nombre: string;
    edad: number;

    constructor(nombre:string, edad:number) {
        this.nombre = nombre;
        this.edad = edad;
    }

    imprimirUsuario():string {
        return("Hola " + this.nombre + ". Tienes " + this.edad + " años.");
    }
}

function ejercicio1(usuario:Usuario):string {
    return usuario.imprimirUsuario();
}

let usuario1 = new ImplUsuario("Anderson", 24);

//console.log(ejercicio1(usuario1));


interface Producto{
    nombre: string;
    precio: number;
    imprimirProducto:() => String;
}

class ImplProducto{
    nombre: string;
    precio: number;

    constructor(nombre:string, precio:number){
        this.nombre = nombre;
        this.precio = precio;
    }

    imprimirProducto():String {
        return("<p>" + this.nombre + " - " + this.precio + "€</p>");
    }
}

let producto1 = new ImplProducto("Fanta Limon", 1.80);
let producto2 = new ImplProducto("Cerveza", 1.50);

function ejercicio2(productos:Producto[]):void {

    let precioTotal:number = 0;
    let productosString:string = "";

    productos.forEach(producto => {
        precioTotal += producto.precio;
        productosString += producto.imprimirProducto();
    })

    document.getElementById('precio_total_ejercicio2')!.innerHTML = precioTotal.toLocaleString() + "€";
    document.getElementById('div-productos')!.innerHTML = productosString;
}

//ejercicio2([producto1, producto2]);

interface Punto{
    x: number;
    y: number;
    calcularDistancia(punto: Punto):number;
}

class ImplPunto implements Punto{
    x: number;
    y: number;

    constructor(x:number, y:number) {
        this.x = x;
        this.y = y;
    }

    calcularDistancia(punto2: Punto):number{
        return Math.sqrt(Math.pow(this.x-punto2.x,2) + Math.pow(this.y-punto2.y,2));
    }
}

function ejercicio3():void{
    let punto1:Punto = new ImplPunto(10,2);
    let punto2:Punto = new ImplPunto(2,2);

    console.log(punto1.calcularDistancia(punto2));
}

//ejercicio3();

interface UsuarioEjer4 {
    nombre: string;
    correo: string;
    activo: boolean;
    imprimirUsuario():string;
}

class ImplUsuarioEjer4 implements UsuarioEjer4 {
    nombre: string;
    correo: string;
    activo: boolean;

    constructor(nombre:string, correo:string, activo:boolean) {
        this.nombre = nombre;
        this.correo = correo;
        this.activo = activo;
    }

    imprimirUsuario():string {
        return this.nombre;
    }
}

function ejercicio4(usuarios: UsuarioEjer4[]):UsuarioEjer4[]{
    let devolver:UsuarioEjer4[] = [];
    for (let usuario of usuarios) {
        if (usuario.activo) {
            devolver.push(usuario);
        }
    }
    return devolver;
}

let usuario3: UsuarioEjer4 = new ImplUsuarioEjer4("Laura", "laurarg02@gmail.com", true);
let usuario4: UsuarioEjer4 = new ImplUsuarioEjer4("Manuel", "manuelmm02@gmail.com", true);
let usuario5: UsuarioEjer4 = new ImplUsuarioEjer4("Pepe", "pepepo03@gmail.com", false);

//console.log(ejercicio4([usuario3, usuario4, usuario5]).map(a => a.imprimirUsuario()));

function ejercicio5(a: number | string):number|string {
    if (typeof a === "number") {
        return a*a;
    } else {
        return a.toUpperCase();
    }
}

//console.log(ejercicio5(2));
//console.log(ejercicio5("Hola"));

function ejercicio7(obj: any[]):any[]{
    return obj.sort().reverse();
}

//console.log(ejercicio7([1,2,3,4]));
//console.log(ejercicio7(["a","b","c"]));

type Tamanio = "pequeño" | "mediano" | "grande";
type Categoria = "mamífero" | "ave" | "reptil" | "pez" | "anfibio";

interface Animal {
    nombre: string;
    tamanio: Tamanio;
    categoria: Categoria;
    imprimirAnimal():string;
}

class ImplAnimal implements Animal {

    nombre: string;
    tamanio: Tamanio;
    categoria: Categoria;

    constructor(nombre: string, tamanio: Tamanio, categoria: Categoria) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.categoria = categoria;
    }

    imprimirAnimal():string{
        return this.nombre;
    }
}

//DATOS PARA PROBAR
const animales: ImplAnimal[] = [
    // Pequeño
    new ImplAnimal("Ratón", "pequeño", "mamífero"),
    new ImplAnimal("Hámster", "pequeño", "mamífero"),

    new ImplAnimal("Canario", "pequeño", "ave"),
    new ImplAnimal("Colibrí", "pequeño", "ave"),

    new ImplAnimal("Lagartija", "pequeño", "reptil"),
    new ImplAnimal("Camaleón", "pequeño", "reptil"),

    new ImplAnimal("Guppy", "pequeño", "pez"),
    new ImplAnimal("Neón", "pequeño", "pez"),

    new ImplAnimal("Rana Arborícola", "pequeño", "anfibio"),
    new ImplAnimal("Salamandra", "pequeño", "anfibio"),

    // Mediano
    new ImplAnimal("Gato", "mediano", "mamífero"),
    new ImplAnimal("Perro", "mediano", "mamífero"),

    new ImplAnimal("Loro", "mediano", "ave"),
    new ImplAnimal("Pato", "mediano", "ave"),

    new ImplAnimal("Iguana", "mediano", "reptil"),
    new ImplAnimal("Serpiente", "mediano", "reptil"),

    new ImplAnimal("Pez Payaso", "mediano", "pez"),
    new ImplAnimal("Pez Betta", "mediano", "pez"),

    new ImplAnimal("Sapo", "mediano", "anfibio"),
    new ImplAnimal("Tritón", "mediano", "anfibio"),

    // Grande
    new ImplAnimal("Elefante", "grande", "mamífero"),
    new ImplAnimal("Jirafa", "grande", "mamífero"),

    new ImplAnimal("Águila", "grande", "ave"),
    new ImplAnimal("Flamenco", "grande", "ave"),

    new ImplAnimal("Cocodrilo", "grande", "reptil"),
    new ImplAnimal("Tortuga Gigante", "grande", "reptil"),

    new ImplAnimal("Tiburón", "grande", "pez"),
    new ImplAnimal("Pez Globo", "grande", "pez"),

    new ImplAnimal("Caimán", "grande", "anfibio"),
    new ImplAnimal("Salamandra Gigante", "grande", "anfibio"),
];

function botones_activos(tam:string, cat:string):void{

    const tamanoActivo = document.querySelector('.btn-tamano-activo');
    if (tamanoActivo) {
        tamanoActivo.classList.remove('btn-tamano-activo');
    }
    const categoriaActivo = document.querySelector('.btn-categoria-activo');
    if (categoriaActivo) {
        categoriaActivo.classList.remove('btn-categoria-activo');
    }

    document.getElementById('btn-' + tam)!.classList.add('btn-tamano-activo');
    document.getElementById('btn-' + cat)!.classList.add('btn-categoria-activo');
}

function filtrado(tam:string, cat:string):string{
    return animales.filter(animal => animal.tamanio === tam && animal.categoria === cat).map(animal => animal.imprimirAnimal()).join(', ');
}

function mostrar_animales_filtrados(tam:string, cat:string):void{
    botones_activos(tam, cat);
    document.getElementById('animales')!.innerText = filtrado(tam, cat);
}

function filtrar_tamano(tam:string):void{
    tamano = tam;
    mostrar_animales_filtrados(tamano, categoria);
}

function filtrar_categoria(cat:string):void{
    categoria = cat;
    mostrar_animales_filtrados(tamano, categoria);
}

let tamano:string = 'pequeño';
let categoria:string = 'mamífero';
mostrar_animales_filtrados(tamano, categoria);