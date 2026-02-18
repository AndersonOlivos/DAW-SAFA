import React from 'react';
import "../styles/home.css";
import { useProductos } from "../hooks/useProductos.jsx";
import Navbar from "../components/navbar.jsx";
// 1. Importamos el nuevo componente
import Producto from "../components/Producto.jsx";

const Productos = () => {
    const { productos, cargando, error } = useProductos();

    return (
        <div className="home-page">
            <Navbar />

            <main className="nuestros-productos-seccion">
                <div className="container">
                    <h2 className="section-heading">Nuestros productos</h2>

                    {cargando && <p style={{textAlign: 'center', color: '#777'}}>Cargando...</p>}
                    {error && <p style={{textAlign: 'center', color: 'red'}}>Error</p>}

                    {!cargando && !error && (
                        <div className="minimal-product-grid">
                            {productos.map((producto) => (
                                <Producto key={producto.asin} producto={producto} />
                            ))}
                        </div>
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