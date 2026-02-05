import React from 'react';
import "../styles/home.css"
import "../styles/carrito.css"

const Carrito = ({toggleCarrito}) => {
    return (
        <div className="carrito">
            <button className="close-carrito" onClick={toggleCarrito}>x</button>
            <h4>Tu carrito</h4>
        </div>
    );
};

export default Carrito;