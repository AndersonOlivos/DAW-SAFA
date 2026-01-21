import React from 'react';

const Ejercicio1 = () => {

    const validarDireccionCorreo = (correo) => {
        const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if(regex.test(correo)) {
            return 'Sí';
        } else {
            return 'No';
        }
    }

    return (
        <div>
            <h4>Ejercicio 1 - Correo Electrónico</h4>
            <p>Correo: prueba@gmail.com</p>
            <p>Valido: {validarDireccionCorreo('prueba@gmail.com')}</p>
            <p>Correo: prueba@gmail@.com</p>
            <p>Valido: {validarDireccionCorreo('prueba@gmail@.com')}</p>
        </div>
    );
};

export default Ejercicio1;