def palabra_requisito(palabra,minimo):
    minimo=int(minimo)
    if palabra=="" or len(palabra)<minimo:
        print("No cumple los requisitos.")
    else: print("La palabra '",palabra,"' cumple los requisitos.")

palabra=input("Escribe una palabra: ")
minimo=input("Escribe el mínimo de letras de la palabra: ")

palabra_requisito(palabra,minimo)