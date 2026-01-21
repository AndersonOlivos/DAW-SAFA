texto=input("Escribe una cadena de texto:\n\n")

texto=texto.split(" ")

texto_sorted=sorted(texto)

print(" ".join(texto_sorted))