texto=input("Escribe una cadena de texto: \n")

texto_split=texto.split(" ")

for a in texto_split:
    print(a[0],end="")
    for b in range(len(a)-2):
        print("*",end="")
    print(a[len(a)-1],end=" ")