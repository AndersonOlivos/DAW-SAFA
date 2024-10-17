precios=[50, 75,46, 22, 80, 65, 8]

mayor=precios[0]

menor=precios[0]

for a in precios:
    if a>mayor: mayor=a
    if a<menor: menor=a

print("Número mayor:",mayor)
print("Número menor:",menor)