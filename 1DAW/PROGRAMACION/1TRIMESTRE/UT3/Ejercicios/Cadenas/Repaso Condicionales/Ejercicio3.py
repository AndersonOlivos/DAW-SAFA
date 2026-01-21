def grande(a,b,c,d):
    return(max(a,b,c,d))

def pequena(a,b,c,d):
    return(min(a,b,c,d))

a=input("Escribe la 1ª palabra: ")
b=input("Escribe la 2ª palabra: ")
c=input("Escribe la 3ª palabra: ")
d=input("Escribe la 4ª palabra: ")

print("La palabra más pequeña es: ",pequena(a,b,c,d))
print("La palabra más grande es: ",grande(a,b,c,d))