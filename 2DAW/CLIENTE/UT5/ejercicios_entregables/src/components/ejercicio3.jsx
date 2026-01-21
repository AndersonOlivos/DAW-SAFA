import React, {useState} from 'react';
import '../style/ejercicio3.css'

const Ejercicio3 = () => {
    const [form, setForm] = useState({ nombre: "", email: "", edad: "" });
    const [errors, setErrors] = useState({});
    const [touched, setTouched] = useState({});
    const [resumen, setresumen] = useState(null);

    const palabrasMinusculas = ["de", "del", "la", "las", "los"];

    const handleBlur = e => {
        const { name } = e.target;
        setTouched(prev => ({ ...prev, [name]: true }));
        validarCampo(name, form[name]);
    };

    const handleChange = e => {
        const { name, value } = e.target;
        setForm(prev => ({ ...prev, [name]: value }));
        if (touched[name]) validarCampo(name, value);
    };

    const validarCampo = (name, value) => {
        let error = "";
        if (!value) error = "Campo obligatorio";
        else {
            if (name === "email") {
                const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!regexEmail.test(value)) error = "Email inválido";
            }
            if (name === "nombre") {
                const palabras = value.split(" ");
                for (let p of palabras) {
                    if (palabrasMinusculas.includes(p.toLowerCase())) {
                        if (p !== p.toLowerCase()) {
                            error = "Palabra inválida en minúsculas";
                            break;
                        }
                    } else {
                        if (!/^[A-Z][a-z]+$/.test(p)) {
                            error = "Cada palabra debe empezar en mayúscula y seguir en minúscula";
                            break;
                        }
                    }
                }
            }
            if (name === "edad") {
                const num = Number(value);
                if (!Number.isInteger(num) || num <= 0 || num >= 100) {
                    error = "Edad debe ser un número positivo menor que 100";
                }
            }
        }
        setErrors(prev => ({ ...prev, [name]: error }));
        return error === "";
    };

    const handleSubmit = e => {
        e.preventDefault();
        const fields = ["nombre", "email", "edad"];
        let valid = true;
        fields.forEach(f => {
            const ok = validarCampo(f, form[f]);
            if (!ok) valid = false;
        });
        if (valid) setresumen(form);
    };

    return (
        <div>
            <h1>Ejercicio 3</h1>
            <form onSubmit={handleSubmit} noValidate>
                <div>
                    <input
                        type="text"
                        name="nombre"
                        placeholder="Nombre"
                        value={form.nombre}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        className="inputFormulario"
                    />
                    {errors.nombre && touched.nombre && <div className="error">{errors.nombre}</div>}
                </div>

                <div>
                    <input
                        type="text"
                        name="email"
                        placeholder="Email"
                        value={form.email}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        className="inputFormulario"
                    />
                    {errors.email && touched.email && <div className="error">{errors.email}</div>}
                </div>

                <div>
                    <input
                        type="number"
                        name="edad"
                        placeholder="Edad"
                        value={form.edad}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        className="inputFormulario"
                    />
                    {errors.edad && touched.edad && <div className="error">{errors.edad}</div>}
                </div>

                <button type="submit" style={{ padding: "5px 15px", borderRadius: "5px" }}>Enviar</button>
            </form>

            {resumen && (
                <div className="resumen">
                    <h3>Resumen</h3>
                    <p><strong>Nombre:</strong> {resumen.nombre}</p>
                    <p><strong>Email:</strong> {resumen.email}</p>
                    <p><strong>Edad:</strong> {resumen.edad}</p>
                </div>
            )}
        </div>
    );
};

export default Ejercicio3;