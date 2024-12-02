import requests
from bs4 import BeautifulSoup
import re

# Función para obtener la 'sopa' de una página
def obtener_soup_pagina(url):
    respuesta = requests.get(url).content
    soup = BeautifulSoup(respuesta, 'html.parser')
    return soup

# Función para obtener el atributo src o data-src
def obtener_atributo_imagen(tag, clase, atributos):
    """
    Intenta obtener un atributo específico de una etiqueta,
    pero solo si comienza con 'http'.
    """
    imagen = tag.find('img', class_=clase)
    if imagen is not None:
        for atributo in atributos:
            if atributo in imagen.attrs and imagen[atributo].startswith('http'):
                return imagen[atributo]
    return None

# Función principal para realizar Web Scraping
def web_scraping(enlace_pagina, numero_maximo_jugadores):
    soup_pagina = obtener_soup_pagina(enlace_pagina)

    # Obtenemos todos los enlaces de los jugadores
    enlaces = soup_pagina.find_all('a', href=re.compile("https://www.padelfip.com/player/"))

    # Creamos una lista para almacenar los datos de los jugadores
    jugadores = []
    max = 0

    for enlace in enlaces:
        # Se almacenarán solo 'numero_maximo_jugadores' jugadores
        if max == numero_maximo_jugadores:
            break
        else:
            max += 1

        if enlace.find('img') is None:
            soup_jugador = obtener_soup_pagina(enlace['href'])

            # Obtener efectividad y títulos ganados del jugador
            efectividades_soup = soup_jugador.find_all('div', class_='matchPlayer__effective')
            efectividades = [ef.find('span').text for ef in efectividades_soup]

            # Obtener la foto del jugador
            foto_jugador = obtener_atributo_imagen(
                soup_jugador, 'attachment-258x400', ['src', 'data-src']
            )

            # Creamos un diccionario con todos los datos del jugador
            diccionario = {
                'Nombre': soup_jugador.find('h2', class_='slider__name player__name').text,
                'Numero_ranking': int(soup_jugador.find('span', class_='slider__number player__number').find(string=True, recursive=False)),
                'Pais': soup_jugador.find('p', class_='slider__country player__country').text,
                'Puntos': float(soup_jugador.find('span', class_='slider__pointTNumber player__pointTNumber').text),
                'Posicion': soup_jugador.find('div', class_='additionalInfo__hand').find('span', class_='content').text,
                'Pareja': soup_jugador.find('div', class_='additionalInfo__paired').find('a').text,
                'Fecha nacimiento': soup_jugador.find('div', class_='additionalInfo__birth').find('span', class_='additionalInfo__data').text,
                'Altura': float(soup_jugador.find('div', class_='additionalInfo__height').find('span', class_='additionalInfo__data').text),
                'Pais nacimiento': soup_jugador.find('div', class_='additionalInfo__born').find('span', class_='additionalInfo__data').text,
                'Lugar residencia': soup_jugador.find('div', class_='additionalInfo__lives').find('span', class_='additionalInfo__data').text,
                'Partidos jugados': int(soup_jugador.find('div', class_='matchPlayer__played').find('span').text),
                'Partidos ganados': int(soup_jugador.find('div', class_='matchPlayer__won').find('span').text),
                'Partidos perdidos': int(soup_jugador.find('div', class_='lost').find('span').text),
                'Victorias consecutivas': int(soup_jugador.find('div', class_='matchPlayer__victories').find('span').text),
                'Efectividad': efectividades[0],
                'Titulos': int(efectividades[1]),
                'Foto jugador': foto_jugador
            }

            # Añadimos este diccionario a la lista de jugadores
            jugadores.append(diccionario)

    # Devolvemos la lista con todos los datos de los jugadores
    return jugadores
