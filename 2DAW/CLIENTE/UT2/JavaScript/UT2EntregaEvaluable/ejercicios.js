/*
Alumno: Anderson Olivos Gamarra
Ciclo: 2º DAW
Curso: 2025/2026
Módulo del autor: Desarrollo web en entorno cliente
*/

//EJERCICIO 1
/* 
Se requiere que el usuario introduzca una frase de, al menos, cinco palabras mediante un
prompt. De no ser así, mostrará un mensaje y volverá a pedir de nuevo la frase.
La siguiente información se mostrará por log de consola, modificando el estilo predefinido
del mismo:
1) La aplicación Javascript ha de contar el número de caracteres de la frase que no
sean espacios.
2) De igual modo, por un lado debe sustituir en la frase original todas las vocales por
asteriscos.
3) Se sustituirá cada elemento par (ignorando los espacios para el conteo) de la frase
por un guion bajo (“_”).
*/

const ejercicio1 = () => {
  const input = document.getElementById("inpEjercicio1");
  const aviso = document.getElementById("aviso1");
  let fraseSinEspacios = input.value.split(" ");
  if (fraseSinEspacios.length >= 5) {
    aviso.innerHTML = "";

    console.log(fraseSinEspacios.join("").length);

    const vocales = [
      "a",
      "e",
      "i",
      "o",
      "u",
      "A",
      "E",
      "I",
      "O",
      "U",
      "á",
      "é",
      "í",
      "ó",
      "ú",
      "Á",
      "É",
      "Í",
      "Ó",
      "Ú",
    ];

    let vocalesAstericos = input.value;

    vocales.forEach((vocal) => {
      vocalesAstericos = vocalesAstericos.replaceAll(vocal, "*");
    });

    console.log(vocalesAstericos);

    let fraseGuion = "";
    let pares = 1;
    for (let i = 0; i < input.value.length; i++) {
      if (input.value[i] != " ") {
        if (pares % 2 == 0) {
          fraseGuion += "_";
        } else {
          fraseGuion += input.value[i];
        }
        pares++;
      } else {
        fraseGuion += input.value[i];
      }
    }
    console.log(fraseGuion);
  } else {
    aviso.innerText = "Introduzca una frase de mínimo 5 palabras";
  }
};

//EJERCICIO 2
/* 
Se requiere al usuario que inserte 7 palabras variadas, comenzando algunas por
mayúsculas y otras no (y algunas de ellas de 4 letras o menos).
Se mostrarán por pantalla los nombres ordenados alfabéticamente (sin distinción entre
mayúsculas y minúsculas, sin considerar aquellos de 4 o menos caracteres.
A continuación, se le pedirá al usuario que introduzca una palabra para ver si está en dicho
listado.
Si la palabra está (ignorando mayúsculas y minúsculas), se mostrará un mensaje de tipo
info por la consola indicando esto.
Si la palabra no está, se añadirá al listado previo y este volverá a mostrarse por pantalla, de
nuevo ordenado.
*/

const ejercicio2 = () => {
  const palabrasArray = document
    .getElementById("inp1Ejercicio2")
    .value.split(",");
  const palabras = new Array();
  palabrasArray.forEach((palabra) => {
    if (!palabras.includes(palabra) && palabra.length > 4) {
      palabras.push(palabra);
    }
  });
  document.getElementById("aviso2").innerHTML = palabras.sort((a, b) =>
    a.localeCompare(b, "es", { sensitivity: "base" })
  );
  const palabraDentro = document.getElementById("inp2Ejercicio2").value;
  let coincidencia = 0;
  palabras.forEach((palabra) => {
    if (
      palabra.localeCompare(palabraDentro, "es", { sensitivity: "base" }) ==
      0
    ) {
      coincidencia++;
    }
  });
  if (coincidencia == 0) {
    palabras.push(palabraDentro);
    document.getElementById("aviso2").innerHTML = palabras.sort((a, b) =>
      a.localeCompare(b, "es", { sensitivity: "base" })
    );
  } else {
    console.info("Esta palabra ya está dentro.");
  }
};

