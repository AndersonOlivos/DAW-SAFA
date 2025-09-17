# JUEGO ADIVINAR Nº SECRETO

import random #Importamos la librería random

def numero_aleatorio(): #Función para crear un número aleatorio
    return(random.randint(1,10))

def juego():
    
    numero_secreto=numero_aleatorio() #Creamos el nº secreto que tiene que adivinar
    
    nombre_jugador=input("Escribe tu nombre: ") #Solicitamos al juador su nombre
    
    #Damos la bienvenida al jugador y le explicamos el juego.
    
    print("\n---------------------")
    print("\nBIENVENIDO",nombre_jugador.upper())
    print("\nEn este juego tendrás que adivinar el número que piense entre 1 y el 10. Tienes 3 intentos, así que aprovéchalos bien.")
    print("\nEstoy pensando en un numero...")
    print("\n¡Listo! Ya lo tengo.\n")
    
    win=False #Creamos una variable para saber si ha ganado (True) o si ha perdido (False).
    
    intentos=3 #Creamos la variable de los intentos.
    
    while(win==False and intentos>0): #El juego no para hasta que el jugador gana o sus intentos llegan a 0
        
        numero_jugador=input("¿Qué número crees que es? ") #Le pedimos un número al jugador
        
        numero_jugador=int(numero_jugador) #Convertimos el numero del jugador en un número entero
    
        if numero_secreto==numero_jugador:
            win=True #Si el número que ha puesto es igual al secreto entonces ha ganado y sale del bucle
        else:
            if numero_secreto>numero_jugador: #Si el número secreto es más grande que el del jugador se lo indicamos y le restamos un intento
                print("\nEl número que he pensado es MÁS GRANDE.")
                intentos-=1
            else: #Si el número secreto es más pequeño que el del jugador se lo indicamos y le restamos un intento
                print("\nEl número que he pensado es MÁS PEQUEÑO.")
                intentos-=1
        
        print("\nIntentos restantes: ",intentos,"\n") #Imprimimos por pantalla los intentos que le van quedando


    if win==True: print("¡CORRECTO! Wao, me has leído la mente...\n") #Si ha ganado
    else: print("DERROTA. Parece que esta vez no hubo suerte...\nEl número secreto era",numero_secreto,"\n") #Si ha perdido



juego() #Ejecutamos el juego