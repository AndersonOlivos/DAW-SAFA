import React, {useState, useEffect} from 'react';
import carrito from "../assets/carrito.png"
import "../styles/home.css";
import {useProductos} from "../hooks/useProductos.jsx";
import {Link} from "react-router-dom";
import Navbar from "../components/navbar.jsx";

const Productos = () => {

    const { productos, cargando, error } = useProductos();

    return (
        <div className="home-page">
            <Navbar />

            <main className="nuestros-productos-seccion">
                <div className="container">
                    <h2 className="section-heading">Nuestro productos</h2>

                    {cargando && <p style={{textAlign: 'center', color: '#777'}}>Cargando...</p>}
                    {error && <p style={{textAlign: 'center', color: 'red'}}>Error</p>}

                    {!cargando && !error && (
                        <>
                            <div className="minimal-product-grid">
                                {productos.map((producto) => (
                                    <div key={producto.asin} className="min-product-card">
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
                                        </div>
                                    </div>
                                ))}
                            </div>
                        </>
                    )}
                </div>
            </main>

            <footer className="main-footer">
                <div className="container">
                    <p>&copy; 2026 SafaShop. Maletas de alta gama.</p>
                </div>
            </footer>
        </div>
    );
};

export default Productos;