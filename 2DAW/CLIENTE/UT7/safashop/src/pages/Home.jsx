import React from 'react';
import "../styles/home.css";
import {useProductos} from "../hooks/useProductos.jsx";
import {Link} from "react-router-dom";
import Navbar from "../components/navbar.jsx";
import Carrito from "../components/carrito.jsx";

const Home = () => {

    const { productos, cargando, error } = useProductos();

    return (
        <div className="home-page">

            <Navbar />
            <section className="hero-section">
                <div className="container hero-content">
                    <div className="hero-text-col">
                        <h1>Viajar nunca fue tan fácil</h1>
                        <p>Descubre nuestra nueva colección. Diseño exclusivo y calidad premium.</p>
                        <Link className="btn btn-primary" to="/productos">Ver productos</Link>
                    </div>
                    <div className="hero-image-col">
                        <img src="https://media.istockphoto.com/id/1376567987/es/foto/un-hombre-de-negocios-an%C3%B3nimo-caminando-con-equipaje-en-el-aeropuerto.jpg?s=612x612&w=0&k=20&c=wxVdueQ__zt8f8vh6K6aap0Gz4dZGfpde9EED_6sdeo=" />
                    </div>
                </div>
            </section>

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

export default Home;