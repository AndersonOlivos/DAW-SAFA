import React, {useState} from 'react';

const FormularioSimple = () => {

    const [inputNombre, setInputNombre] = useState('');

    const [inputCorreo, setInputCorreo] = useState('');

    const [datoFormulario, setDatoFormulario] = useState('');

    const[mensajeError, setMensajeError] = useState([false, '']);

    const enviarFormulario = (e) => {
        e.preventDefault();
        setDatoFormulario(inputNombre);
    }

    const validarFormulario = () => {
        const REGEX_CORREO = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i
        if(!REGEX_CORREO.test(inputCorreo)){
            errorFormulario("Introduce un correo válido")
        } else {
            setMensajeError([false, '']);
        }
    }

    const errorFormulario = (texto) => {
      setMensajeError([true,texto])
    }

    return (
        <div>
            <h1>Formulario</h1>
            <form onSubmit={enviarFormulario}>
                <label>Nombre</label>
                <input onChange={(e) => setInputNombre(e.target.value)}
                       value={inputNombre} />
                <label>Correo electrónico</label>
                <input onChange={(e) => {setInputCorreo(e.target.value);
                validarFormulario()}}
                       value={inputCorreo}/>
                {mensajeError[0] ? <p className="p-validar-correo">{mensajeError[1]}</p> : null}
                <button type="submit">Enviar</button>
            </form>
            <p>{datoFormulario}</p>
        </div>
    );
};

export default FormularioSimple;