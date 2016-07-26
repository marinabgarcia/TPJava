package view;

import javax.swing.JFrame;

public class MarcoFormAuto extends JFrame {

	private LaminaFormAuto lamina;

	public MarcoFormAuto() {
		setSize(300, 300);
		setLocation(400, 100);
		setTitle("Registro de Automoviles");

		// Agregamos la lamina
		lamina = new LaminaFormAuto();
		add(lamina);
	}

	public LaminaFormAuto getLamina() {
		return lamina;
	}

	public void setLamina(LaminaFormAuto lamina) {
		this.lamina = lamina;
	}

}
