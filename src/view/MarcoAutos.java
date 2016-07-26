package view;

import javax.swing.JFrame;

public class MarcoAutos extends JFrame {

	private LaminaAutos lamina;
	
	public MarcoAutos(){
		setSize(600,300);
		setLocation(400,100);
		setTitle("Registro de Automoviles");
		
		//Agregamos la lamina
		lamina = new LaminaAutos();
		add(lamina);
	}

	public LaminaAutos getLamina() {
		return lamina;
	}

	public void setLamina(LaminaAutos lamina) {
		this.lamina = lamina;
	}
	
}

