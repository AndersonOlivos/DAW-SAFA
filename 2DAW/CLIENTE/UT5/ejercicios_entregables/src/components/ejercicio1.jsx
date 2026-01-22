import React, {useState} from 'react';

const Ejercicio1 = () => {

    const [logs, setLogs] = useState("");
    const [text, setText] = useState("");



    const addLog = (evento, elemento, info = "") => {
        setLogs(prev => prev + `${evento} - ${elemento} ${info}\n`);
    };


    return (
        <div>
            <h1>Ejercicio 1</h1>
            <div style={{display: "flex", justifyContent: "space-between", gap: "2rem"}}>
                <div style={{display: "flex", flexDirection: "column", justifyContent: "flex-start", gap: "2rem"}}>
                    <button
                        onClick={() => addLog("click", "botón")}
                        onMouseOver={() => addLog("mouseover", "botón")}>
                        Botón
                    </button>
                    <input
                        style={{padding: "0.5rem 1rem", border: "none", borderRadius: "10px"}}
                        type="text"
                        value={text}
                        onChange={e => {
                            setText(e.target.value);
                            addLog("input", "input", `valor: ${e.target.value}`);
                        }}
                        onKeyDown={e => addLog("keydown", "input", `tecla: ${e.key}`)}/>
                    <a
                        style={{
                            backgroundColor: "whitesmoke",
                            padding: "0.5rem 1rem",
                            cursor: "pointer",
                            borderRadius: "10px"
                        }}
                        href="#"
                        onClick={e => {
                            e.preventDefault();
                            addLog("click", "enlace");
                        }}>
                        Enlace
                    </a>
                    <div
                        style={{
                            width: "200px",
                            height: "100px",
                            border: "1px solid white",
                            borderRadius: "10px",
                            cursor: "pointer"
                        }}
                        onClick={e =>
                            addLog("click", "zona interactiva", `x:${e.clientX} y:${e.clientY}`)
                        }
                        onMouseOver={() => addLog("mouseover", "zona interactiva")}
                    > Zona interactiva <br/> Haz clic donde quieras!
                    </div>
                </div>
                <textarea style={{padding: '0.5rem', border: "none", borderRadius: "10px", resize: "none"}}
                          value={logs}
                          readOnly
                          rows="45"
                          cols="50"/>
            </div>
        </div>
    );
};

export default Ejercicio1;