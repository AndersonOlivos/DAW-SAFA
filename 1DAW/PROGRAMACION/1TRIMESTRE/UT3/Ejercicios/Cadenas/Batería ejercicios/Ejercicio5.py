from dataclasses import replace

frase=input("Escribe una cadena texto para quitarle los espacios en blanco: ")
frase=frase.replace(" ","")
print(frase)