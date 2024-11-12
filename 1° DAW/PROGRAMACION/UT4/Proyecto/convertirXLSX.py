import csv
from RankingPadel import web_scraping
import pandas as pd

def convertir_a_xlsx(nombre_fichero, jugadores):

    #Conversión a CSV

    csv_file = open(f'{nombre_fichero}.csv', 'w', encoding='utf-8', newline='')
    writer = csv.writer(csv_file)
    writer.writerow(keys)
    for jugador in jugadores:
        writer.writerow(jugador.values())
    csv_file.close()

    #Conversión a XLSX

    df = pd.read_csv(f'{nombre_fichero}.csv')

    df.to_excel(f'{nombre_fichero}.xlsx', index=False)

keys=['Nombre', 'Numero', 'Pais', 'Puntos', 'Posicion', 'Pareja', 'Anyo_nacimiento', 'Altura', 'Nacido en',
         'Vive en', 'Partidos jugados', 'Partidos ganados', 'Partidos perdidos', 'Victorias Consecutivas',
         'Efectividad', 'Titulos', 'Foto jugador']

jugadores_masculinos = web_scraping('https://www.padelfip.com/ranking-male/', 2)
jugadores_femeninos = web_scraping('https://www.padelfip.com/ranking-female/', 2)

convertir_a_xlsx('jugadores-padel-masculino',jugadores_masculinos)
convertir_a_xlsx('jugadores-padel-femenino',jugadores_femeninos)