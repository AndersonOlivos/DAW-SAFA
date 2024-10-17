texto=input("Escribe una cadena de texto:\n\n")

texto=texto.split(" ")

for a in texto:
    if len(a)>=4:
        for b in range(len(a)):
            print("*",end="")
        print(" ", end="")
    else:
        print(a,end=" ")