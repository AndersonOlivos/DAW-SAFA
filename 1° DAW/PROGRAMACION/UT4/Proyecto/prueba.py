import requests
from bs4 import BeautifulSoup

url = "https://teamheretics.com/es/todos-los-productos?order=product.position.asc&resultsPerPage=9999999"

respuesta = requests.get(url)

soup = BeautifulSoup(respuesta.text, 'html.parser')

articulos = []

productos = soup.find_all('article', class_='product-miniature product-miniature-default product-miniature-grid product-miniature-layout-1 js-product-miniature')

for producto in productos:
    titulo = producto.find('h2').text
    titulo = titulo.replace("\n","")
    dictionary = {'titulo' : titulo}
    articulos.append(dictionary)

print(articulos)