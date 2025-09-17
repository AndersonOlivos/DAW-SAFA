texto=input("Escribe una cadena de texto:\n\n")

split_texto=texto.split(" ")

print("\nTu cadena a la inversa:\n")

for a in split_texto:
    print(a[::-1], end=" ")
