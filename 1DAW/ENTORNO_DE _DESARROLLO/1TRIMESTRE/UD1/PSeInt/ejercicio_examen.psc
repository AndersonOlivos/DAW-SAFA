Algoritmo examen
	
	Escribir 'Introduce el total de tu compra:'
	Leer compra
	
	numero<-azar(501)
	Escribir 'Número aleatorio:',numero
	
	Si numero<100 Entonces
		descuento<-10
	SiNo
		descuento<-20
	Fin Si
	
	Si numero%2==0 Entonces
		descuento_adicional<-2
	SiNo
		descuento_adicional<-3
	Fin Si
	
	descuento_final<-descuento+descuento_adicional
	Escribir 'Descuento:',descuento_final,'%'
	
	precio_final<-compra - (compra*descuento_adicional/100)
	
	Escribir 'Precio final con descuento aplicado: ',precio_final
	
FinAlgoritmo
