import React from 'react';
import "../styles/home.css";
import "../styles/carrito.css";
import {useCart} from "../context/CartContext.jsx";

const Carrito = ({ toggleCarrito }) => {
    const { cart, updateQuantity, removeFromCart } = useCart();

    return (
        <div className="carrito">
            <button className="close-carrito" onClick={toggleCarrito}>x</button>
            <h4>Tu selección de lujo</h4>
            {cart.map((item) => (
                <div key={item.asin} className="cart-item">
                    <h5>{item.title}</h5>
                    <div className="qty-controls">
                        <button onClick={() => updateQuantity(item.asin, -1)}>-</button>
                        <span>{item.cantidad}</span>
                        <button onClick={() => updateQuantity(item.asin, 1)}>+</button>
                    </div>
                    <p>{(item.price * item.cantidad).toFixed(2)}€</p>
                    <button onClick={() => removeFromCart(item.asin)}>Eliminar</button>
                </div>
            ))}
            {/* Cálculo del total con reduce (Requisito RA7) */}
            <div className="total">
                <strong>Total: {cart.reduce((acc, item) => acc + (item.price * item.cantidad), 0).toFixed(2)}€</strong>
            </div>
        </div>
    );
};

export default Carrito;