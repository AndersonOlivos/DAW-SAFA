
# Función para imprimir el tablero
def imprimir_tablero(tablero):
    for fila in tablero:
        print("|".join(fila))
        print("-" * 5)

# Función para comprobar si hay un ganador
def hay_ganador(tablero, jugador):
    # Comprobar filas, columnas y diagonales
    for i in range(3):
        if all([casilla == jugador for casilla in tablero[i]]):  # Filas
            return True
        if all([tablero[j][i] == jugador for j in range(3)]):  # Columnas
            return True
    if tablero[0][0] == tablero[1][1] == tablero[2][2] == jugador:  # Diagonal principal
        return True
    if tablero[0][2] == tablero[1][1] == tablero[2][0] == jugador:  # Diagonal secundaria
        return True
    return False

# Función para comprobar si hay empate
def tablero_lleno(tablero):
    return all(casilla in ['X', 'O'] for fila in tablero for casilla in fila)

# Función principal del juego
def tres_en_linea():
    # Pedir los nombres de los jugadores
    jugador1 = input("Nombre del Jugador 1 (X): ")
    jugador2 = input("Nombre del Jugador 2 (O): ")

    # Inicializar el tablero (numerado del 1 al 9 para facilitar los movimientos)
    tablero = [['1', '2', '3'], ['4', '5', '6'], ['7', '8', '9']]

    # Variables para controlar el turno
    turno = 'X'
    nombre_turno = jugador1

    # Bucle principal del juego
    while True:
        # Mostrar el tablero actual
        imprimir_tablero(tablero)

        # Pedir al jugador que ingrese su movimiento
        movimiento = input(f"{nombre_turno}, elige una casilla (1-9): ")

        # Validar si la entrada es correcta
        if not movimiento.isdigit() or int(movimiento) < 1 or int(movimiento) > 9:
            print("Movimiento inválido. Elige un número del 1 al 9.")
            continue

        # Convertir el movimiento a coordenadas del tablero
        movimiento = int(movimiento) - 1
        fila = movimiento // 3
        col = movimiento % 3

        # Verificar si la casilla está ocupada
        if tablero[fila][col] in ['X', 'O']:
            print("Esa casilla ya está ocupada. Elige otra.")
            continue

        # Realizar el movimiento
        tablero[fila][col] = turno

        # Comprobar si el jugador ha ganado
        if hay_ganador(tablero, turno):
            imprimir_tablero(tablero)
            print(f"¡Felicidades {nombre_turno}, has ganado!")
            break

        # Comprobar si hay empate
        if tablero_lleno(tablero):
            imprimir_tablero(tablero)
            print("¡Es un empate!")
            break

        # Cambiar de turno
        if turno == 'X':
            turno = 'O'
            nombre_turno = jugador2
        else:
            turno = 'X'
            nombre_turno = jugador1

# Ejecutar el juego
tres_en_linea()