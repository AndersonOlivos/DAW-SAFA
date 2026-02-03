import React from 'react';
import {useState, useId} from "react";

const PlayerForm = ({modoEdicion,cancelarModoEdicion, datosJugador, editarJugadorSeleccionado, anadirJugador}) => {

    const [form, setForm] = useState(
        datosJugador != null ?
        {nombre: datosJugador[0].nombre, dorsal: datosJugador[0].dorsal, posicion: datosJugador[0].posicion, altura: datosJugador[0].altura }
        :
        {nombre: '', dorsal: '', posicion: '', altura: ''});


    const handleChange = (e) => {
        const { name, value } = e.target;
        setForm({ ...form, [name]: value });
    };

    const validarAnadirJugador = () => {
        if(validadorFormulario()){
            let jugador = {
                id: crypto.randomUUID(),
                nombre: form.nombre,
                dorsal: form.dorsal,
                posicion: form.posicion,
                altura: form.altura,
            }
            anadirJugador(jugador);
        }
    }

    const validadorFormulario = () => {
        return true;
    }


    return (
        <form>
            <label>Nombre</label>
            <input name="nombre" value={form['nombre']} onChange={handleChange}></input>
            <label>Dorsal</label>
            <input name="dorsal" value={form['dorsal']} onChange={handleChange}></input>
            <label>Posición</label>
            <input name="posicion" value={form['posicion']} onChange={handleChange}></input>
            <label>Altura</label>
            <input name="altura" value={form['altura']} onChange={handleChange}></input>
            {modoEdicion ?
                <div>
                    <button type={"button"} onClick={cancelarModoEdicion}>Cancelar</button>
                    <button type={"button"} onClick={() => editarJugadorSeleccionado(datosJugador[0].id)}>Editar</button>
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