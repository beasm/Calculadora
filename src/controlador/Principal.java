package controlador;

import gui.JCalculadora;

/*
 * Clase Principal: se crean objetos de las clases donde se definen la interfaz gráfica y
 * el manejo de eventos. Se ejecuta el método que añade los listeners a los elementos que 
 * se van a controlar sus eventos 
 * 
 * */
public class Principal {

	public static void main(String[] args) {
		JCalculadora calculadora= new JCalculadora();
		ManejadorEventos manejador = new ManejadorEventos(calculadora);
	    calculadora.establecerManejador(manejador);

	}

}