//LISTA DE OBJETOS PARA EJERCICIO 3

let alumnos = [
  {
    nombre: "Anderson",
    nota: 10.0,
  },
  {
    nombre: "Iván",
    nota: 8.88,
  },
  {
    nombre: "Aarón",
    nota: 9.0,
  },
  {
    nombre: "Joselu",
    nota: 5.5,
  },
];

//EJERCICIO 3
/**
 * Vamos a guardar información, de partida, de 4 alumnos y las notas que tienen estos (entre 0
y 10, permitiendo hasta 2 decimales).
Esta información se mostrará en pantalla.
Pide al usuario que introduzca el nombre de un estudiante.
Si el estudiante está entre los registrados, recuperará la nota del mismo y la mostrará por
pantalla.
Si el estudiante no está registrado: se mostrará un mensaje indicando que no estaba
registrado, pero que se dará de alta con la nota que se indique (se le pedirá a continuación).
Esta nota deberá ser un número entre 0 y 10 igualmente (si no, deberá volver a pedirse).
Una vez hecho esto, estuviese el alumno ya o no, se mostrará la nota media de la clase por
consola en un mensaje de tipo INFO. También se mostrará el nombre de todos los alumnos
de la clase, ordenados alfabéticamente.
 */

const ejercicio3 = () => {
  const inpNombre = document.getElementById("inp1Ejercicio3").value;
  const aviso = document.getElementById("aviso3");
  aviso.innerHTML = "";

  let existe = undefined;

  for (clave in alumnos) {
    if (alumnos[clave].nombre.toLowerCase() == inpNombre.toLowerCase()) {
      existe = clave;
      break;
    }
  }

  if (existe != undefined) {
    aviso.innerHTML = `<b>Nota de ${alumnos[existe].nombre}:</b> ${alumnos[existe].nota}`;
  } else {
    let notaNueva = undefined;

    while (
      notaNueva < 0 ||
      notaNueva > 10 ||
      notaNueva === undefined ||
      notaNueva === null
    ) {
      let input = prompt(
        "Este usuario no existe. Indica una nota (0-10) para añadirlo."
      );

      if (input === null) {
        break;
      }

      notaNueva = parseFloat(input);
      if (isNaN(notaNueva) || notaNueva < 0 || notaNueva > 10) {
        alert("Por favor, introduce un número válido entre 0 y 10.");
        notaNueva = null;
      }
    }

    if (notaNueva !== null) {
      let nuevoAlumno = {
        nombre: inpNombre,
        nota: notaNueva,
      };
      alumnos.push(nuevoAlumno);
      mostrar_alumnos();
    }
  }

  let notaMedia = 0;
  let alumnosNombreOrdenado = new Array();
  alumnos.forEach((alumno) => {
    notaMedia += alumno.nota;
    alumnosNombreOrdenado.push(alumno.nombre);
  });
  notaMedia = notaMedia / alumnos.length;
  console.info("NOTA MEDIA: " + notaMedia.toFixed(2));
  console.info(
    alumnosNombreOrdenado.sort((a, b) =>
      a.localeCompare(b, "es", { sensitivity: "base" })
    )
  );
};

//FUNCION PARA MOSTRAR/ACTUALIZAR LA LISTA DE ALUMNOS

const mostrar_alumnos = () => {
  const tabla = document.getElementById("body-alumnos");
  tabla.innerHTML = "";
  for (let clave in alumnos) {
    let linea = document.createElement("tr");
    let tdNombre = document.createElement("td");
    tdNombre.textContent = alumnos[clave].nombre;
    let tdNota = document.createElement("td");
    tdNota.textContent = parseFloat(alumnos[clave].nota).toFixed(2);
    linea.appendChild(tdNombre);
    linea.appendChild(tdNota);
    tabla.appendChild(linea);
  }
};

