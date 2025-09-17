import random

#Funcion para validar que la palabra sea correcta
def palabra_valida(palabra_anterior, nueva_palabra, palabra_manual_lista):
    # Verificaca la nueva palabra comience con las dos últimas letras de la palabra anterior
    if nueva_palabra[:2].lower() != palabra_anterior[-2:].lower():
         return False
    # Verifica la palabra que no haya sido utilizada antes
    if nueva_palabra.lower() in palabra_manual_lista:
        return False
    return True


# Función para mostrar el perdedor y terminar el juego
def final_juego(jugador_perdedor):
    print(f"¡{jugador_perdedor} ha perdido el juego!")
    print("El juego ha terminado.")
    return


# Funcion del juego
def juego_palabras_encadenadas ():
    numero_jugadores = int(input("¿Cuantos jugadores deseais ser?: "))
    jugadores = []

    # Introduccion de los jugadores al juego (El numero maximo de jugadores lo decidira un usuario)
    for i in range(numero_jugadores):
        nombre = input(f"Ingresa el nombre del jugador {i + 1}: ")
        jugadores.append(nombre)

    # Lista de palabras para usar si los jugadores no quieren empezar
    palabras_predefinidas = ["gato", "perro", "coche", "mesa", "ordenador"]

    # Palabra en el caso de que uno de los jugadores si quiesiera comenzar poniendo su palabra
    palabra_seleccionada = input("¿Quieres comenzar el juego escribiendo la palabra o usando una aleatoria? (m/a): ").lower()

    # Se crea la condicion para que el jugador escriba su propia palabra o la maquina la seleccione de entre las que ya tiene
    if palabra_seleccionada == "m":
        palabra_actual = input("¿Con que palabra vas a comenzar?: ").lower()
    else:
        palabra_actual = random.choice(palabras_predefinidas).lower()
    # Se crea este print cuando el jugador haya seleccionado la opcion aleatoria
        print(palabra_actual)

    # Si el jugador escoge la opcion manual, se comenzaran a guardar sus palabras en la lista
    palabra_manual_lista = [palabra_actual]

    # Comienzo de los turnos
    turnos = 0

    while True:#Con el while se hace que los jugadores no paren de jugar a pesar de ya haber escrito una palabra
        jugador_actual = jugadores [turnos % numero_jugadores]
        print(f"Turno del jugador: {jugador_actual}")

    # Muestra la palabra actual y indica con que dos letras acaba
        nueva_palabra = input(f"La palabra tiene que comenzar por '{palabra_actual [-2:]}': ").lower()

        # Verificar si la palabra es válida
        if palabra_valida(palabra_actual, nueva_palabra, palabra_manual_lista):
            # Si es válida, añadirla a la lista de palabras usadas y continuar
            palabra_manual_lista.append(nueva_palabra)
            palabra_actual = nueva_palabra
            turnos += 1  # Pasa al siguiente jugador
        else:
            # Si no es válida, el jugador pierde
            final_juego(jugador_actual)
            break

        # Opción para terminar el juego manualmente
        opcion = input("¿Desean seguir jugando? (s/n): ").lower()
        if opcion != 's':
            print("El juego ha sido finalizado por decisión de los jugadores.")
            break

    # Opción para reiniciar el juego
    reiniciar = input("\n¿Quieren jugar otra ronda? (s/n): ").lower()
    if reiniciar == 's':
        juego_palabras_encadenadas()
    else:
        print("Gracias por jugar. ¡Hasta la próxima!")


# Inicio del juego
if __name__ == "__main__":
    juego_palabras_encadenadas()






















