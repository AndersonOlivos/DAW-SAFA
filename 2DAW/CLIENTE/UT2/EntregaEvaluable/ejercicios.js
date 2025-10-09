/*
Alumno: Anderson Olivos Gamarra
Ciclo: 2º DAW
Curso: 2025/2026
Módulo del autor: Desarrollo web en entorno cliente
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
    a.localeCompare(b, "es", { ignorePunctuation: true })
  );
  const palabraDentro = document.getElementById("inp2Ejercicio2").value;
  let coincidencia = 0;
  palabras.forEach((palabra) => {
    if (
      palabra.localeCompare(palabraDentro, "es", { ignorePunctuation: true }) ==
      0
    ) {
      coincidencia++;
    }
  });
  if (coincidencia == 0) {
    palabras.push(palabraDentro);
    document.getElementById("aviso2").innerHTML = palabras.sort((a, b) =>
      a.localeCompare(b, "es", { ignorePunctuation: true })
    );
  } else {
    console.info("Esta palabra ya está dentro.");
  }
};

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

    while (notaNueva < 0 || notaNueva > 10 || notaNueva === undefined || notaNueva === null) {
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
      a.localeCompare(b, "es", { ignorePunctuation: true })
    )
  );
};

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

const ejercicio4 = () => {

    let multiplosDos = new Set;
    let multiplosTres = new Set;

    for(let i=0;i<=30;i++){
        if(i%2==0){multiplosDos.add(i)}
        if(i%3==0){multiplosTres.add(i)}
    }

    let union = multiplosDos.add(...multiplosTres)

    const stringUnion = [...union].join(', ');
    console.log(`%c${stringUnion}`, 'color: violet; font-weight: bold;');

    let interseccion = new Set;

    for(const valor of multiplosDos){
        if(multiplosTres.has(valor)){interseccion.add(valor)}
    }

    const stringInterseccion = [...interseccion].join(', ');
    console.log(`%c${stringInterseccion}`, 'color: purple; font-weight: bold;');
    
    let diferenciaDos = new Set(multiplosDos);

    for(const valores of interseccion){
        diferenciaDos.delete(valores)
    }

    const stringDiferenciaDos = [...diferenciaDos].join(', ');
    console.log(`%c${stringDiferenciaDos}`, 'color: blue; font-weight: bold;');

    let diferenciaTres = new Set(multiplosTres);

    for(const valores of interseccion){
        diferenciaTres.delete(valores)
    }
    
    const stringDiferenciaTres = [...diferenciaTres].join(', ');
    console.log(`%c${stringDiferenciaTres}`, 'color: pink; font-weight: bold;');

    let exclusion = diferenciaDos.add(...diferenciaTres);
    const stringExclusion = [...exclusion].join(', ');
    console.log(`%c${stringExclusion}`, 'color: green; font-weight: bold;');
}