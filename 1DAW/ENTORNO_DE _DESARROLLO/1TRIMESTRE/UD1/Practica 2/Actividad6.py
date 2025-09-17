def procesar_datos(datos):
    resultados = []
    for dato in datos:
        if (type(dato) == int or type(dato) == float):
            if dato >= 0:
                resultados.append(dato * 2)
            elif dato < 0:
                resultados.append(abs(dato) * 2)

    promedio = sum(resultados) / len(resultados)
    return promedio, resultados

lista_datos = [10, -3, 0, 5, 'a', -8]
promedio, resultados = procesar_datos(lista_datos)
print("Promedio de los resultados:", promedio)
print("Lista de resultados procesados:", resultados)