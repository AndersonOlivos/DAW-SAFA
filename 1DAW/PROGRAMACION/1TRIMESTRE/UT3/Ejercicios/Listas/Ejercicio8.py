def calcular_aprobados_suspensos(notas):
    aprobados=0
    suspensos=0
    for a in notas:
        if a>=5: aprobados+=1
        else: suspensos+=1
    return aprobados,suspensos

notas=[3,1,3,6,7,0,2,5,9,9,10]

res=calcular_aprobados_suspensos(notas)

print("Aprobados: ",res[0])
print("Suspensos: ",res[1])
