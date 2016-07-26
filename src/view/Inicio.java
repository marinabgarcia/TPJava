package view;

import javax.swing.JFrame;

import controller.Controller;

public class Inicio {

	public static void main(String[] args) {
		
		//Creo MarcoFormAuto
		MarcoFormAuto marcoFormAutos = new MarcoFormAuto();
		//Creo MarcoAutos y lo muestro
		MarcoAutos marcoAutos = new MarcoAutos();
		marcoAutos.setVisible(true);
		marcoAutos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creo controlador
		Controller controlador = new Controller(marcoAutos,marcoFormAutos);
		controlador.control();

	}

}
