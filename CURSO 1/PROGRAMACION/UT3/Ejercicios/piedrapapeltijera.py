import random
from os import system

system("cls")
 
print("==============================================================\n")
print("  JUEGO PIEDRA, PAPEL O TIJERA")
print("\n  Ganador al mejor de tres rondas (sin contar los empates)\n")
print("==============================================================\n")

def pedir_opcion():
    print("\nYa he elegido una opcion, es tu turno.")
    print("\nElige una de las siguientes opciones:\n")
    print("0 --> PIEDRA")
    print("1 --> PAPEL")
    print("2 --> TIJERA")
    return input("\nEscribe el numero: ")    


def marcador(win_jugador,win_maquina):
    print("\n-------------------------------")
    print("| Jugador:",win_jugador,"\t| Maquina:",win_maquina," |")
    print("-------------------------------\n")


def main():
    
    contador = 1
    win_jugador = 0
    win_maquina = 0
        
    opciones=["PIEDRA","PAPEL","TIJERA"]
    
    while(win_jugador!=2 and win_maquina!=2):
        
        print("RONDA",contador)
        
        opcion_maquina = random.randint(0,2)
        opcion_jugador = pedir_opcion()
        
        if opcion_jugador not in ["0","1","2"]:
            print("\nOpcion no valida. Prueba de nuevo")
            opcion_jugador = pedir_opcion()

        opcion_jugador = int(opcion_jugador)

        print("\nOpcion maquina: ",opciones[opcion_maquina])
        print("Opcion jugador: ",opciones[opcion_jugador])

        if opcion_maquina == opcion_jugador: print("\nEMPATE")
        else:
            if (opcion_jugador > opcion_maquina or (opcion_jugador == 0 and opcion_maquina == 2)) and (opcion_jugador != 2 and opcion_maquina != 0):
                win_jugador+=1
            else: 
                win_maquina+=1
        
        marcador(win_jugador,win_maquina)
        contador+=1
        
    if win_maquina > win_jugador: print("El ganador de las 3 rondas es la MAQUINA")
    else: print("El ganador de las 3 rondas es el JUGADOR")
main()