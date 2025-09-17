from dataclasses import replace

frase=input("Escribe una frase: ")

for i in frase:
    if(i!=" "):
        if(i.isalpha()==False):
            frase=frase.replace(i,"")

print(frase)






