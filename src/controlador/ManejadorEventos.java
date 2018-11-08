package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.JButton;


import gui.JCalculadora;

/*
 * Clase que se encarga de actuar según los eventos que vayan ocurriendo
 * */

public class ManejadorEventos implements ActionListener{
	private JCalculadora calculadora;
	private int operando1,operando2;
	private String operacion;
	String vistaCalculo;
	private int resultado;
	private Color fondoBoton;
	private String textoInicio;
	private String textoAcierto;
	private String textoError;

	public ManejadorEventos(JCalculadora calculadora) {
		this.calculadora=calculadora;		
		resultado=0;
	    vistaCalculo="";
	   textoInicio="Empecemos";
		textoAcierto="Vuelve a intentarlo";
		textoError="Bien Hecho";
	    fondoBoton=calculadora.getOpcion1().getBackground();
	    estadoInicial("","",false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {

		case "1":				
		case "2":			
		case "3":			
		case "4":		
		case "5":			
		case "6":
		case "7":			
		case "8":			
		case "9":			
		case "0":			
			//Se introduce la primera cifra del primer operando. Se activan las operaciones y ls tecla de borrado
			if(operando1==-1) { 
				
				vistaCalculo=e.getActionCommand();
				estadoInicial(textoInicio,vistaCalculo,true); 
				operando1=Integer.parseInt(e.getActionCommand());
				activarOperaciones(true); 
				activarTeclaBorrado(true);

			}
			 //si el cálculo es de 2 cifras se añade la segunda al primer operando y se desactivan los números
			else if(operacion==null) {  
				vistaCalculo+=e.getActionCommand();
				operando1=operando1*10 + Integer.parseInt(e.getActionCommand());
				activarNumeros(false);
				

			}
			//Se introduce la primera cifra del segundo operando y se activa la tecla Igual
			else if(operando2==-1) {
				 
				 vistaCalculo+=e.getActionCommand();
				 operando2=Integer.parseInt(e.getActionCommand());
				 activarIgual(true);
				// si dividimos se activa el 0 en el segundo operando
				 if(operacion.equals("/"))  activarCero(true);
			}
			//Se introduce la segunda cifra del segundo operando y se desactivan los números
			else {
					vistaCalculo+=e.getActionCommand();
					operando2=operando2*10 + Integer.parseInt(e.getActionCommand());				
					activarNumeros(false);
					
				}
			
			//Mostrar cálculo
			calculadora.getEtiquetaOperacion().setText(vistaCalculo);
			
		break;
		//Operaciones
		case "+":	
		case "-":
		case "*":	
		case "/":
			
			operacion=e.getActionCommand();		
			vistaCalculo+=operacion;
			calculadora.getEtiquetaOperacion().setText(vistaCalculo);
			 pulsarBotonOperacion();
			 //Si la operación es division ,se desactiva el cero para la primera cifra del segundo operando
			 if(operacion.equals("/")) activarCero(false);
			break;
		case "=":
			vistaCalculo+=e.getActionCommand();
			calculadora.getEtiquetaOperacion().setText(vistaCalculo);
			obtenerResultado(operacion);
			
			//definir las opciones. Las activamos, le damos valores y desactivamo el botón igual
			activarOpciones(true) ;
			asignarOpciones(opcionesRespuesta(resultado));
			activarIgual(false);
			activarNumeros(false);
			break;
			
			//Opciones. Si se pulsa la opcion correcta se muestra el estiloAcierto, si no el estilo error
		case "OP1":			
			   pulsarOpciones(calculadora.getOpcion1());
			   break;
		         
		case "OP2":	
				pulsarOpciones(calculadora.getOpcion2());
				break;
		case "OP3":
			 	pulsarOpciones(calculadora.getOpcion3());		
			 	break;
		case "OP4":
			 	pulsarOpciones(calculadora.getOpcion4());
			 	break;
	         
		case "ON": //Boton que enciende y apaga calculadora
			if(calculadora.getBoton1().isEnabled())  //si la calculadora está encendida
				estadoInicial("","",false);  //la apaga
			
			else { //se activan los números y se pone a 0 la operación
				activarNumeros(true);  
				calculadora.getEtiquetaOperacion().setText("0");
				mostrarMotivacion(textoInicio);
			}
			
	         break;	
	         
		case "BORRAR": // botón borrar
			  //Pone a cero la operación y queda la calculadora en el estado inicial
			  estadoInicial(textoInicio,"0",true);
			  break;
					
		}

	}



   //Activar/Desactivar botones de operaciones
	private void activarOperaciones(boolean activar) {
		calculadora.getBotonSumar().setEnabled(activar);
		calculadora.getBotonRestar().setEnabled(activar);
		calculadora.getBotonMultiplicar().setEnabled(activar);
		calculadora.getBotonDividir().setEnabled(activar);
	}
	
	
	//Activar/Desactivar botones de números
	private void activarNumeros(boolean activar) {
		calculadora.getBoton1().setEnabled(activar);
		calculadora.getBoton2().setEnabled(activar);
		calculadora.getBoton3().setEnabled(activar);
		calculadora.getBoton4().setEnabled(activar);
		calculadora.getBoton5().setEnabled(activar);
		calculadora.getBoton6().setEnabled(activar);
		calculadora.getBoton7().setEnabled(activar);
		calculadora.getBoton8().setEnabled(activar);
		calculadora.getBoton9().setEnabled(activar);
		calculadora.getBoton0().setEnabled(activar);
		
	}
	//Activar/Desactivar botones de opciones
	private void activarOpciones(boolean activar) {
		calculadora.getOpcion1().setEnabled(activar);
		calculadora.getOpcion2().setEnabled(activar);
		calculadora.getOpcion3().setEnabled(activar);
		calculadora.getOpcion4().setEnabled(activar);
	}
	//Borrar valores de los botones de las opciones
	private void borrarOpciones(String cad) {
		calculadora.getOpcion1().setText(cad);
		calculadora.getOpcion2().setText(cad);
		calculadora.getOpcion3().setText(cad);
		calculadora.getOpcion4().setText(cad);
	}
	
	//Activar/Desactivar botones de número 0
	 private void activarCero(boolean activar) {
		 calculadora.getBoton0().setEnabled(activar);
	 }
	 
	 //Asignar valores a los botones de opciones
	private void asignarOpciones(TreeSet<Integer> opciones) {
		
		calculadora.getOpcion1().setText(String.valueOf(opciones.pollFirst()));
		calculadora.getOpcion2().setText(String.valueOf(opciones.pollFirst()));
		calculadora.getOpcion3().setText(String.valueOf(opciones.pollFirst()));
		calculadora.getOpcion4().setText(String.valueOf(opciones.pollFirst()));
		
	}
	//Obtener resultado numérico de la operación
	private void obtenerResultado(String operacion) {
		switch(operacion) {
		case "+":
			resultado = operando1+operando2;
			break;
		case "-":
			resultado = operando1-operando2;
			break;
		case "*":
			resultado = operando1*operando2;
			break;
		case "/":
			resultado = operando1/operando2;
			break;  
		}
		
	}
	//Activar/Desactivar botón Igual
	private void activarIgual(boolean activar) {
		calculadora.getBotonIgual().setEnabled(activar);

	}
	//Activar/Desactivar botón de tecla borrado
	private void activarTeclaBorrado(boolean activar) {
		calculadora.getBotonBorrado().setEnabled(activar);

	}

    //Mostrar mensaje de motivación
	private void mostrarMotivacion(String resultado) {
		calculadora.getEtiquetaMotivacion().setText(resultado);
	}
    
	/*Estado inicial de la calculadora. Se incializan los operando y la operacion. Los números se activan o no en función de
	 * la situación. Las operaciones, el igual, las opciones y la tecla borrado se desactivan. 
	 * Se borran los valores y los fondos de los botones de las opciones. Se muestran textos de inicio*/
	
	private void estadoInicial(String mensajeMotivacion,String mensajeOperacion, boolean inicio) {
		operando1=-1;
		operando2=-1;
		operacion=null;
		activarOperaciones(false);
		activarNumeros(inicio);
		activarIgual(false);
		borrarOpciones("");
		activarOpciones(false);
		activarTeclaBorrado(false);
		calculadora.getEtiquetaOperacion().setText(mensajeOperacion);
		mostrarMotivacion(mensajeMotivacion);
		
		calculadora.getOpcion1().setBackground(fondoBoton);
		calculadora.getOpcion2().setBackground(fondoBoton);
		calculadora.getOpcion3().setBackground(fondoBoton);
		calculadora.getOpcion4().setBackground(fondoBoton);
		
	}
	/*Al pulsar el botón de una opción, si es correcta se muestra el estilo de acierto y si no el de error*/
	
	private void pulsarOpciones(JButton opcion) {
		if(opcion.getText().equals(String.valueOf(resultado))) 
			estiloAcierto(opcion);
		else  estiloError(opcion);
	     	}
	
	//Al pulsar cualquier botón de una operacion se desactivan las operaciones y se activan los números
	 

	private void pulsarBotonOperacion() {
		activarOperaciones(false);
		activarNumeros(true);
		
	}
	
	/*Obtiene las 4 opciones de respuesta para los botones opciones*/
	private TreeSet<Integer> opcionesRespuesta(int resultado) {
		
			TreeSet<Integer> opciones = new TreeSet<Integer>();
			int opcion;
			 Random r = new Random(); 
			 int posicion = r.nextInt(4);
			 int contador=0;
			 while(opciones.size()<4) {
				 
				 if(contador!=posicion) {
				 opcion = r.nextInt(41) +(resultado-20);
				 opciones.add(opcion);
				
				 } else {
					 opciones.add(resultado);
					 
				 }
				 contador++;
			 }
				 return opciones;
		}
	/*Definimos el estilo del resultado cuando es un error, letra, tamaño, color....*/
	public void estiloError(JButton boton) {
		calculadora.getEtiquetaMotivacion().setText(textoError);
		calculadora.getEtiquetaOperacion().setText(vistaCalculo);
		boton.setBackground(Color.RED);
		boton.setEnabled(false);
	}

	/*Definimos el estilo del resultado cuando es correcto, letra, tamaño, color....*/
	public void estiloAcierto(JButton boton) {
		operacion=null;
		operando1=-1;
		operando2=-1;
		activarOpciones(false); //se desactivan las opciones
		activarNumeros(true);
		calculadora.getEtiquetaMotivacion().setText(textoAcierto); //texto de motivación
		vistaCalculo+=resultado; 
        calculadora.getEtiquetaOperacion().setText(vistaCalculo); //resultado correcto
        boton.setBackground(Color.GREEN);
     }
		
}
