lista_numeros=input("Escribe una lista de números separados por comas: ")

lista_numeros=lista_numeros.split(",")

lista_final=[]

for a in lista_numeros:
    if "." not in a:
        a=int(a)
        if(a%2==0 and a%3==0):
            lista_final.append(a)

print(lista_final)