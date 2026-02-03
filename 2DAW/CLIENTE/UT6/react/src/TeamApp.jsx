import React from 'react';
import {useState} from "react";
import PlayerTable from "./components/PlayerTable.jsx";
import PlayerForm from "./components/PlayerForm.jsx";


const TeamApp = () => {


    const [jugadores, setJugadores] = useState([
        {id: crypto.randomUUID(), nombre: 'Antonio', dorsal: 10, posicion: 'Colocador', altura: 190},
        {id: crypto.randomUUID(), nombre: 'Fernanda', dorsal: 1, posicion: 'Receptor', altura: 199}
    ]);

    const [formModoEdicion, setFormModoEdicion] = useState(false)

    const [jugadorSeleccionadoEditar, setJugadorSeleccionadoEditar] = useState(null)

    const anadirJugador = (jugador) => {
        setJugadores([...jugadores, jugador]);
        setFormModoEdicion(false);
        setJugadorSeleccionadoEditar(null);
    }

    const eliminarJugador = (idJugadorEliminar) => {
        setJugadores(jugadores.filter((jugador) => jugador.id !== idJugadorEliminar));
    }

    const editarJugador = (idJugador) => {
        mostrarDatosJugador(idJugador);
    }

    const confirmarEditarJugador = (idJugador) => {
        alert("JUGADOR" + idJugador + "EDITADO");
        setFormModoEdicion(false);
        setJugadorSeleccionadoEditar(null);
    }

    const mostrarDatosJugador = (idJugador) => {
        setFormModoEdicion(true);
        setJugadorSeleccionadoEditar(jugadores.filter((jugador) => jugador.id === idJugador));
    }

    const cancelarModoEdicion = () => {
        setFormModoEdicion(false);
        setJugadorSeleccionadoEditar(null);
    }


    return (
        <>
            <PlayerForm key={jugadorSeleccionadoEditar?.[0]?.id}
                        modoEdicion = {formModoEdicion}
                        cancelarModoEdicion = {cancelarModoEdicion}
                        datosJugador = {jugadorSeleccionadoEditar}
                        editarJugadorSeleccionado={confirmarEditarJugador}
                        anadirJugador = {anadirJugador}
            ></PlayerForm>
            <PlayerTable jugadores={jugadores} handleEditarJugador={editarJugador} handleEliminarJugador={eliminarJugador}></PlayerTable>
        </>
    );

};

export default TeamApp;