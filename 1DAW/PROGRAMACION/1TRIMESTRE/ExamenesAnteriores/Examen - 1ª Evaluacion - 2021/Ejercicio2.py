def imprimir_estado(vidas,letras_usadas,palabra_oculta): #Función para imprimir el estado del juego
    print("Vidas: ",vidas)
    print("Letras citadas: ",letras_usadas)
    print("Palabra: "," ".join(palabra_oculta))
    print("\n-------------------------------")

def obtener_palabra_oculta(a):
    return ["_"] * len(a)

def pedir_letra(letras_usadas): #Función para pedir una letra al jugador
    letra = input("\nDime una letra: ").lower()

    while (letra in letras_usadas or len(letra) != 1 or not letra.isalpha()):
        print("\nLa letra seleccionada no es válida.") # Si no cumple los requisitos devolvemos "Error" y volvemos a pedir la letra
        letra = input("\nDime otra letra: ").lower()

    return letra # Devolvemos el resultado ya verificado

    
def modificar_palabra_oculta(letra,palabra_oculta,split_palabra):
    for a in range(len(split_palabra)):
        if split_palabra[a]==letra:
            palabra_oculta[a]=letra
    return palabra_oculta

def comprobar_win(split_palabra, palabra_oculta): #Función para comprobar si el jugador ha ganado la partida
    return split_palabra == palabra_oculta

def main(palabra):
    win=False #Variable para saber si el jugador ha ganado o ha perdido
    split_palabra=list(palabra)
    palabra_oculta=obtener_palabra_oculta(palabra) #Obtenemos una lista con "_" que vamos a ir modificando
    vidas=5 #Empezamos con 5 vidas
    letras_usadas=[] #En esta lista iremos metiendo las letras que el jugador va utilizando
    
    while (vidas>0): #El juego no para hasta que las vidas lleguen a 0 o el jugador acierte la palabra
        
        win=comprobar_win(split_palabra,palabra_oculta) #En cada ronda comprobar si ha acertado la palabra. Si es así, se terminará el bucle. Si no, sigue jugando.
        if win: break
    
        imprimir_estado(vidas,letras_usadas,palabra_oculta) #Imprimimos el estado del juego

        letra=pedir_letra(letras_usadas) #Pedimos una letra al jugador

        print("\n-------------------------------")


        letras_usadas.append(letra) #Añadimos la letra en las letras usadas
        
        if letra not in split_palabra: #Si la letra no se encuentra en la palabra la restamos una vida
            vidas-=1
            
        else: #Si la palabra sí se encuentra en la palabra, entonces modificamos la palabra oculta
            
            palabra_oculta=modificar_palabra_oculta(letra,palabra_oculta,split_palabra)

    #Condicional para saber si el jugador ha ganado o ha perdido

    if win==1:
        print("\n¡VICTORIA!\nHas acertado la palabra.")
    else:
        print("\nDERROTA.\nParece que no hubo suerte esta vez.\nLa palabra era: ",palabra)


from os import system
system("cls") #Limpiamos la consola
palabra=input("Dime la palabra secreta: ") #Solicitamos la palabra

system("cls") #Volvemos a limpiar la consola
print("¡A JUGAR!\n")
main(palabra) #Empezamos el juego