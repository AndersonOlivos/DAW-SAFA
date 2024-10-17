lista=["Manuel","Fernando","Bernardo","Anderson"]

buscar=input("Buscar palabra en la lista: ")

res=False

for a in lista:
    if buscar.lower() in a.lower():
        res=True

if res: print("Se encontró la palabra en la lista.")
else: print("No se encontró la palabra en la lista.")