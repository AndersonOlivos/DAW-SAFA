import React from 'react';

const Saludo = ({nombre}) => {

    return (
        <>
            <h1>Saludo</h1>
            <p>¡Hola {nombre}! Te mando un saludo desde el componente Saludo.</p>
        </>
    );
};

export default Saludo;