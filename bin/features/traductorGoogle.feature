#Author: juanno23@hotmail.com
@Regresion
Feature: Como un usuario
	quiero ingresar a google translator
	a traducir palabras en diferentes lenguajes
	
	@traducir
	Scenario: Traducir de ingles a espanol
		Given Que Juan quiera usar el traductor de google
		When el traduce la palabra table de ingles a  espanol
		Then el deberia ver la palabra mesa en pantalla
		
		

