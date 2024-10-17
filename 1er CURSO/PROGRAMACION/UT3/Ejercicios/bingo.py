from os import system
import random
import time

def numero_random(): #Función para generar un número random entre el 1 y el 99
    return random.randint(1,99)

def generar_carton(): #Función para generar un cartón
    lista=[]
    while(len(lista)<9):
        num_ran=numero_random()
        if num_ran not in lista:
            lista.append(num_ran)
    lista=sorted(lista)
    res=[lista[:3],lista[3:6],lista[6:]]
    return(res)

def imprimir_cartones(cartones): #Función para imprimir por pantalla los cartones
    print("------------------------")
    print("")
    for carton in cartones:
        print("Cartón",carton["carton"])
        print("------------------------")
        for linea in carton["lineas"]:
            for num in linea:
                print(num,end="\t")
            print("")
        print("------------------------")
        print("")
            
def comprobar_bingo(cartones): #Función para comprobar si algún jugador ha hecho bingo
    bingo=False
    for carton in cartones:
        if carton["bingo"]==True:
            bingo=True
    return bingo

def sacar_bolita(numeros_cantados,cartones):
    bolita=numero_random()
    if bolita in numeros_cantados:
        while bolita in numeros_cantados:
            bolita=numero_random()
    print("\nHa salido el número",bolita)
    print("")
    numeros_cantados.append(bolita)
    actualizar_cartones(cartones,bolita)
    return numeros_cantados
        
def actualizar_cartones(cartones,bolita): #Función para actualizar los cartones
    for carton in cartones:
        for lineas in range(len(carton["lineas"])):
            if bolita in carton["lineas"][lineas]:
                carton["linea_cantada"][lineas][0]+=1 #Si la bolita se encuentra en la línea, suma 1 a esa línea cantada.
    
    for carton in cartones:
        suma=0
        for lineas_cantadas in carton["linea_cantada"]:
            suma+=lineas_cantadas[0]
            if suma==9: carton["bingo"]=True #Si las líneas cantadas suman 9 entonces es bingo
            if lineas_cantadas[0]==3 and lineas_cantadas[1]==False and carton["bingo"]==False: #Si no se ha cantado línea anteriormente, se imprime y se cambia el estado a cantado (True)
                print("\n¡El jugador con el cartón",carton["carton"],"ha cantado línea!")
                print("")
                lineas_cantadas[1]=True
            
def main():
    numeros_cantados=[]
    cartones=[]
    bingo=False
    ganador=None
    
    num_jugadores=input("Escribe el número de jugadores: ") #Solicitamos el nº de jugadores
    for a in range(int(num_jugadores)):
        cartones.append({"carton":(a+1),"bingo":False,"linea_cantada":[[0,False],[0,False],[0,False]],"lineas":generar_carton()}) #Creamos el diccionario con los datos
    
    imprimir_cartones(cartones) #Imprimimos por pantalla los cartones generados
    
    print("¡EMPIEZA EL BINGO!")
    print("\n------------------------")
    
    while(bingo==False): #El juego sigue hasta que alguien canta bingo
                
        numeros_cantados=sacar_bolita(numeros_cantados,cartones) #Sacamos una bola
                
        bingo=comprobar_bingo(cartones) #Comprobamos en cada bucle si hay algún bingo. Si es True entonces se finazaliza el bucle y termina la partida con un ganador.        
        
    print("B IN G O O O O O O O O O O ! ! ! ! ") #Cantamos bingo
    
    for carton in cartones: #Buscamos el nº del cartón ganador
        if carton["bingo"]==True:
            ganador=carton["carton"]
    
    print("NÚMERO CARTÓN GANADOR: ",ganador)
    
system("cls") #Limpiamos la consola    

main() #Empezamos el juego