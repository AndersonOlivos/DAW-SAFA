#LIBRERÍAS E IMPORTACIONES

import mysql.connector as conector
import csv
import pandas as pd
from RankingPadel import web_scraping


#FUNCION: CONVIERTE LISTA DE DICCIONARIOS A XLSX
def convertir_a_xlsx(nombre_fichero, jugadores):

    #Conversión a CSV

    csv_file = open(f'{nombre_fichero}.csv', 'w', encoding='utf-8', newline='')
    writer = csv.writer(csv_file)
    writer.writerow(list(jugadores[0].keys()))
    for jugador in jugadores:
        writer.writerow(jugador.values())
    csv_file.close()

    #Conversión a XLSX

    df = pd.read_csv(f'{nombre_fichero}.csv')

    df.to_excel(f'{nombre_fichero}.xlsx', index=False)

#jugadores_masculinos = web_scraping('https://www.padelfip.com/ranking-male/', 20)
#jugadores_femeninos = web_scraping('https://www.padelfip.com/ranking-female/', 20)

#convertir_a_xlsx('jugadores-padel-masculino',jugadores_masculinos)
#convertir_a_xlsx('jugadores-padel-femenino',jugadores_femeninos)


#FUNCION: CONEXIÓN A LA BASE DE DATOS
def conectar_bbdd():

    parametros_conexion = {
        'user': 'root',
        'password': 'usuario',
        'host': 'localhost',
        'database': 'padel',
        'port': 3306,
        'autocommit': True
    }

    return conector.connect(**parametros_conexion)


#FUNCION: Volcar todos los datos a la bbdd
def volcado_datos():

    jugadores_masculinos = web_scraping('https://www.padelfip.com/ranking-male/', 20)
    jugadores_femeninos = web_scraping('https://www.padelfip.com/ranking-female/', 20)


    #Abrimos conexion con la bbdd
    conexion = conectar_bbdd()

    #Abrimos cursor
    cursor = conexion.cursor()

    #Sentencia INSERT
    script_insercion = "insert into jugador (nombre,numero_ranking, sexo, pais, puntos, posicion, pareja, fecha_nacimiento, altura, pais_nacimiento, lugar_residencia, partidos_jugados, partidos_ganados, partidos_perdidos, victorias_consecutivas, efectividad, titulos, url_foto) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"


    #Cada pala se convierte en un script de inserción
    for jugador in jugadores_masculinos:
        cursor.execute(script_insercion,(jugador['Nombre'], jugador['Numero_ranking'],
        'M', jugador['Pais'], jugador['Puntos'], jugador['Posicion'], jugador['Pareja'],
        jugador['Fecha nacimiento'], jugador['Altura'], jugador['Pais nacimiento'], jugador['Lugar residencia'],
        jugador['Partidos jugados'], jugador['Partidos ganados'], jugador['Partidos perdidos'],
        jugador['Victorias consecutivas'], jugador['Efectividad'], jugador['Titulos'], jugador['Foto jugador']))

    for jugador in jugadores_femeninos:
        cursor.execute(script_insercion,(jugador['Nombre'], jugador['Numero_ranking'],
        'F', jugador['Pais'], jugador['Puntos'], jugador['Posicion'], jugador['Pareja'],
        jugador['Fecha nacimiento'], jugador['Altura'], jugador['Pais nacimiento'],
        jugador['Lugar residencia'], jugador['Partidos jugados'], jugador['Partidos ganados'],
        jugador['Partidos perdidos'], jugador['Victorias consecutivas'],
        jugador['Efectividad'], jugador['Titulos'], jugador['Foto jugador']))


    #Cerramos la conexion con la base de datos
    conexion.close()


#FUNCION: Consulta todos los datos de la bbdd
def consultar_datos():

    #Inicamos conexión
    conexion = conectar_bbdd()

    #Iniciamos cursor y especificamos que queremos los datos en forma de diccionario
    cursor = conexion.cursor(dictionary=True)

    #Lista de jugadores
    lista_jugadores = []

    #Script de consulta
    script_consulta = "SELECT * FROM jugador"

    #Ejecutar la consulta
    cursor.execute(script_consulta)

    #Para obtener los datos de la consulta ejecutada anterior
    lista_jugadores = cursor.fetchall()

    #Cerramos conexión
    conexion.close()

    return lista_jugadores

#FUNCION: filtrar datos

def consultar_datos_filtrado(filtro):

    #Inicamos conexión
    conexion = conectar_bbdd()

    #Iniciamos cursor y especificamos que queremos los datos en forma de diccionario
    cursor = conexion.cursor(dictionary=True)

    #Lista de jugadores
    lista_jugadores_filtro = []

    #Script de consulta
    script_consulta = "select * from jugador where LOWER(nombre) like '%"+filtro.lower()+"%' or LOWER(pareja) like '%"+filtro.lower()+"%';"

    #Ejecutar la consulta
    cursor.execute(script_consulta)

    #Para obtener los datos de la consulta ejecutada anterior
    lista_jugadores_filtro = cursor.fetchall()

    #Cerramos conexión
    conexion.close()

    return lista_jugadores_filtro


