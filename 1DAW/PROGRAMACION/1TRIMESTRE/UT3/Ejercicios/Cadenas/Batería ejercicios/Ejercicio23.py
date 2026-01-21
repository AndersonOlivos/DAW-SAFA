texto=input("Escribe una cadena de texto:\n\n")

letras_repetidas=""

new_text=""

for a in texto:
    if a not in letras_repetidas:
        new_text=new_text+a
        letras_repetidas=letras_repetidas+a


print(new_text)