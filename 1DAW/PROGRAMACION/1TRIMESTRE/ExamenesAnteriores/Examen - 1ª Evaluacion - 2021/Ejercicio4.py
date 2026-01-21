def media(notas):
    media=sum(notas)/(len(notas))

    if media < 5:
        print("Suspenso")
    elif media<7:
        print("Aprobado")
    elif media<9:
        print("Notable")
    elif media>9:
        print("Sobresaliente")

notas=[5.6,7,6.2,7]
media(notas)