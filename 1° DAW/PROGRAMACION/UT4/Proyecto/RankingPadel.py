import requests
from bs4 import BeautifulSoup
import re

#Función para obtener la 'sopa' de una página

def obtener_soup_pagina(url):
    respuesta = requests.get(url).content
    soup = BeautifulSoup(respuesta,'html.parser')
    return soup



#Función principal para realizar Web Scraping

def web_scraping(enlace_pagina, numero_maximo_jugadores):

    soup_pagina = obtener_soup_pagina(enlace_pagina)

    #Obtenemos todos los enlaces de los jugadores

    enlaces = soup_pagina.find_all('a', href= re.compile("https://www.padelfip.com/player/"))

    #Creamos una lista para almacenar los datos de los jugadores

    jugadores = []

    max = 0

    for enlace in enlaces:

        #Se almacenarán solo 20 jugadores

        if max==numero_maximo_jugadores: break
        else: max+=1

        if enlace.find('img') is None:

            soup_jugador = obtener_soup_pagina(enlace['href'])

            #Obtener efectividad y titulos ganados del jugador

            efectividades_soup = soup_jugador.find_all('div', class_='matchPlayer__effective')

            efectividades = []

            for efectividad in efectividades_soup:
                efectividades.append(efectividad.find('span').text)

            #Creamos un diccionario con todos los datos del jugador

            diccionario = {'Nombre': soup_jugador.find('h2', class_='slider__name player__name').text,
                           'Numero': int(soup_jugador.find('span', class_='slider__number player__number').find(string=True, recursive=False)),
                           'Pais': soup_jugador.find('p', class_='slider__country player__country').text,
                           'Puntos': float(soup_jugador.find('span', class_='slider__pointTNumber player__pointTNumber').text),
                           'Posicion': soup_jugador.find('div', class_='additionalInfo__hand').find('span', class_='content').text,
                           'Pareja': soup_jugador.find('div', class_='additionalInfo__paired').find('a').text,
                           'Anyo_nacimiento': soup_jugador.find('div', class_='additionalInfo__birth').find('span', class_='additionalInfo__data').text,
                           'Altura': float(soup_jugador.find('div', class_='additionalInfo__height').find('span', class_='additionalInfo__data').text),
                           'Nacido en': soup_jugador.find('div', class_='additionalInfo__born').find('span', class_='additionalInfo__data').text,
                           'Vive en': soup_jugador.find('div', class_='additionalInfo__lives').find('span', class_='additionalInfo__data').text,
                           'Partidos jugados': int(soup_jugador.find('div', class_='matchPlayer__played').find('span').text),
                           'Partidos ganados': int(soup_jugador.find('div', class_='matchPlayer__won').find('span').text),
                           'Partidos perdidos': int(soup_jugador.find('div', class_='lost').find('span').text),
                           'Victorias consecutivas': int(soup_jugador.find('div', class_='matchPlayer__victories').find('span').text),
                           'Efectividad': efectividades[0],
                           'Titulos': int(efectividades[1]),
                           'Foto jugador': soup_jugador.find('img', class_='attachment-258x400')['data-src']
                           }

            #Añadimos este diccionario a la lista de jugadores

            jugadores.append(diccionario)

    #Devolvemos la lista con todos los datos de los jugadores

    return jugadores

jugadores_masculinos = web_scraping('https://www.padelfip.com/ranking-male/', 20)
jugadores_femeninos = web_scraping('https://www.padelfip.com/ranking-female/', 20)