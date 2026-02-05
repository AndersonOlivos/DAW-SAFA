import { apiFetch } from './api';

export function getProductos() {
    return apiFetch('/rest/v1/producto?select=*');
}
