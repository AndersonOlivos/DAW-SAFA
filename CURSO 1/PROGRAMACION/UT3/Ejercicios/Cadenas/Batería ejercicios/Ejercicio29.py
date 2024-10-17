def desplazar_derecha(cadena):
    resultado = ''  # Cadena resultante

    for caracter in cadena:
        if caracter.isalpha():  # Verifica si es una letra
            # Determina si es mayúscula o minúscula
            if caracter.islower():
                base = ord('a')  # Código ASCII de 'a'
            else:
                base = ord('A')  # Código ASCII de 'A'

            # Calcula la posición relativa en el alfabeto (0-25)
            pos_relativa = ord(caracter) - base

            # Desplaza una posición hacia la derecha con ciclo
            nueva_pos = (pos_relativa + 1) % 26

            # Obtiene el nuevo carácter desplazado
            nuevo_caracter = chr(base + nueva_pos)

            resultado += nuevo_caracter  # Agrega al resultado
        else:
            resultado += caracter  # Agrega el carácter sin cambios

    return resultado

texto = input("Escribe una cadena de texto: ")
print("\nResultado: ",desplazar_derecha(texto))
