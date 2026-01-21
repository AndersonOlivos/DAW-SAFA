texto=input("Escribe una cadena de texto:\n\n")

texto=texto.lower()

vocales="aeiouáéíóú"

texto_final=""

for a in texto:
    if a in vocales:
        texto_final=texto_final+a

print(texto_final)