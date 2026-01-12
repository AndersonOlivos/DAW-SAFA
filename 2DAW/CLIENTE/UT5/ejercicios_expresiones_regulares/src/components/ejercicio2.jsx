import React from 'react';

const Ejercicio2 = () => {

    const validarCodigoPostal = (cp) => {
        const regex = /[0-9]{5}/;
        if(regex.test(cp)) {
            return 'Sí';
        } else {
            return 'No';
        }
    }

    const validarFecha = (fecha) => {
        const regex = /[0-9]+\/[0-9]+\/[0-9]{4,}/;
        if(regex.test(fecha)) {
            return 'Sí';
        } else {
            return 'No';
        }
    }

    const validarMatricula = (matricula) => {
        const regex = /^\d{4}[A-Z]{3}/;
        if(regex.test(matricula)) {
            return 'Sí';
        } else {
            return 'No';
        }
    }

    const extraccionPalabras = (frase) => {
        const regex = /\b\w+\b/g;
        return frase.match(regex) || [];
    }

    const extraccionNumeros = (frase) => {
        const regex = /\b\d+\b/g;
        return frase.match(regex) || [];
    }

    const validarTelefono = (telefono) => {
        const regex = /^(\+34\s?)?(\d{3}\s?\d{3}\s?\d{3})$/;
        return regex.test(telefono) ? 'Sí' : 'No';
    }

    const extracionPalabrasConA = (frase) => {
        const regex = /\w*a\w*/ig;
        return frase.match(regex) || [];
    }

    const extracionPalabrasConHastag = (frase) => {
        const regex = /#.\w+/g;
        return frase.match(regex) || [];
    }

    const extraccionURL = (frase) => {
        const regex = /(https?:\/\/)(www\.)?\w+\.\w{2,}\/?/g;
        return frase.match(regex) || [];
    }

    return (
        <div>
            <div>
                <h4>Ejercicio 2 - Código Postal</h4>
                <p>CP: 28080</p>
                <p>Valido: {validarCodigoPostal('28080')}</p>
                <p>CP: 2808</p>
                <p>Valido: {validarCodigoPostal('2808')}</p>
            </div>
            <div>
                <h4>Ejercicio 3 - Fecha</h4>
                <p>Fecha: 20/10/2001</p>
                <p>Valido: {validarFecha('20/10/2001')}</p>
                <p>Fecha: 20/10/21</p>
                <p>Valido: {validarFecha('20/10/21')}</p>
            </div>
            <div>
                <h4>Ejercicio 4 - Matrícula</h4>
                <p>Matrícula: 1234ABC</p>
                <p>Valido: {validarMatricula('1234ABC')}</p>
                <p>Matrícula: 123AABC</p>
                <p>Valido: {validarMatricula('123AABC')}</p>
                <p>Matrícula: 1234abc</p>
                <p>Valido: {validarMatricula('1234abc')}</p>
            </div>
            <div>
                <h4>Ejercicio 5 - Extraccion palabras</h4>
                <p>Frase: Hola mundo!</p>
                {extraccionPalabras("Hola mundo!").map((palabra, index) => (
                    <p key={index}>{palabra}</p>
                ))}
            </div>
            <div>
                <h4>Ejercicio 6 - Extraccion números</h4>
                <p>Frase: Hay 3 gatos y 7 perros</p>
                {extraccionNumeros("Hay 3 gatos y 7 perros").map((numero, index) => (
                    <p key={index}>{numero}</p>
                ))}
            </div>
            <div>
                <h4>Ejercicio 7 - Número telefónico</h4>
                <p>Teléfono: +34 123 456 789</p>
                <p>Valido: {validarTelefono('+34 123 456 789')}</p>
                <p>Teléfono: 123 456 789 </p>
                <p>Valido: {validarTelefono('123 456 789')}</p>
                <p>Teléfono: 123 456 7891</p>
                <p>Valido: {validarTelefono('123 456 7891')}</p>
            </div>
            <div>
                <h4>Ejercicio 8 - Extraccion números</h4>
                <p>Frase: Hay 3 gatos y 7 perros</p>
                {extracionPalabrasConA("Hay 3 gatos y 7 perros").map((palabra, index) => (
                    <p key={index}>{palabra}</p>
                ))}
            </div>
            <div>
                <h4>Ejercicio 9 - Extraccion hastags</h4>
                <p>Frase: Me encanta #Python y #programación</p>
                {extracionPalabrasConHastag("Me encanta #Python y #programacion").map((palabra, index) => (
                    <p key={index}>{palabra}</p>
                ))}
            </div>
            <div>
                <h4>Ejercicio 10 - Extraccion URLs</h4>
                <p>Frase: Visita http://example.com o https://www.google.com</p>
                {extraccionURL("Visita http://example.com o https://www.google.com").map((url, index) => (
                    <p key={index}>{url}</p>
                ))}
            </div>
        </div>
    );
};

export default Ejercicio2;