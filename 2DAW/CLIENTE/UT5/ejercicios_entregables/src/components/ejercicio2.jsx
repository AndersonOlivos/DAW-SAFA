import React, {useState} from 'react';

const Ejercicio2 = () => {
    const [logs, setLogs] = useState("");
    const [stopPropagation, setStopPropagation] = useState(false);

    const addLog = elemento => {
        setLogs(prev => prev + `${elemento}\n`);
    };

    const handleButtonClick = e => {
        if (stopPropagation) {
            e.stopPropagation();
        }
        addLog("botón");
    };

    return (
        <div>
            <h1>Ejercicio 2</h1>

            <label>
                <input
                    type="checkbox"
                    checked={stopPropagation}
                    onChange={e => setStopPropagation(e.target.checked)}
                />
                Detener propagación
            </label>

            <div
                style={{ padding: "20px", border: "2px solid white", marginTop: "20px" }}
                onClick={() => addLog("contenedor")}
            >
                Contenedor
                <div
                    style={{ padding: "20px", border: "2px solid gray", marginTop: "10px" }}
                    onClick={() => addLog("subcontenedor")}
                >
                    Subcontenedor
                    <br /><br />
                    <button onClick={handleButtonClick}>
                        Botón
                    </button>
                </div>
            </div>

            <br />

            <textarea
                value={logs}
                readOnly
                rows="10"
                cols="40"
            />
        </div>
    );
};

export default Ejercicio2;