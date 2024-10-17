texto=input("Escribe una cadena de texto:\n\n")

split_texto=texto.split(" ")

count=0

for a in split_texto:
    if len(a)>=5:
        count=count+1

print("\nEl texto contiene ",count," palabras con al menos 5 caracteres")