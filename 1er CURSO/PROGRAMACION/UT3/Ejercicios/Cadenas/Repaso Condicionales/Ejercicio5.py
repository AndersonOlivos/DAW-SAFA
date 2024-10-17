palabras=input("Escribe todas las palabras que desees separadas por espacios: ")

palabras=palabras.lower()

palabras=palabras.split(" ")

vocales="aeiouáéíóú"

res=[]

for a in palabras:
    aux=0
    for b in a:
        if b in vocales:
            aux+=1
    if aux>3: res.append(a)

print(res)