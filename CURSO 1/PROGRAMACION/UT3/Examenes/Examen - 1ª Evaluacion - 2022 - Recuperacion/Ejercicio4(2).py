lista_palabras=input("Escribe una lista de palabras separada por comas: ")
numeros=input("Escribe una lista de números separada por comas: ")

lista_palabras=lista_palabras.split(",")
numeros=numeros.split(",")

if len(lista_palabras)==len(numeros):
    for a in range(len(lista_palabras)):
        print(lista_palabras[a]*int(numeros[a]))
            
else:
    print("No se pudo realizar la operación.")