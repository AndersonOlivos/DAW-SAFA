

def calcular_coste():

    duracion = input('Duracion en minutos del viaje Acciona: ')

    if duracion.isnumeric() is False:
        print('Error: minutos no validos')
        calcular_coste()
    else: duracion = int(duracion)

    print('Seleccione el modo de viaje')
    print('1. Standard')
    print('2. Custom')
    print('3. X-tra')
    modo = input()

    if modo not in ['1','2','3']:
        print('Error: modo no valido')
        calcular_coste()
    else: modo = int(modo)

    modos = [0.31,0.36,0.39]

    coste_total = duracion * modos[modo-1]

    print(f'Coste total del viaje: {coste_total}€')

calcular_coste()