import random


def generar_barcos():
    # Generea un tablero con la ubicacion aleatoria de barcos y haz que ocupen la posicion
    # Diccionario de barcos con sus respectivos puntos
    barcos = {
        "Transatlántico": 3,
        "Acorazado": 4,
        "Submarino": 5
    }
    # Inicializar tablero vacío
    tablero = [None] * 10
    # Colocar cada barco en una posición aleatoria
    # Es un bucle donde se repite el buscar una posicion del 0 al 10 y verifica si la posicion esta vacia
    for barco, puntos in barcos.items():
        while True:
            inicio = random.randint(0, 10)
            if tablero[inicio] is None:
                tablero[inicio] = (barco, puntos)
                break
    return tablero
# este bucle se repite hasta que cada jugador tenga los barcos posicionados

def hundir_barcos():
    # Obtener nombres de los jugadores
    jugador1 = input("Nombre del Jugador 1: ")
    jugador2 = input("Nombre del Jugador 2: ")

    # Iniciar puntuaciones de los jugadores
    puntuaciones = {jugador1: 0, jugador2: 0}

    # Generar tablero con barcos con la funcion de antes
    tablero = generar_barcos()


    # Bucle principal , las 3 rondas del juego y lo que sale cada ronda
    for ronda in range(1, 4):
        print("\n--- Ronda ", {ronda}, "---")
        # Turno de cada jugador con
        for jugador in (jugador1, jugador2):
            print("Turno de", jugador)

            # Solicitar y validar la entrada del jugador
            while True:  #El while true es un buclea hasta que se cumpla el objetivo
                try: #Conla funcion hacemos que meta un numero del 1 al 10
                    intento = int(input("Ingresa una posición (1-10): ")) - 1
                    if 0 <= intento < 10:
                        break
                    else:
                        print("Por favor, ingresa un número entre 1 y 10.")
                except ValueError:
                    print("Por favor, ingresa un número válido.")
            #Si no ingresa un numero que esta dentro del rango o ingresa algo que no es un numero se repetira
            # Verificar si el jugador acertó un barco
            if tablero[intento] is not None:
                barco, puntos = tablero[intento]
                puntuaciones[jugador] += puntos
                print(f"¡Acertaste! Has hundido un {barco} y ganado {puntos} puntos.")
                tablero[intento] = None
                #Con el Tablero[intento]=none hacemos que el sitio donde estaba el barco se quede vacio
            else:
                print("Agua. No has acertado ningún barco.")

            # Mostrar puntuación actual del jugador
            print(f"Puntuación actual de {jugador}: {puntuaciones[jugador]}")

    # Determinar el ganador
    if puntuaciones[jugador1] > puntuaciones[jugador2]:
        ganador = jugador1
    elif puntuaciones[jugador2] > puntuaciones[jugador1]:
        ganador = jugador2
    else:
        ganador = "Empate"
    #Con el if hacemos quien es el ganador y el perdedor y hacemos un empate en caso de igualdad entre ambos

    # Mostrar resultados finales
    print("\n--- Fin del Juego ---")
    print(f"Puntuación final de {jugador1}: {puntuaciones[jugador1]}")
    print(f"Puntuación final de {jugador2}: {puntuaciones[jugador2]}")
    if ganador == "Empate":
        print("¡El juego ha terminado en empate!")
    else:
        print(f"¡El ganador es {ganador}!")


# Ejecutar el juego
hundir_barcos()