lista_palabras=['Este','fin','de','semana','ha','sido','la','Magna','de','Sevilla']

def ejercicio1(lista):
    longitudes = []
    for a in range(21):
        longitudes.append([])

    for palabra in lista:
        longitudes[len(palabra)].append(palabra)

    for longitud in range(len(longitudes)):
        if len(longitudes[longitud]) !=0:
            print(f'Palabras de {longitud} letras: {longitudes[longitud]}')

#ejercicio1(lista_palabras)

def ejercicio3(numero, multiplos):
    lista = []
    for i in range(1,multiplos+1):
        lista.append(i*numero)
    return lista

#print(ejercicio3(2,7))


regalos_navideños = [{
    'nombre': 'Bicicleta',
    'precio': 150.99,
    'edad_recomendada': 8,
    'nombre': True,
    'colores_disponibles': ['Rojo','Azul','Verde'],
    'peso': 12.5,
},{
    'nombre': 'Muñeca Parlante',
    'precio': 49.99,
    'edad_recomendada': 4,
    'nombre': True,
    'colores_disponibles': ['Rosa','Violeta'],
    'peso': 1.2,
},{
    'nombre': 'Muñeca Parlante',
    'precio': 39.99,
    'edad_recomendada': 4,
    'nombre': True,
    'colores_disponibles': ['Rosa','Violeta'],
    'peso': 1.2,
}
]

def ejercicio5_a(lista):
    lista_colores=[]
    for dic in lista:
        for color in dic['colores_disponibles']:
            if color not in lista_colores:
                lista_colores.append(color)

    return lista_colores

#print(ejercicio5_a(regalos_navideños))

def ejercicio5_b(lista):
    total = 0
    for regalo in lista:
        total+=regalo['precio']

    media = total/len(lista)
    return media

#print(ejercicio5_b(regalos_navideños))

def ejercicio5_c(lista, disponible):
    base = 0
    comprar = []
    for juguete in lista:
        if juguete['precio'] <= disponible:
            disponible = disponible - juguete['precio']
            base = base + juguete['precio']
            comprar.append(juguete)
        else: break

    print(f'Total a gastar: {base}')
    return comprar

#print(ejercicio5_c(regalos_navideños,200))
