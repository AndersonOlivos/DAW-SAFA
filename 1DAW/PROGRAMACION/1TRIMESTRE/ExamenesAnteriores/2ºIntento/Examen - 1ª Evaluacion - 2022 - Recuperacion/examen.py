def ejercicio1(texto):
    vocales = ['a','e','i','o','u']
    count = 0
    for letra in texto:
        if letra.isupper() and letra not in vocales:
            count+=1
    return count

#print(ejercicio1("Finalmente tras el día de ayer el Real Madrid y el Barcelona siguen adelante en la Copa del Rey"))

def ejercicio2(lista):
    new_lista = []
    for numero in lista:
        if numero % 2 == 0 and numero % 3 == 0 and str(numero).isdigit():
            new_lista.append(numero)

    return new_lista

#print(ejercicio2([4.5 , 6 , 10.3 , 12.4 , 15.0 , 18 , 24 ]))

def ejercicio3(futbolistas, num_personas):

    medias=[]
    for futbolista in range(len(futbolistas)):
        print(f"------------------- VALORACIÓN {futbolistas[futbolista].upper()} ----------------------")
        media = 0
        for i in range(num_personas):
            media = media + int(input(f'Persona {i+1} --> '))

        media = media / num_personas
        medias.append(media)



    print('------------------- RESUMEN VALORACIONES ----------------------')


    for futbolista in range(len(futbolistas)):
        print(f'{futbolistas[futbolista]} (Media Obtenida) --> {medias[futbolista]}')


futbolistas = ['MBappie', 'Messa', 'Awero']
num_personas = 2
#ejercicio3(futbolistas, num_personas)

dics = [{
"modelo" : "Gallardo",
"marca" : "Lamborghini",
"tipo" : "Deportivo",
"puertas" : 3
},
{
"modelo" : "Murciélago GT",
"marca" : "Lamborghini",
"tipo" : "Carrera",
"puertas" : 2
},
{
"modelo" : "Twingo",
"marca" : "Renault",
"tipo" : "Normal",
"puertas" : 5
}]


def ejercicio4a_a(lista_coches):
    return sorted(lista_coches, key=lambda coche: coche['puertas'])

def ejercicio4a_b(lista_coches,marca):
    new_lista=[]
    for coche in lista_coches:
        if coche['marca'].lower() == marca.lower():
            new_lista.append(coche)

    return new_lista

def ejercicio4a_c(modelos, marcas, tipos, puertas):

    new_lista = []

    for i in range(len(modelos)):
        new_lista.append(dict(modelo = modelos[i], marca = marcas[i], tipo = tipos[i], puertas = puertas[i]))

    return new_lista

#print(ejercicio4a_a(dics))
#print(ejercicio4a_b(dics,'lamborghini'))

modelos = ["Gallardo", "Murciélago GT", "Twingo"]
marcas = ["Lamborghini", "Lamborghini", "Renault"]
tipos = ["Deportivo", "Carrera", "Normal"]
evo = [3, 2, 5]

#print(ejercicio4a_c(modelos, marcas, tipos, evo))

def ejercicio4b(lista_palabra,numeros):
    if len(lista_palabra) != len(numeros):
        print('No puedo realizar la operación')
    else:
        for p in range(len(lista_palabra)):
            for n in range(numeros[p]):
                print(lista_palabra[p], end=' ')
            print('')


lista_palabras = ['hola','como','estas']
numeros = [3,1,1]

#ejercicio4b(lista_palabras, numeros)