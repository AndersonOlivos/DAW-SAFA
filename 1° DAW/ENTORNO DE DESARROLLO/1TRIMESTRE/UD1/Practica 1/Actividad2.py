a=(1,2,3)
b=(-1,0,2)
product=0
for i in range(len(a)+1):
    product=a[i-1]*b[i-1]
print("El producto de los vectores",str(a)+" y",str(b),"es",str(product))