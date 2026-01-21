Algoritmo supermercado
	Escribir 'Introduce el número de niños'
	Leer numero_ninos
	Escribir 'Introduce el número de niñas'
	Leer numero_ninas
	
	total_alumnos<-numero_ninas+numero_ninos
	
	porcentaje_ninos<-redon((numero_ninos*100)/total_alumnos)
	porcentaje_ninas<-redon((numero_ninas*100)/total_alumnos)
	
	Si porcentaje_ninos==0 Entonces
		paridad_ninos<-'El porcentaje no es par ni impar'
	SiNo
		Si porcentaje_ninos%2=0 Entonces
			paridad_ninos<-'El porcentaje es par'
		SiNo
			paridad_ninos<-'El porcentaje es impar'
		Fin Si
	Fin Si
	
	Si porcentaje_ninas==0 Entonces
		paridad_ninas<-'El porcentaje no es par ni impar'
	SiNo
		Si porcentaje_ninas%2=0 Entonces
			paridad_ninas<-'El porcentaje es par'
		SiNo
			paridad_ninas<-'El porcentaje es impar'
		Fin Si
	Fin Si
	
	
	Escribir 'Porcentaje de niños: ' porcentaje_ninos '%.'
	Escribir paridad_ninos
	Escribir ''
	Escribir 'Porcentaje de niñas: ' porcentaje_ninas '%.'
	Escribir paridad_ninas
	
	
FinAlgoritmo
