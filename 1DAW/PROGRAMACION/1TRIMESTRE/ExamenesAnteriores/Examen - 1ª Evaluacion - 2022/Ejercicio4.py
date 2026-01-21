num=input("Escribe un número para saber por qué números del 1 al 10 es divisible: ")
if num.isnumeric()==True: #Detectamos si el nº proporcionado es válido. Si no, le damos error.
    num=int(num)
    divisible=[]
    for i in range(1,11): #Desde el 1 al 10 incluido
        if num%i==0: #Si el módulo entre el nº dado y el rango entre 1 y 10 es igual a 0 entonces lo añadimos a la lista de divisibles.
            divisible.append(i)
    print("Es divisible por ",divisible)

else: print("Error: número no válido.")
