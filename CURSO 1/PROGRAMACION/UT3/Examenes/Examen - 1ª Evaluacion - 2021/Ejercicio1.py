texto=input("Introduce el texto:\n")

signos={
    "comas":[",",0],
    "puntos y comas":[";",0],
    "puntos":[".",0],
    "dos puntos":[":",0],
    "comillas":['"',0],
    "puntos suspensivos":["...",0],
    "paréntesis":["(",0],
    "diéresis":["ü",0],
    "corchetes":["[",0],
    "interrogaciones":["¿",0],
    "guiones":["-",0],
    "admiraciones":["!",0],
}

for b,c in signos.items():
    c[1]=texto.count(c[0])

print("\nSignos de puntuación encontrados:\n")

for a,b in signos.items():
    if b[1]!=0:
        print("Número de",a,": ",b[1])
