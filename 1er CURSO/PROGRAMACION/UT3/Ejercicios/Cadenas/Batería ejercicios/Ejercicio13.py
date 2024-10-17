cadena=input("Introduce una cadena de texto: ")

cadena_split = cadena.split(sep=" ")

print(" ".join(sorted(cadena_split)))