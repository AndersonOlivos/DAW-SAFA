listin = {'Juan':123456789, 'Pedro':987654321}
def elimina(listin, usuario):
    if usuario in listin:
        del listin[usuario]
    return listin
print(elimina(listin, 'Pedro'))