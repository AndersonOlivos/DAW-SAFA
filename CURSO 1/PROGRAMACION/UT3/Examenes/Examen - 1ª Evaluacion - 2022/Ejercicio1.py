texto="Ey, Tití me preguntó\nSi tengo muchas novia'\nMuchas novia'\nHoy tengo a una, mañana otra\nEy, pero no hay boda\nTití me preguntó\nSi tengo muchas novia'\nJe, muchas novia'\nHoy tengo a una, mañana otra"

lista=["TITÍ", "Novia'", "Casa", "pregunto"]

def tildes(a):
    letras={
        "á":"a",
        "é":"e",
        "í":"i",
        "ó":"o",
        "ú":"u",
    }
    
    for x in letras:
        if x in a:
            a=a.replace(x,letras[x])

    return a

lista_final=[tildes(a.lower()) for a in lista]

texto_final=tildes(texto.lower())

contador=[]

for a in lista_final:
    contador.append(texto_final.count(a))

print("  --RECUENTO DE PALABRAS--  ")
for a in range(len(lista)):
    print(lista[a]," : ",contador[a])