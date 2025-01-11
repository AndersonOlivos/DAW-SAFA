def aplica_iva(base, iva):
    base = int(base) * iva/100
    return base

base = input('Introduce la base imponible de la factura: ')
print(aplica_iva(base, iva = 21))
