from matplotlib.widgets import EllipseSelector


def ejercicio1(texto):

    print('Signos de puntuacion encontrados:')


    #comas

    comas = texto.count(',')

    if comas != 0:
        print(f'Numero de comas: {comas}')

    puntoycoma = texto.count(';')

    if puntoycoma != 0:
        print(f'Numero de punto y coma: {puntoycoma}')

    dospuntos = texto.count(':')

    if dospuntos != 0:
        print(f'Numero de dos puntos: {dospuntos}')

    parentesis = texto.count(')')

    if parentesis != 0:
        print(f'Numero de parentesis: {parentesis}')

    corchetes = texto.count(']')

    if corchetes != 0:
        print(f'Numero de corchetes: {corchetes}')

    interrogacion = texto.count('?')

    if interrogacion != 0:
        print(f'Numero de interrogaciones: {interrogacion}')

    puntossuspensivos = texto.count('...')

    if puntossuspensivos != 0:
        print(f'Numero de puntos suspensivos: {puntossuspensivos}')

    punto = texto.count('.') - (puntossuspensivos * 3)

    if punto != 0:
        print(f'Numero de punto: {punto}')

    comillas = texto.count('"')

    if comillas != 0:
        print(f'Numero de comillas: {comillas}')


    dieresis = texto.count('ü')

    if dieresis != 0:
        print(f'Numero de dieresis: {dieresis}')

    guion = texto.count('-')

    if guion != 0:
        print(f'Numero de guiones: {guion}')

    admiracion = texto.count('!')

    if admiracion != 0:
        print(f'Numero de admiraciones: {admiracion}')


#ejercicio1('...En las ciudades de Piltover y Zaun, se palpa el desasosiego en el ambiente: inventores, ladrones,políticos y señores del crimen buscan liberarse de las ataduras de una sociedad fragmentada. Mientras la rebelión va cobrando fuerza, dos hermanas roban un artefacto de poder inimaginable.Los descubrimientos y el peligro son el trasfondo sobre el que nacerán héroes y se romperán vínculos.¿Servirá este poder para cambiar el mundo o lo llevará a la ruina? Este es el mundo de Arcane.')


def ejercicio2(palabra):
    vidas = 5
    palabra_oculta = ['_' for a in palabra]
    citadas = []
    win = False

    def pedir_letra(citadas):
        letra = input('Dime una letra: ')
        while letra in citadas:
            print('Esta letra ya esta citada')
            letra = input('Dime otra letra: ')
        return letra

    def comprobar_win(palabra, palabra_oculta):
        return list(palabra) == palabra_oculta

    while vidas != 0:
        print('----------------------------')
        print(f'Vidas: {vidas}')
        print(f'Letras citadas: {citadas}')
        print(f'Palabra: {palabra_oculta}')
        print('----------------------------')
        letra = pedir_letra(citadas)
        if letra in palabra:
            print('Has acertado')
            for i in range(len(palabra)):
                if palabra[i] == letra:
                    palabra_oculta[i] = letra
            citadas.append(letra)
        else:
            citadas.append(letra)
            vidas -= 1
        win = comprobar_win(palabra, palabra_oculta)
        if win is True: break

    if win is True:
        print('HAS GANADO!!')
    else:
        print('HAS PERDIDO')

ejercicio2('pene')

dic = [{
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
"email" : "aromerodominguez@safareyes.es",
}]


def ejercicio3_a(dict):
    new_list = []

    for alumno in dict:
        if alumno['email'].endswith('@safareyes.es'):
            new_list.append(alumno)

    return new_list

#print(ejercicio3_a(dic))

def ejercicio3_b(dict):
    return sorted(dict, key=lambda alumno: alumno['apellidos'].split(',')[0])[0]

#print(ejercicio3_b(dic))

def ejercicio3_c(dict):
    return sorted(dict, key=lambda alumno: alumno['dni'].split()[-1])[0]

#print(ejercicio3_c(dic))

def ejercicio4(notas):

    media = sum(notas)/len(notas)

    if media < 5:
        return 'Suspenso'
    elif media < 7:
        return 'Aprobado'
    elif media < 9:
        return 'Notable'
    else:
        return 'Sobresaliente'

#print(ejercicio4([ 9.6 , 10 , 9.2 , 8 ]))

def ejercicio5(cadena):

    if not (cadena[0].isupper() and cadena[-1].isupper()):
        return False

    if not any(char.isdigit() for char in cadena):
        return False

    if not ('.' in cadena or '_' in cadena or '#' in cadena):
        return False

    return True

#print(ejercicio5('Mamahuevo1.L'))