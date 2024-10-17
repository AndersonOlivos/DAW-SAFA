texto=input("Escribe una cadena de texto:\n\n")

count=0

for a in texto:
    if a.isdigit()==True:
        count=count+1

print("\nEl texto contiene ",count," dígitos")