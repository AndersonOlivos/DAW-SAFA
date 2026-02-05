import { useEffect, useState } from 'react';
import { getProductos } from '../services/productoService.jsx';

export function useProductos() {
    const [productos, setProductos] = useState([]);
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getProductos()
            .then(setProductos)
            .catch(err => setError(err.message))
            .finally(() => setCargando(false));
    }, []);

    console.log(productos)

    return { productos, cargando, error };
}
