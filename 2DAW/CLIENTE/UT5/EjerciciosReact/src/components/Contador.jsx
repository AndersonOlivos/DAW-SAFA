import React, {useState} from 'react';

const Contador = () => {

    const [contador, setContador] = useState(0);

    const incrementar = () => {
        setContador(contador => contador + 1);
        mensaje("Contador incrementado")
    }

    const decrementar = () => {
        if (contador> 0){
            setContador(contador => contador - 1);
            mensaje("Contador decrementado")
        }
    }

    const resetear = () => {
        setContador(0)
        mensaje("Contador reseteado")
    }

    const mensaje = (texto) => {
        console.log(texto);
    }


    return (
        <div>
            <h1>Contador</h1>
            <p>{contador}</p>
            <button onClick={incrementar}>Incrementar</button>
            <button onClick={decrementar}>Decrementar</button>
            <button onClick={resetear}>Resetear</button>
        </div>
    );
};

export default Contador;