texto=input("Escribe una cadena de texto:\n\n")

lista_texto=list(texto) #Convertimos el texto en una lista para recorrerla

for a in range(len(lista_texto)): #Recorremos el texto con índice "a" 
    if a%2==0: #Si el módulo de la división es 0 entonces imprimimos la letra
        print(lista_texto[a],end="")
    else:
        if lista_texto[a].isalpha(): #Si es una letra la remplaza por una X
            print("X",end="")
        else: #Si el caracter no es una letra, lo imprime tal cual. Utilizamos esto para que no tome en cuenta los espacios en blanco. 
            print(lista_texto[a],end="")