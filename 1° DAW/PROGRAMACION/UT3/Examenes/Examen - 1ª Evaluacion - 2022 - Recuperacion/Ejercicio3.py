futbolistas=["Haaland","Mbappe","Vinicius Jr"]

num_personas=2

valoraciones=[]

for a in range(len(futbolistas)):
    print("------------------------- VALORACIÓN ",futbolistas[a].upper(),"-------------------------")
    valoraciones.append([])
    for b in range(num_personas):
        print("Persona ",b+1," --> ",end=" ")
        valor=input("")
        valor=int(valor)
        valoraciones[a].append(valor)
        

print("-----------------------RESUMEN VALORACIONES ----------------------")
for a in range(len(futbolistas)):
    print(futbolistas[a],"(Media Obtenida) --> ",sum(valoraciones[a])/num_personas)
print("---------------------------------------------------------------------------")