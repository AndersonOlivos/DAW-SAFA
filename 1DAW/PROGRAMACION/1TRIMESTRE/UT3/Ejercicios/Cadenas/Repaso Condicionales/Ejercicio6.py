def describir_palabra(palabra):

    vocales="aeiou"

    if palabra=="": print('La palabra es ""')
    else: print('La palabra es distinta de ""')

    if len(palabra)<5: print('La palabra no tiene más de 5 letras')
    else: print('La palabra tiene más de 5 letras')

    vocal=0
    consonante=0

    for letra in palabra:
        if letra.lower() in vocales:vocal+=1
        else: consonante+=1

    if vocal>0: print("La palabra tiene vocales")
    else: print("La palabra no tiene vocales")

    if consonante>0: print("La palabra tiene consonantes")
    else: print("La palabra no tiene consonantes")

    vocales_acentuadas="áéíóú"

    vocal_acent=0

    for letra in palabra:
        if letra.lower() in vocales_acentuadas:vocal_acent+=1

    if vocal_acent>0: print("La palabra tiene vocales acentuadas")
    else: print("La palabra no tiene vocales acentuadas")

    print("La palabra tiene",len(palabra),"letras")


palabra=input("Escribe una palabra: ")
describir_palabra(palabra)