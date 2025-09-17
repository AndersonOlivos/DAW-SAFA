def ejercicio1(lista,texto):

    def sin_tildes(cadena):
        cadena=cadena.lower()
        cadena=cadena.replace('á' , 'a')
        cadena=cadena.replace('é' , 'e')
        cadena=cadena.replace('í' , 'i')
        cadena=cadena.replace('ó' , 'o')
        cadena=cadena.replace('ú' , 'u')
        return cadena

    print("--RECUENTO DE PALABRAS--")

    for palabra in lista:
        print(palabra,":",sin_tildes(texto).count(sin_tildes(palabra)))

#ejercicio1(["TITI", "Novia'", "Casa", "bunny"],"Ey, Tití me preguntó Si tengo muchas novia' Muchas novia' Hoy tengo a una, mañana otra Ey, pero no hay boda Tití me preguntó Si tengo muchas novia' Je, muchas novia' Hoy tengo a una, mañana otra")

lista_pokemon = [{
"nombre " : "Treecko",
"pokédex" : 252,
"tipo" : ["PLANTA"],
"evo" : 1
},
{
"nombre " : "Roselia",
"pokédex" : 407,
"tipo" : ["PLANTA", "VENENO"],
"evo" : 2
},
{
"nombre " : "Milotic",
"pokédex" : 350,
"tipo" : ["AGUA"],
"evo" : 2
},
{
"nombre " : "Altaria",
"pokédex" : 334,
"tipo" : ["VOLADOR", "DRAGÓN"],
"evo" : 2
}]

preguntas= ["¿Cuál es tu color favorito?", "¿Cuántos años tienes?"]
num_personas = 3

def ejercicio2(lista_preguntas, num_personas):

    respuestas = []

    for num in range(num_personas):
        print("------------------- ENTREVISTADO",num+1,"---------------------------")
        for pregunta in lista_preguntas:
            print(pregunta," ")
            respuestas[num].append(input())

    print("------------------- RESUMEN ENCUESTA ---------------------------")
    print("----------------------------------------------------------------")

    for num in range(len(lista_preguntas)):
        print("pregunta",num+1,"-->",lista_preguntas[num])
        print("respuestas -->",)


ejercicio2(preguntas,num_personas)

def ejercicio3_a(lista):

    return sorted(lista, key=lambda dic: dic["pokédex"], reverse=True)

#print(ejercicio3_a(lista_pokemon))

def ejercicio3_b(lista, tipo):
    new_lista=[]
    for dic in lista:
        if tipo.upper() in dic["tipo"]:
            new_lista.append(dic)
    return new_lista

#print(ejercicio3_b(lista_pokemon,"VOLADOR"))


nombres = ["Treecko", "Roselia", "Milotic", "Altaria"]
numeros = [252, 407, 350, 334]
tipos= [ ["PLANTA"] , ["PLANTA", "VENENO"] , ["AGUA"] , ["VOLADOR", "DRAGÓN"] ]
evo= [1, 2, 2, 2]

def ejercicio3_c(nombres, numeros, tipos, evo):
    new_lista=[]
    for pokemon in range(len(nombres)):
        new_lista.append(dict(nombre = nombres[pokemon], pokédex = numeros[pokemon], tipo = tipos[pokemon], evo = evo[pokemon]))
    return new_lista

#print(ejercicio3_c(nombres, numeros, tipos, evo))


def ejercicio4(numero):

    lista_divisibles=[]

    for num in range(1,11):
        if numero%num == 0:
            lista_divisibles.append(num)

    print("Es divisible por", lista_divisibles)

#ejercicio4(72)