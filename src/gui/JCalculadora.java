package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ManejadorEventos;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;

	//componentes que van a estar dentro de la ventana
	private JLabel etiquetaTitulo, etiquetaLogo, etiquetaMotivacion, etiquetaOperacion;
	private JButton opcion1, opcion2, opcion3, opcion4,botonOn_Off, botonSumar, botonRestar, botonMultiplicar;
	private JButton botonDividir, boton0, boton1, boton2, boton3, boton4, boton5, boton6;
	private JButton boton7, boton8, boton9, botonIgual, botonBorrado;
    

	/*Constructor que define los elementos básicos (tamaño, posición, organización...) de la ventana y la hace visible*/
	public JCalculadora() {
		//setSize(600, 600);
		setBounds(20,20,600,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("¡Vamos a jugar con números!");
		getContentPane().setBackground(Color.white);
//		setIconImage(Toolkit.getDefaultToolkit().getImage("Img/logo.png"));
		setLayout(null);
		inicializarComponentes();
		setVisible(true);
	}

	/*Este  método permite inicializar los componentes que van en la ventana,creando
	 * los objetos y dándoles un tamaño y posición. Por último, se añaden a la ventana*/

	private void inicializarComponentes() {
		
              
	    botonOn_Off = new JButton();
	    botonOn_Off.setIcon(new ImageIcon("BotonOn.PNG"));
	    botonOn_Off.setBounds(523, 10, 50, 50);
        add(botonOn_Off);
	    
        Color colorLetra = new Color(0, 0, 0);
        Color colorFondo = new Color(255, 255, 255);
        Font fuenteLetra = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        
		etiquetaTitulo = new JLabel("Calculin");
		etiquetaTitulo.setBounds(125, 10, 250, 40);
		etiquetaTitulo.setFont(new Font("emmasophia", Font.BOLD, 30));
		etiquetaTitulo.setForeground(colorLetra);
		etiquetaTitulo.setOpaque(true);
		etiquetaTitulo.setBackground(colorFondo);
        add(etiquetaTitulo);
        
		etiquetaLogo = new JLabel(new ImageIcon("ninos.png"));
		etiquetaLogo.setBounds(45, 10, 50, 50);
		add(etiquetaLogo);
        
        etiquetaMotivacion = new JLabel("Mensaje Motivacional");
        etiquetaMotivacion.setBounds(45, 75, 500, 40);
        etiquetaMotivacion.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        etiquetaMotivacion.setForeground(colorLetra);
        etiquetaMotivacion.setOpaque(true);
        etiquetaMotivacion.setBackground(colorFondo);
        etiquetaMotivacion.setHorizontalAlignment(JTextField.CENTER); 
        add(etiquetaMotivacion);
        
        etiquetaOperacion = new JLabel("Operacion: 1 + 1 = 2");
        etiquetaOperacion.setBounds(45, 125, 500, 40);
        etiquetaOperacion.setFont(fuenteLetra);
        etiquetaOperacion.setForeground(colorLetra);
        etiquetaOperacion.setOpaque(true);
        etiquetaOperacion.setBackground(colorFondo);
        etiquetaOperacion.setHorizontalAlignment(JTextField.CENTER); 
        add(etiquetaOperacion);
        
        opcion1 = new JButton("Opcion1");
        opcion1.setBounds(45, 190, 115, 60);
        opcion1.setFont(fuenteLetra);
        opcion1.setForeground(colorLetra);
        opcion1.setOpaque(true);
        opcion1.setBackground(colorFondo);
        add(opcion1);
        
        opcion2 = new JButton("Opcion2");
        opcion2.setBounds(170, 190, 115, 60);
        opcion2.setFont(fuenteLetra);
        opcion2.setForeground(colorLetra);
        opcion2.setOpaque(true);
        opcion2.setBackground(colorFondo);
        add(opcion2);
        
        opcion3 = new JButton("Opcion3");
        opcion3.setBounds(295, 190, 115, 60);
        opcion3.setFont(fuenteLetra);
        opcion3.setForeground(colorLetra);
        opcion3.setOpaque(true);
        opcion3.setBackground(colorFondo);
        add(opcion3);
        
        opcion4 = new JButton("Opcion4");
        opcion4.setBounds(420, 190, 115, 60);
        opcion4.setFont(fuenteLetra);
        opcion4.setForeground(colorLetra);
        opcion4.setOpaque(true);
        opcion4.setBackground(colorFondo);
        add(opcion4);
        
        
		/**Jose**/
        botonSumar = new JButton("+");
		botonSumar.setBounds(400, 300, 70, 60);
		
		botonRestar = new JButton("-");
		botonRestar.setBounds(400, 370, 70, 60);
		
		botonMultiplicar = new JButton("*");
		botonMultiplicar.setBounds(400, 440, 70, 60);
		
		botonDividir = new JButton("/");
		botonDividir.setBounds(400, 510, 70, 60);
		
		boton0 = new JButton("0");
		boton0.setBounds(130, 510, 70, 60);
		
		boton1 = new JButton("1");
		boton1.setBounds(130, 300, 70, 60);
		
		boton2 = new JButton("2");
		boton2.setBounds(220, 300, 70, 60);
		
		boton3 = new JButton("3");
		boton3.setBounds(310, 300, 70, 60);
		
		boton4 = new JButton("4");
		boton4.setBounds(130, 370, 70, 60);
		
		boton5 = new JButton("5");
		boton5.setBounds(220, 370, 70, 60);
		
		boton6 = new JButton("6");
		boton6.setBounds(310, 370, 70, 60);
		
		boton7 = new JButton("7");
		boton7.setBounds(130, 440, 70, 60);
		
		boton8 = new JButton("8");
		boton8.setBounds(220, 440, 70, 60);
		
		boton9 = new JButton("9");
		boton9.setBounds(310, 440, 70, 60);
		
		botonIgual = new JButton("=");
		botonIgual.setBounds(220, 510, 70, 60);
		
		botonBorrado = new JButton("R");
		botonBorrado.setBounds(310, 510, 70, 60);
		
		add(botonSumar);
		add(botonRestar);
		add(botonMultiplicar);
		add(botonDividir);
		add(boton0);
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		add(boton6);
		add(boton7);
		add(boton8);
		add(boton9);
		add(botonIgual);
		add(botonBorrado);
	
	}

	/*
	 * Métodos getters de algunos de los componentes que nos permitiran trabajar con ellos en la
	 * clase ManejadorEventos*/	
	
	public JLabel getEtiquetaOperacion() {
		
		return etiquetaOperacion;
	}
	
	public JButton getBoton0() {
		
		return boton0;
	}
	
	public JButton getBoton1() {
		
		return boton1;
	}
  
	public JButton getBoton2() {
		
		return boton2;
	}
  
	public JButton getBoton3() {
		
		return boton3;
	}
	
	public JButton getBoton4() {
		
		return boton4;
	}
  
	public JButton getBoton5() {
		
		return boton5;
	}
  
	public JButton getBoton6() {
		
		return boton6;
	}
	
	public JButton getBoton7() {
		
		return boton7;
	}
	
	public JButton getBoton8() {
		
		return boton8;
	}
	
	public JButton getBoton9() {
		
		return boton9;
	}
  
    public JLabel getEtiquetaMotivacion() {
    	return etiquetaMotivacion;
    }
  
    public JButton getBotonBorrado() {
		
		return botonBorrado;
	}
	public JButton getBotonIgual() {
		
		return botonIgual;
	}
	
	public JButton getBotonSumar() {
		
		return botonSumar;
	}
	
	public JButton getBotonRestar() {
		
		return botonRestar;
	}
	
	public JButton getBotonMultiplicar() {
		
		return botonMultiplicar;
	}

	public JButton getBotonDividir() {
	
	return botonDividir;
	}
	
	
	public JButton getOpcion1() {
		
		return opcion1;
	}
		
	public JButton getOpcion2() {
		
		return opcion2;
	}
 
	public JButton getOpcion3() {
		
		return opcion3;
	}
		
	public JButton getOpcion4() {
		
		return opcion4;
	}

	/*Estilo de la ventana si se equivoca*/
	public void estiloError() {
     /**Bea y Jose**/
	}

	/*Estilo de la ventana si se equivoca*/
	public void estiloAcierto() {
		 /**Bea y Jose**/		
 
	}
	
	public void establecerManejador(ManejadorEventos manejador) {
		botonSumar.addActionListener(manejador);
		botonSumar.setActionCommand("+");

		botonRestar.addActionListener(manejador);
		botonRestar.setActionCommand("-");

		botonMultiplicar.addActionListener(manejador);
		botonMultiplicar.setActionCommand("*");

		botonDividir.addActionListener(manejador);
		botonDividir.setActionCommand("/");

		botonIgual.addActionListener(manejador);
		botonIgual.setActionCommand("=");

		boton1.addActionListener(manejador);
		boton1.setActionCommand("1");
		boton2.addActionListener(manejador);
		boton2.setActionCommand("2");
		boton3.addActionListener(manejador);
		boton3.setActionCommand("3");
		boton4.addActionListener(manejador);
		boton4.setActionCommand("4");
		boton5.addActionListener(manejador);
		boton5.setActionCommand("5");
		boton6.addActionListener(manejador);
		boton6.setActionCommand("6");
		boton7.addActionListener(manejador);
		boton7.setActionCommand("7");
		boton8.addActionListener(manejador);
		boton8.setActionCommand("8");
		boton9.addActionListener(manejador);
		boton9.setActionCommand("9");
		boton0.addActionListener(manejador);
		boton0.setActionCommand("0");
		
		opcion1.addActionListener(manejador);
		opcion1.setActionCommand("OP1");
		opcion2.addActionListener(manejador);
		opcion2.setActionCommand("OP2");
		opcion3.addActionListener(manejador);
		opcion3.setActionCommand("OP3");
		opcion4.addActionListener(manejador);
		opcion4.setActionCommand("OP4");
		botonOn_Off.addActionListener(manejador);
		botonOn_Off.setActionCommand("ON");
		botonBorrado.addActionListener(manejador);
		botonBorrado.setActionCommand("BORRAR");

	}

	

	
	



}

