alumnos=[{
    "nombre" : "Enrique",
    "apellidos" : "García, Migueza",
    "dni" : "12345678K",
    "email" : "egarciamigueza@safareyes.es"
    },
    {
    "nombre" : "Paloma",
    "apellidos" : "Machado, López",
    "dni" : "12345678Z",
    "email" : "pmachadolopez@hotmail.es"
    },
    {
    "nombre" : "Antonio",
    "apellidos" : "Romero, Domínguez",
    "dni" : "12345678A",
    "email" : "aromerodominguez@safareyes.es"
    },
    {
    "nombre" : "Anderson",
    "apellidos" : "A, A",
    "dni" : "79191191Z",
    "email" : "aolivosgamarra@safareyes.es"
    }]


#Apartado a

def apartadoA():
    alumnos_dominio=[]
    for a in alumnos:
        if a["email"].endswith("@safareyes.es"):
            alumnos_dominio.append(a)
    print("Estos son los alumnos que tienen el email del centro SAFA:\n",alumnos_dominio)


def apartadoB():
    print(sorted(alumnos,key=lambda alumnos: alumnos["apellidos"])[0])


def apartadoC():
    print(sorted(alumnos,key=lambda alumnos: alumnos["dni"][-1])[0])

#apartadoA() #Quitar el # para ejecutar el apartado A

#apartadoB() #Quitar el # para ejecutar el apartado B

#apartadoC() #Quitar el # para ejecutar el apartado C
