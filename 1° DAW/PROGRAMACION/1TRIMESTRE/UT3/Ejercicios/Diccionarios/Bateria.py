#Ejercicio 1

juguetes = {
    'pelota' : 10,
    'muneca' : 15,
    'coche' : 20,
    'rompecabezas' : 18,
    'peluche' : 12,
    'robot' : 25,
    'pistola de agua' : 8,
    'tren de juguete' : 22,
    'oso de peluche' : 14,
    'cometa' : 10,
    'bloques de construccion' : 30,
    'balon de futbol' : 16,
    'patineta' : 35,
    'avion de juguete' : 24,
    'casa de munecas' : 28
}

#Ejercicio 2

#key_usuario = input('Escribe el nombre del juguete para saber su precio: ')
#print(juguetes[key_usuario])

#Ejercicio 3

#juguetes['pelota'] = 20
#print(juguetes)

#Ejercicio 4

#juguetes['pelota tenis'] = 90
#print(juguetes)

#Ejercicio 5

#for key,value in juguetes.items():
#    print("Juguete:",key," - Precio: ",value,"$")

#Ejercicio 6

#total = 0
#for key,value in juguetes.items():
#    total += value
    
#print("Precio promedio de todos los juguetes: ",(total/len(juguetes)))

#Ejercicio 7

#key_eliminar = input("Introduce la clave a eliminar: ")
#juguetes.pop(key_eliminar)
#print(juguetes)

#Ejercicio 8

#precio_limite = int(input("Introduce un precio limite: "))
#for key,value in juguetes.items():
#    if value <= precio_limite:
#        print(key,":",value)

#Ejercicio 9

#comprar = input("Introduce los juguetes a comprar separados por comas: ")
#comprar_lista = comprar.split(",")
#precio_compra = 0
#for jug in comprar_lista:
#    if juguetes[jug]:
#        precio_compra += juguetes[jug]
#    else:
#        print("No tenemos este juguete")

#print("PRECIO TOTAL: ",precio_compra,"$")

#Ejercicio 10

#maximo = 0
#for key,value in juguetes.items():
#    if value > maximo:
#        maximo = value        
#print("Valor maximo:",maximo)