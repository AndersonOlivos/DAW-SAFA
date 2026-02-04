import React from 'react';
import {useState} from "react";
import { Link } from 'react-router-dom';
import PlayerTable from "./components/PlayerTable.jsx";
import PlayerForm from "./components/PlayerForm.jsx";
import "./App.css"


const TeamApp = () => {


    const [jugadores, setJugadores] = useState([
        {id: crypto.randomUUID(), nombre: 'Antonio', dorsal: 10, posicion: 'Colocador', altura: 190},
        {id: crypto.randomUUID(), nombre: 'Fernanda', dorsal: 1, posicion: 'Receptor', altura: 199}
    ]);

    const [formModoEdicion, setFormModoEdicion] = useState(false)

    const [jugadorSeleccionadoEditar, setJugadorSeleccionadoEditar] = useState(null)

    const [estadoModalEliminarJugador, setEstadoModalEliminarJugador] = useState(false)

    const [jugadorEliminar, setJugadorEliminar] = useState(null);

    const anadirJugador = (jugador) => {
        setJugadores([...jugadores, jugador]);
        setFormModoEdicion(false);
        setJugadorSeleccionadoEditar(null);
    }

    const eliminarJugador = (idJugadorEliminar) => {
        setEstadoModalEliminarJugador(true);
        setJugadorEliminar(jugadores.filter(jugador => jugador.id === idJugadorEliminar)[0])
    }

    const editarJugador = (idJugador) => {
        mostrarDatosJugador(idJugador);
    }

    const confirmarEditarJugador = (jugadorEditado) => {
        const jugadoresActualizados = jugadores.map(j =>
            j.id === jugadorEditado.id ? jugadorEditado : j
        );
        setJugadores(jugadoresActualizados);
        setFormModoEdicion(false);
        setJugadorSeleccionadoEditar(null);
    }

    const confirmarEliminarJugador = (idJugador) => {
        setJugadores(jugadores.filter((jugador) => jugador.id !== idJugador));
        setJugadorEliminar(null);
        setEstadoModalEliminarJugador(false)
    }

    const mostrarDatosJugador = (idJugador) => {
        setFormModoEdicion(true);
        setJugadorSeleccionadoEditar(jugadores.filter((jugador) => jugador.id === idJugador));
    }

    const cancelarModoEdicion = () => {
        setFormModoEdicion(false);
        setJugadorSeleccionadoEditar(null);
    }

    const ordenarJugadores = (ascendente) => {
        if (ascendente) {
            setJugadores(jugadores.sort((a, b) => a.dorsal - b.dorsal));
        } else {
            setJugadores(jugadores.sort((a, b) => b.dorsal - a.dorsal));
        }
    }

    return (
        <>
            <Link to="/ejercicio3">Ir al Ejercicio 3</Link>
            <h1>GESTOR DE JUGADORES VOLEIBOL</h1>
            <PlayerForm key={jugadorSeleccionadoEditar?.[0]?.id}
                        modoEdicion = {formModoEdicion}
                        cancelarModoEdicion = {cancelarModoEdicion}
                        datosJugadorEditar = {jugadorSeleccionadoEditar}
                        editarJugadorSeleccionado={confirmarEditarJugador}
                        anadirJugador = {anadirJugador}
                        jugadores = {jugadores}
            ></PlayerForm>
            <PlayerTable jugadores={jugadores}
                         handleEditarJugador={editarJugador}
                         handleEliminarJugador={eliminarJugador}
                         ordenarJugadores = {ordenarJugadores}
            ></PlayerTable>


            {estadoModalEliminarJugador && jugadorEliminar !== null &&
                <div className="contenedorModalEliminar">
                    <div className="modalEliminar">
                        <p>¿Estás seguro de que quieres eliminar a {jugadorEliminar.nombre}?</p>
                        <button onClick={() => confirmarEliminarJugador(jugadorEliminar.id)}>Confirmar</button>
                        <button onClick={() => {setJugadorEliminar(null); setEstadoModalEliminarJugador(false)}}>Cancelar</button>
                    </div>
                </div>
            }
        </>
    );

};

export default TeamApp;