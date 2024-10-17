"""
Se desea realizar un programa para realizar encuestas por consola. Para ello el programa recibe:
● La lista con las preguntas de la encuesta.
● El número de personas a las que tiene que preguntar.
El programa debe realizar las preguntas por turnos a los entrevistados y mostrar luego los resultados,
de la siguiente manera, para los siguientes datos de entrada.
● preguntas= [“¿Cuál es tu color favorito?”, “¿Cuántos años tienes?” ]
● num_personas = 3

"""

preguntas=["¿Cómo te llamas? ","¿Cuántos años tienes? ","¿Tienes mascota? ","¿Te gusta Sevilla? "] #Guardamos las preguntas en una lista

num_personas=3 #Guardamos el nº de entrevistados

respuestas=[] #Creamos la lista de las respuestas

for i in range(num_personas):
    print("-------------------------ENTREVISTADO",i+1,"-------------------------") #Imprimimos ENTREVISTADO 1,2,3...
    respuestas.append([]) #Añadimos una sublista por cada entrevistado
    for b in preguntas:
        respuestas[i].append(input(b)) #Realizamos  pregunta a cada entrevistado y lo guardamos dentro de la sublista.
        

print("\n\n-----------------------RESUMEN ENCUESTA----------------------")
print("---------------------------------------------------------------------------")

#Imprimimos el resultado de los datos

for i in range(len(preguntas)):
    print("Pregunta ",i+1," --> ",preguntas[i]) #Imprimimos la pregunta
    print("Respuestas -->",end=" ") #Imprimimos las respuestas
    aux=[] #Creo una lista auxiliar, ya que el ejercicio se podría haber planteado de otra forma
    for a in respuestas:
        aux.append(a[i])
    print(aux)
    print("\n")