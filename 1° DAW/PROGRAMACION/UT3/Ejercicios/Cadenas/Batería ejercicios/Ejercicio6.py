vocales="aeiou"

frase=input("Escribe una cadena texto para quitarle los espacios en blanco: ")

for i in vocales:
    frase=frase.replace(i,"")

print(frase)