data=[{
    "modelo" : "Gallardo",
    "marca" : "Lamborghini",
    "tipo" : "Deportivo",
    "puertas" : 3
},
{
    "modelo" : "Murciélago GT",
    "marca" : "Lamborghini",
    "tipo" : "Carrera",
    "puertas" : 2
},
{
    "modelo" : "Twingo",
    "marca" : "Renault",
    "tipo" : "Normal",
    "puertas" : 5
}]

"""

def apartadoA():
    lista=[]
    data_ordenada=sorted(data,key=lambda data: data["puertas"],reverse=False)
    for a in data_ordenada:
        if a["puertas"]>2:
            lista.append(a["modelo"])
    return lista

apartadoa=apartadoA()
print(apartadoa)

"""

"""

def apartadoB(marca):
    marca=marca.lower()
    for a in data:
        if a["marca"].lower()==marca:
            print(a)

apartadoB(input("Escribe la marca para buscar los coches: "))

"""

"""

modelos= ["Gallardo" , "Murciélago GT", "Twingo" ]
marcas = ["Lamborghini","Lamborghini","Renault"]
tipos= ["Deportivo", "Carrera", "Normal" ]
evo= [3,2,5]

def apartadoC(modelo,marca,tipo,puertas):
    data2=[]
    for a in range(len(modelo)):
        data2.append({"modelo":modelo[a],"marca":marca[a],"tipo":tipo[a],"puertas":puertas[a]})
    return data2


print(apartadoC(modelos,marcas,tipos,evo))

"""