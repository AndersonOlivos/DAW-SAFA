contrasena="12345EDD"

contrasena_try=input("Adivina la contraseña: ")

while(contrasena_try!=contrasena):
    print("Contraseña errónea.")
    contrasena_try=input("Prueba otra vez: ")

print("CONTRASEÑA CORRECTA")