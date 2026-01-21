data=[
    {
    "nombre " : "Treecko",
    "pokédex" : 252,
    "tipo" : ["PLANTA"],
    "evo" : 1
    },
    {
    "nombre " : "Roselia",
    "pokédex" : 407,
    "tipo" : ["PLANTA", "VENENO"],
    "evo" : 2
    },
    {
    "nombre " : "Milotic",
    "pokédex" : 350,
    "tipo" : ["AGUA","PLANTA"],
    "evo" : 2
    },
    {
    "nombre " : "Altaria",
    "pokédex" : 334,
    "tipo" : ["VOLADOR", "DRAGÓN"],
    "evo" : 2
    }
]

"""" #Descomentar para ejecutar el apartado A

def apartadoA(data):
    return sorted(data,key=lambda data: data["pokédex"],reverse=True)

a=apartadoA(data)
print(a)

"""

""" #Descomentar para ejecutar el apartado B

def apartadoB(data,tipo):
    res=[]
    for a in range(len(data)):
        if tipo in data[a]["tipo"]:
            res.append(data[a])
            
    return res

b=apartadoB(data,input("Escribe el tipo de pokemon: ").upper())
print(b)

"""

""" #Descomentar para ejecutar el apartado B

def apartadoC(nombre,pokedex,tipo,evo):
    data=[]
    for i in range(len(pokedex)):
        data.append({"nombre":nombre[i],"pokédex":pokedex[i],"tipo":tipo[i],"evo":evo[i]})
    return data

nombres = ["Treecko", "Roselia", "Milotic", "Altaria"]
numeros = [252, 407, 350, 334]
tipos= [ ["PLANTA"] , ["PLANTA", "VENENO"] , ["AGUA"] , ["VOLADOR","DRAGÓN"] ]
evo= [1, 2, 2, 2]

data2=apartadoC(nombres,numeros,tipos,evo)

print(data2)


"""