mostrar_alumnos();

//EJERCICIO 4
/**
 * Se dispone de 2 conjuntos numéricos: el de los múltiplos de 2 y el de los múltiplos de 3,
ambos conteniendo los respectivos valores desde 0 hasta 30.
Se pide que se muestre por pantalla un mensaje “Mira el log para ver el resultado” y que, se
muestre cada uno de los siguientes resultados en una líneas de log diferente (cambiando el
estilo para cada una de ellas):
1) Resultado de la unión de ambos conjuntos
2) Resultado de la intersección de ambos conjuntos
3) Resultado de la diferencia del primero menos el segundo
4) Resultado de la diferencia del segundo menos el primero
5) Resultado de la exclusión de los elementos que pertenecen a ambos conjuntos
 */

const ejercicio4 = () => {
  let multiplosDos = new Set();
  let multiplosTres = new Set();

  for (let i = 0; i <= 30; i++) {
    if (i % 2 == 0) {
      multiplosDos.add(i);
    }
    if (i % 3 == 0) {
      multiplosTres.add(i);
    }
  }

  let union = multiplosDos.add(...multiplosTres);

  const stringUnion = [...union].join(", ");
  console.log(`%c${stringUnion}`, "color: violet; font-weight: bold;");

  let interseccion = new Set();

  for (const valor of multiplosDos) {
    if (multiplosTres.has(valor)) {
      interseccion.add(valor);
    }
  }

  const stringInterseccion = [...interseccion].join(", ");
  console.log(`%c${stringInterseccion}`, "color: purple; font-weight: bold;");

  let diferenciaDos = new Set(multiplosDos);

  for (const valores of interseccion) {
    diferenciaDos.delete(valores);
  }

  const stringDiferenciaDos = [...diferenciaDos].join(", ");
  console.log(`%c${stringDiferenciaDos}`, "color: blue; font-weight: bold;");

  let diferenciaTres = new Set(multiplosTres);

  for (const valores of interseccion) {
    diferenciaTres.delete(valores);
  }

  const stringDiferenciaTres = [...diferenciaTres].join(", ");
  console.log(`%c${stringDiferenciaTres}`, "color: pink; font-weight: bold;");

  let exclusion = diferenciaDos.add(...diferenciaTres);
  const stringExclusion = [...exclusion].join(", ");
  console.log(`%c${stringExclusion}`, "color: green; font-weight: bold;");
};

//EJERCICIO 5
/**
 * Pide al usuario que dé una serie de números separados por comas. Si algún valor no es
numérico se volverá a pedir que introduzca valores.
Una vez introducidos correctamente, se mostrarán por pantalla aquellos valores que solo
aparecen una vez y la media de dichos valores
 */

const ejercicio5 = () => {
  const numeros = document.getElementById("inp1Ejercicio5").value;
  const aviso = document.getElementById("aviso5");

  const numerosArray = numeros.split(",");
  let todosNumeros = true;
  const correctosSet = new Set();

  for (const numero of numerosArray) {
    let transformado = parseInt(numero);

    if (isNaN(transformado)) {
      todosNumeros = false;
      break;
    } else {
      correctosSet.add(transformado);
    }
  }

  if (todosNumeros) {
    aviso.innerHTML =
      "<p><b>Numeros:</b> " + [...correctosSet].join(", ") + "</p>";

    let media = 0;
    for (const numeros of correctosSet) {
      media += numeros;
    }
    media = media / correctosSet.size;

    aviso.innerHTML += "<p><b>Media:</b> " + media + "</p>";
  } else {
    aviso.innerHTML =
      "<p style='color: red'><b>Error:</b> introduce solo valores numéricos.</p>";
  }
};

