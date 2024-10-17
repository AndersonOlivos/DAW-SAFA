def invertir_texto(cadena):  
        
    res=cadena.split(" ") #Dividimos la cadena por espacios
    return " ".join(res[::-1]) #Invertimos el orden de la lista y la juntamos nuevamente con espacios
    
texto = input("Escribe una cadena de texto: ")
print("\nResultado: ",invertir_texto(texto))
