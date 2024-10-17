palabra=input("Escribe una palabra para comprobar si es palíndroma: ")
palabra_inversa=((palabra)[::-1])

if(palabra.lower()==palabra_inversa.lower()):
    print("Es una palabra palíndroma")
else:
    print("No es una palabra palíndroma")
