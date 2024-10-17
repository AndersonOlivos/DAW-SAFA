matriz=[[0,1,2],[2,4,5],[9,2,3]]

suma=0

for a in matriz:
    print(a)
    suma+=sum(a)

print("Suma de toda la matriz: ",suma)