import React from 'react';
import { useCart } from '../context/CartContext.jsx';

const Producto = ({ producto }) => {
    const { addToCart,removeFromCart, updateQuantity, cart } = useCart();

    const productoEnCarrito = cart.find(item => item.asin === producto.asin);

    return (
        <div className="min-product-card">
            <div className="min-card-image">
                <img
                    src={producto.imgUrl}
                    alt={producto.title}
                    onError={(e) => e.target.src = 'https://placehold.co/300x300/f5f5f5/999999?text=No+Image'}
                />
            </div>
            <div className="min-card-info">
                <h3 className="min-product-title" title={producto.title}>{producto.title}</h3>
                <div className="stars">{producto.stars}★</div>
                <div className="min-price">{producto.price}€</div>

                {!productoEnCarrito ? (
                    <button className="btn-add" onClick={() => addToCart(producto)}>
                        Añadir al carrito
                    </button>
                ) : (
                    <div className="controles-lujo">
                        <div className="selector-cantidad">
                            <button onClick={() => updateQuantity(producto.asin, -1)}>-</button>
                            <span>{productoEnCarrito.cantidad}</span>
                            <button onClick={() => updateQuantity(producto.asin, 1)}>+</button>
                        </div>
                        <button
                            className="btn-eliminar-total"
                            onClick={() => removeFromCart(producto.asin)}
                        >
                            Limpiar
                        </button>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Producto;