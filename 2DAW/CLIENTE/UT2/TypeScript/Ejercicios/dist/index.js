"use strict";
class ImplUsuario {
    constructor(nombre, edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    imprimirUsuario() {
        return ("Hola " + this.nombre + ". Tienes " + this.edad + " años.");
    }
}
function ejercicio1(usuario) {
    return usuario.imprimirUsuario();
}
let usuario1 = new ImplUsuario("Anderson", 24);
class ImplProducto {
    constructor(nombre, precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    imprimirProducto() {
        return ("<p>" + this.nombre + " - " + this.precio + "€</p>");
    }
}
let producto1 = new ImplProducto("Fanta Limon", 1.80);
let producto2 = new ImplProducto("Cerveza", 1.50);
function ejercicio2(productos) {
    let precioTotal = 0;
    let productosString = "";
    productos.forEach(producto => {
        precioTotal += producto.precio;
        productosString += producto.imprimirProducto();
    });
    document.getElementById('precio_total_ejercicio2').innerHTML = precioTotal.toLocaleString() + "€";
    document.getElementById('div-productos').innerHTML = productosString;
}
class ImplPunto {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
    calcularDistancia(punto2) {
        return Math.sqrt(Math.pow(this.x - punto2.x, 2) + Math.pow(this.y - punto2.y, 2));
    }
}
function ejercicio3() {
    let punto1 = new ImplPunto(10, 2);
    let punto2 = new ImplPunto(2, 2);
    console.log(punto1.calcularDistancia(punto2));
}
class ImplUsuarioEjer4 {
    constructor(nombre, correo, activo) {
        this.nombre = nombre;
        this.correo = correo;
        this.activo = activo;
    }
    imprimirUsuario() {
        return this.nombre;
    }
}
function ejercicio4(usuarios) {
    let devolver = [];
    for (let usuario of usuarios) {
        if (usuario.activo) {
            devolver.push(usuario);
        }
    }
    return devolver;
}
let usuario3 = new ImplUsuarioEjer4("Laura", "laurarg02@gmail.com", true);
let usuario4 = new ImplUsuarioEjer4("Manuel", "manuelmm02@gmail.com", true);
let usuario5 = new ImplUsuarioEjer4("Pepe", "pepepo03@gmail.com", false);
//console.log(ejercicio4([usuario3, usuario4, usuario5]).map(a => a.imprimirUsuario()));
function ejercicio5(a) {
    if (typeof a === "number") {
        return a * a;
    }
    else {
        return a.toUpperCase();
    }
}
//console.log(ejercicio5(2));
//console.log(ejercicio5("Hola"));
function ejercicio7(obj) {
    return obj.sort().reverse();
}
class ImplAnimal {
    constructor(nombre, tamanio, categoria) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.categoria = categoria;
    }
    imprimirAnimal() {
        return this.nombre;
    }
}
//DATOS PARA PROBAR
const animales = [
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
function botones_activos(tam, cat) {
    const tamanoActivo = document.querySelector('.btn-tamano-activo');
    if (tamanoActivo) {
        tamanoActivo.classList.remove('btn-tamano-activo');
    }
    const categoriaActivo = document.querySelector('.btn-categoria-activo');
    if (categoriaActivo) {
        categoriaActivo.classList.remove('btn-categoria-activo');
    }
    document.getElementById('btn-' + tam).classList.add('btn-tamano-activo');
    document.getElementById('btn-' + cat).classList.add('btn-categoria-activo');
}
function filtrado(tam, cat) {
    return animales.filter(animal => animal.tamanio === tam && animal.categoria === cat).map(animal => animal.imprimirAnimal()).join(', ');
}
function mostrar_animales_filtrados(tam, cat) {
    botones_activos(tam, cat);
    document.getElementById('animales').innerText = filtrado(tam, cat);
}
function filtrar_tamano(tam) {
    tamano = tam;
    mostrar_animales_filtrados(tamano, categoria);
}
function filtrar_categoria(cat) {
    categoria = cat;
    mostrar_animales_filtrados(tamano, categoria);
}
let tamano = 'pequeño';
let categoria = 'mamífero';
mostrar_animales_filtrados(tamano, categoria);
class ImplCliente {
    constructor(nombre, direccion, correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }
    toString() {
        return `Cliente ${this.nombre} (${this.correo})`;
    }
}
class ImplProducto11 {
    constructor(nombre, categoria, cantidad, precioUnitario) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioUnitario = cantidad;
    }
    toString() {
        return `${this.nombre}(${this.cantidad} x ${this.precioUnitario}€)`;
    }
}
class ImplPedido {
    constructor(cliente, productos, fecha) {
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
    }
    toString() {
        return `Pedido de ${this.cliente.toString()}. Contiene: ${this.productos.map(p => p.toString()).join(', ')}`;
    }
}
let clienteEjercicio10 = new ImplCliente("Anderson", "Plaza Espana N1", "anderolivosg@gmail.com");
let productoEjercicio101 = new ImplProducto11("Raton", "ocio", 3, 20.2);
let productoEjercicio102 = new ImplProducto11("Teclado", "ocio", 2, 60.8);
let pedido10 = new ImplPedido(clienteEjercicio10, [productoEjercicio101, productoEjercicio102], Date.now());
console.log(pedido10.toString());
class ImplPokemon {
    constructor(especie, apodo, tipo1, tipo2) {
        if (apodo == "") {
            this.apodo = especie;
        }
        else {
            this.apodo = apodo;
        }
        this.especie = especie;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }
    toString() {
        return "Pokemon " + this.especie;
    }
}
class ImplEntrenador {
    constructor(nombre, region, pokemon) {
        this.nombre = nombre;
        this.region = region;
        this.pokemon = pokemon;
    }
    toString() {
        return `Entrenador ${this.nombre} con ${this.pokemon.toString()}`;
    }
}
let pokemon1 = new ImplPokemon("Pikachu", "", "eléctrico", "normal");
let entrenador1 = new ImplEntrenador("Pepe", "Kanto", pokemon1);
