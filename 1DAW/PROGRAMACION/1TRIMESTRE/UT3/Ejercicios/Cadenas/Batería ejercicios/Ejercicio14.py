vocales={'a':"1", 'e':"2", 'i':"3", 'o':"4", 'u':"5"}

frase=input("Escribe una frase para sustituir las vocales por números: ")

for i,j in vocales.items():
    frase=frase.replace(i,j)

print(frase)