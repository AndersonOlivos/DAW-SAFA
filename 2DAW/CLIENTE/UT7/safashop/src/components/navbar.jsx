import React, {useState} from 'react';
import "../styles/home.css"
import {Link} from "react-router-dom";
import iconoCarrito from "../assets/carrito.png";
import Carrito from "./carrito.jsx";
import {useCart} from "../context/CartContext.jsx";

const Navbar = () => {

    const [mostrarCarrito, setMostrarCarrito] = useState(false);

    const {cart} = useCart();

    const toggleCarrito = () => {
        setMostrarCarrito(!mostrarCarrito);
    }

    return (
        <>
            {mostrarCarrito &&
                <Carrito toggleCarrito = {toggleCarrito}></Carrito>}

    <header className="main-header">
            <div className="container header-content">
                <div className="logo">SafaShop.</div>
                <nav className="main-nav">
                    <ul>
                        <li>
                            <Link to="/">Inicio</Link>
                        </li>
                        <li>
                            <Link to="/productos">Ver productos</Link>
                        </li>
                        <li>
                            <Link to="/productos">Añadir producto</Link>
                        </li>
                        <li>
                            <Link to="/productos">Editar producto</Link>
                        </li>
                        <li>
                            <Link to="/productos">Eliminar producto</Link>
                        </li>
                    </ul>
                </nav>
                <div className="header-icons">
                    <button className="cart-icon" onClick={()=>setMostrarCarrito(!mostrarCarrito)}>
                        <img src={iconoCarrito} alt="carrito"/>
                        <span className="cart-count">{cart.length}</span>
                    </button>
                </div>
            </div>
        </header>
        </>
    );
};

export default Navbar;