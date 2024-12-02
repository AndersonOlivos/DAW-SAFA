texto=input("Escribe una cadena de texto:\n\n")

letra_count=input("Escribe la letra que quieras contar:\n")

counter=0

for i in texto:
    if i == letra_count:
        counter=counter+1

print("La letra '",letra_count, "' se repite ",counter, " veces en el texto.")