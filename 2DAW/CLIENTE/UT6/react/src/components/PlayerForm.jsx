import React from 'react';
import {useState} from "react";
import "../styles/form.css";

const PlayerForm = ({modoEdicion,cancelarModoEdicion, datosJugadorEditar, editarJugadorSeleccionado, anadirJugador, jugadores}) => {

    const [form, setForm] = useState(
        datosJugadorEditar != null ?
        {
            nombre: datosJugadorEditar[0].nombre,
            dorsal: datosJugadorEditar[0].dorsal,
            posicion: datosJugadorEditar[0].posicion,
            altura: datosJugadorEditar[0].altura }
        :
        {nombre: '', dorsal: '', posicion: '', altura: ''});

    const [errorForm, setErrorForm] = useState({nombre: false, dorsal: false, posicion: false, altura: false});


    const handleChange = (e) => {
        const { name, value } = e.target;
        setForm({ ...form, [name]: value });
    };

    const validarAnadirJugador = () => {
        if(validadorFormulario("anadir")){
            let jugador = {
                id: crypto.randomUUID(),
                nombre: form.nombre,
                dorsal: Number(form.dorsal),
                posicion: form.posicion,
                altura: Number(form.altura),
            }
            anadirJugador(jugador);
            setForm({nombre: '', dorsal: '', posicion: '', altura: ''});
        }
    }

    const validarEditarJugador = () => {
        if(validadorFormulario("editar")){
            let jugador = {
                id: datosJugadorEditar[0].id,
                nombre: form.nombre,
                dorsal: Number(form.dorsal),
                posicion: form.posicion,
                altura: Number(form.altura),
            }
            editarJugadorSeleccionado(jugador);
        }
    }

    const validadorFormulario = (tipo) => {

        const nuevosErrores = {
            nombre: false,
            dorsal: false,
            posicion: false,
            altura: false
        };

        let esValido = true;

        if(form.nombre === "" || form.nombre.length < 3){
            nuevosErrores.nombre = true;
            esValido = false;
        }

        if(tipo === 'editar'){
            if(form.dorsal === ""
                || isNaN(Number(form.dorsal))
                || Number(form.dorsal) < 1
                || Number(form.dorsal) > 99
                || jugadores.filter(jugador => jugador.dorsal === Number(form.dorsal) && jugador.id !== datosJugadorEditar[0].id).length > 0) {
                nuevosErrores.dorsal = true;
                esValido = false;
            }
        }

        if(tipo === 'anadir'){
            if(form.dorsal === ""
                || isNaN(Number(form.dorsal))
                || Number(form.dorsal) < 1
                || Number(form.dorsal) > 99
                || jugadores.filter(jugador => jugador.dorsal === Number(form.dorsal)).length > 0) {
                nuevosErrores.dorsal = true;
                esValido = false;
            }
        }


        if(form.posicion === ""){
            nuevosErrores.posicion = true;
            esValido = false;
        }

        if(form.altura === "" || isNaN(Number(form.altura)) || Number(form.altura) < 140 || Number(form.altura) > 230){
            nuevosErrores.altura = true;
            esValido = false;
        }

        setErrorForm(nuevosErrores);
        return esValido;
    }

    return (
        <form>
            <label>Nombre</label>
            <input name="nombre" value={form['nombre']} onChange={handleChange}></input>
            {errorForm.nombre &&
            <p className="error">Obligatorio. Mínimo de 3 caracteres</p>
            }
            <label>Dorsal (1-99)</label>
            <input name="dorsal" value={form['dorsal']} onChange={handleChange}></input>
            {errorForm.dorsal &&
                <p className="error">Obligatorio. Rango 1-99. No puede repetirse</p>
            }
            <label>Posición</label>
            <select name="posicion" value={form['posicion']} onChange={handleChange}>
                <option value="" disabled>Selecciona una posicion</option>
                <option value="Colocador">Colocador</option>
                <option value="Opuesto">Opuesto</option>
                <option value="Receptor">Receptor</option>
                <option value="Central">Central</option>
                <option value="Líbero">Líbero</option>
            </select>
            {errorForm.posicion &&
                <p className="error">Obligatorio</p>
            }
            <label>Altura (140-230 cm)</label>
            <input name="altura" value={form['altura']} onChange={handleChange}></input>
            {errorForm.altura &&
                <p className="error">Obligatorio. Rango 140-230 cm</p>
            }
            {modoEdicion ?
                <div>
                    <button type={"button"} onClick={cancelarModoEdicion}>Cancelar</button>
                    <button type={"button"} onClick={() => validarEditarJugador()}>Guardar</button>
                </div>
                :
                <div>
                    <button type={"button"} onClick={() => validarAnadirJugador()}>Añadir</button>
                </div>
            }

        </form>
    );
};

export default PlayerForm;