//EJERCICIO 6
/**
 * Crea una función que verifique si una frase o palabra que se introduzca por parte del
usuario es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda).
Para esta comparación solo se tendrán en cuenta los caracteres alfabéticos, teniendo en
cuenta que las mayúsculas y las minúsculas se consideran la misma letra, así como
caracteres acentuados (“a” es lo mismo que “Á” para el palíndromo), pero “n” y “Ñ” son
diferentes.
 */

const ejercicio6 = () => {
  const texto = document.getElementById("inp1Ejercicio6").value;
  const aviso = document.getElementById("aviso6");

  const textoSinEspacios = texto.replaceAll(" ", "");
  const textoArray = textoSinEspacios.split("");
  const textoInvArray = new Array();

  for (let i = textoArray.length - 1; i >= 0; i--) {
    textoInvArray.push(textoArray[i]);
  }

  const textoInv = [...textoInvArray].join("");

  if (
    textoSinEspacios.localeCompare(textoInv, "es", { sensitivity: "base" }) ===
    0
  ) {
    aviso.innerText = "Es palíndromo";
  } else {
    aviso.innerText = "No es palíndromo";
  }
};

//LISTA DE OBJETOS DE TAREA PARA EJERCICIO 7

let tareas = [
  {
    nombre: "Comprar galletas",
    estado: "pendiente",
  },
];

//VARIABLE PARA SABER EN QUÉ VENTANA SE ENCUENTRA EL USUARIO

let estadoVentana = "Todas";

//EJERCICIO 7
/**
 * Se requiere de un programa que gestione una lista de tareas.
El programa debe permitir agregar tarea, completar tarea (marcar estado como
completada), eliminar tarea, mostrar lista (mostrar todas las tareas con su estado) y mostrar
pendientes (mostrar solo aquellas no completadas).
Se recomienda, en este caso, un botón para cada funcionalidad (al contrario que en el resto
de ejercicios), aunque también puede hacerse indicando al usuario que indique la acción a
realizar(1, 2, 3…).
NOTA: No puede haber dos tareas iguales.
 */

const ejercicio7 = () => {
  const tareaNombre = document.getElementById("inp1Ejercicio7").value;
  const aviso = document.getElementById("aviso7");
  let existe = false;
  
  for(const tarea of tareas){
    if(tarea.nombre.localeCompare(tareaNombre, "es", {sensitivity: "base"})===0){
      existe=true;
      break;
    }
  }

  if(existe==false){
    aviso.innerText="";
    const tarea = {
    nombre: tareaNombre,
    estado: "pendiente",
  };

  tareas.push(tarea);
  actualizar_ventana(estadoVentana);
  } else {
    aviso.innerText="Esta tarea ya existe. ¡Prueba con otra!"
  }

};

//FUNCION PARA MOSTRAR/ACTUALIZAR LA VENTANA

const actualizar_ventana = (estado) => {
  const botonTodas = document.getElementById("boton-todas");
  const botonCompletadas = document.getElementById("boton-completadas");
  const botonPendientes = document.getElementById("boton-pendientes");

  botonTodas.classList.remove("boton-activo");
  botonCompletadas.classList.remove("boton-activo");
  botonPendientes.classList.remove("boton-activo");

  if (estado == "Todas") {
    botonTodas.classList.add("boton-activo");
    estadoVentana = estado;
    mostrar_todas_tareas();
  } else {
    if (estado == "Completadas") {
      botonCompletadas.classList.add("boton-activo");
      estadoVentana = estado;
      mostrar_completadas_tareas();
    } else {
      botonPendientes.classList.add("boton-activo");
      mostrar_pendientes_tareas();
      estadoVentana = estado;
    }
  }
};

//FUNCION QUE MUESTRA TODAS LAS TAREAS

