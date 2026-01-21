a = ((1, 2, 3),(3, 2, 1))
b = ((1, 2),(3, 4),(5, 6))
def producto(a, b):
    producto = []
    for i in range(len(a)):
        fila = []
        for j in range(len(a)):
            suma = 0
            for k in range(len(b)):
                suma += a[i][k] * b[k][j]
            fila.append(suma)
        producto.append(tuple(fila))
    return tuple(producto)
print(producto(a, b))