#FUNCION: Elimina jugador por id
def eliminar_por_id(id):

    # Inicamos conexión
    conexion = conectar_bbdd()

    # Iniciamos cursor y especificamos que queremos los datos en forma de diccionario
    cursor = conexion.cursor()

    # Script de consulta
    script_eliminar = "DELETE FROM jugador WHERE id=" + id

    # Ejecutar la consulta
    cursor.execute(script_eliminar)

    # Cerramos conexión
    conexion.close()


#FUNCION: Inserta un nuevo jugador
def insertar_registro_nuevo(jugador):

    # Abrimos conexion con la bbdd
    conexion = conectar_bbdd()

    # Abrimos cursor
    cursor = conexion.cursor()

    # Sentencia INSERT
    script_insercion = "insert into jugador (nombre,numero_ranking, sexo, pais, puntos, posicion, pareja, fecha_nacimiento, altura, pais_nacimiento, lugar_residencia, partidos_jugados, partidos_ganados, partidos_perdidos, victorias_consecutivas, efectividad, titulos, url_foto) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"

    # Cada pala se convierte en un script de inserción
    cursor.execute(script_insercion, (
    jugador['Nombre'], jugador['Numero_ranking'], jugador['Sexo'] , jugador['Pais'], jugador['Puntos'], jugador['Posicion'],
    jugador['Pareja'], jugador['Fecha nacimiento'], jugador['Altura'], jugador['Pais nacimiento'], jugador['Lugar residencia'],
    jugador['Partidos jugados'], jugador['Partidos ganados'], jugador['Partidos perdidos'],
    jugador['Victorias consecutivas'], jugador['Efectividad'], jugador['Titulos'], jugador['Foto jugador']))

    # Cerramos conexión
    conexion.close()


def consultar_datos_por_id(id):
    # Inicamos conexión
    conexion = conectar_bbdd()

    # Iniciamos cursor y especificamos que queremos los datos en forma de diccionario
    cursor = conexion.cursor(dictionary=True)

    # Lista de jugadores
    lista_jugadores_filtro = []

    # Script de consulta
    script_consulta = "select * from jugador where id=" + id

    # Ejecutar la consulta
    cursor.execute(script_consulta)

    # Para obtener los datos de la consulta ejecutada anterior
    lista_jugadores_filtro = cursor.fetchall()

    # Cerramos conexión
    conexion.close()

    return lista_jugadores_filtro

def modificar_registro(id,jugador):

    # Abrimos conexion con la bbdd
    conexion = conectar_bbdd()

    # Abrimos cursor
    cursor = conexion.cursor()

    # Sentencia INSERT
    script_modificar = """UPDATE jugador
        SET
            nombre = %s,
            numero_ranking = %s,
            puntos = %s,
            posicion = %s,
            pareja = %s,
            pais = %s,
            partidos_jugados = %s,
            partidos_ganados = %s,
            partidos_perdidos = %s,
            victorias_consecutivas = %s,
            efectividad = %s,
            titulos = %s,
            fecha_nacimiento = %s,
            pais_nacimiento = %s,
            lugar_residencia = %s,
            altura = %s,
            url_foto = %s,
            sexo = %s
        WHERE id = %s"""

    # Cada pala se convierte en un script de inserción
    cursor.execute(script_modificar, (
    jugador['Nombre'], jugador['Numero_ranking'], jugador['Puntos'], jugador['Posicion'],
    jugador['Pareja'], jugador['Pais'], jugador['Partidos jugados'], jugador['Partidos ganados'], jugador['Partidos perdidos'],
    jugador['Victorias consecutivas'], jugador['Efectividad'], jugador['Titulos'],
    jugador['Fecha nacimiento'], jugador['Pais nacimiento'], jugador['Lugar residencia'], jugador['Altura'],
     jugador['Foto jugador'], jugador['Sexo'], str(id)))

    # Cerramos conexión
    conexion.close()


'''

PLANTILLA DICCIONARIO JUGADOR

jugador = {    'Nombre': '',
               'Sexo': '',
               'Numero_ranking': '',
               'Pais': '',
               'Puntos': '',
               'Posicion': '',
               'Pareja': '',
               'Fecha nacimiento': '',
               'Altura': ,
               'Pais nacimiento': '',
               'Lugar residencia': '',
               'Partidos jugados': ,
               'Partidos ganados': ,
               'Partidos perdidos': ,
               'Victorias consecutivas': ,
               'Efectividad': '',
               'Titulos': ,
               'Foto jugador': 
               }

'''