numeros=input("Escribe todos los números que desees separados por comas: ")

numeros=numeros.split(",")

res=[]
numeros[-1]=int(numeros[-1])

for a in range(len(numeros)-1):
    numeros[a]=int(numeros[a])
    if numeros[a]%numeros[-1]==0:
        res.append(numeros[a])

print(res)