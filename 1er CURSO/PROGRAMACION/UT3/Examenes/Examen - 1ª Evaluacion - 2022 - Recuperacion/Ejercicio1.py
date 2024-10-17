vocales="AEIOUÁÉÍÓÚ"
num=0
texto=input("Introduce un texto: ")

for a in texto:
    if(a not in vocales and a.isupper()):
        num+=1
        
print(num)