const mostrar_todas_tareas = () => {
  const divTareas = document.getElementById("tareas");
  divTareas.innerHTML = "";
  let contenido = "";
  for (const i in tareas) {
    if (tareas[i].estado == "pendiente") {
      contenido +=
        "<div class='card-tarea pendiente'>" +
        "<p class='nombre-tarea'>" +
        tareas[i].nombre +
        "</p>" +
        "<div class='acciones'>" +
        "<p class='estado-tarea pendiente'>" +
        tareas[i].estado.toUpperCase() +
        "</p>" +
        "<div>" +
        "<button class='boton-completado' onclick='completado(" +
        i +
        ")'><img class='img-acciones' src='./img/done.png' alt=''></button>" +
        "<button class='boton-eliminar' onclick='eliminar(" +
        i +
        ")'><img class='img-acciones' src='./img/basura.png' alt=''></button>" +
        "</div>" +
        "</div>" +
        "</div>";
    } else {
      contenido +=
        "<div class='card-tarea completado'>" +
        "<p class='nombre-tarea'>" +
        tareas[i].nombre +
        "</p>" +
        "<div class='acciones'>" +
        "<p class='estado-tarea completado'>" +
        tareas[i].estado.toUpperCase() +
        "</p>" +
        "<div>" +
        "<button class='boton-eliminar' onclick='eliminar(" +
        i +
        ")'><img class='img-acciones' src='./img/basura.png' alt=''></button>" +
        "</div>" +
        "</div>" +
        "</div>";
    }
  }
  divTareas.innerHTML = contenido;
};

//FUNCION QUE MUESTRA LAS TAREAS COMPLETADAS FILTRADAS

const mostrar_completadas_tareas = () => {
  const divTareas = document.getElementById("tareas");
  divTareas.innerHTML = "";
  let contenido = "";
  for (const i in tareas) {
    if (tareas[i].estado == "completado") {
      {
        contenido +=
          "<div class='card-tarea completado'>" +
          "<p class='nombre-tarea'>" +
          tareas[i].nombre +
          "</p>" +
          "<div class='acciones'>" +
          "<p class='estado-tarea completado'>" +
          tareas[i].estado.toUpperCase() +
          "</p>" +
          "<div>" +
          "<button class='boton-eliminar' onclick='eliminar(" +
          i +
          ")'><img class='img-acciones' src='./img/basura.png' alt=''></button>" +
          "</div>" +
          "</div>" +
          "</div>";
      }
      divTareas.innerHTML = contenido;
    }
  }
};

//FUNCION QUE MUESTRA LAS TAREAS PENDIENTES FILTRADAS

const mostrar_pendientes_tareas = () => {
  const divTareas = document.getElementById("tareas");
  divTareas.innerHTML = "";
  let contenido = "";
  for (const i in tareas) {
    if (tareas[i].estado == "pendiente") {
      {
        contenido +=
          "<div class='card-tarea pendiente'>" +
          "<p class='nombre-tarea'>" +
          tareas[i].nombre +
          "</p>" +
          "<div class='acciones'>" +
          "<p class='estado-tarea pendiente'>" +
          tareas[i].estado.toUpperCase() +
          "</p>" +
          "<div>" +
          "<button class='boton-completado' onclick='completado(" +
          i +
          ")'><img class='img-acciones' src='./img/done.png' alt=''></button>" +
          "<button class='boton-eliminar' onclick='eliminar(" +
          i +
          ")'><img class='img-acciones' src='./img/basura.png' alt=''></button>" +
          "</div>" +
          "</div>" +
          "</div>";
      }
      divTareas.innerHTML = contenido;
    }
  }
};

//FUNCION PARA ELIMINAR UNA TAREA

const eliminar = (id) => {
  tareas.pop(id);
  actualizar_ventana(estadoVentana);
};

//FUNCION PARA CAMBIAR EL ESTADO DE UNA TAREA A COMPLETADA

const completado = (id) => {
  tareas[id].estado = "completado";
  console.log(tareas[id].estado);
  actualizar_ventana(estadoVentana);
};

actualizar_ventana("Todas");
