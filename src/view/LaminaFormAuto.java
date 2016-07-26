package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LaminaFormAuto extends JPanel {

	private JFormattedTextField id;
	private JTextField modelo;
	private JComboBox marca;
	private JColorChooser color;
	private JFormattedTextField anio;
	private JTextField propietario;
	private JFormattedTextField costo;
	private JRadioButton primeraManoTrue;
	private JRadioButton primeraManoFalse;
	private JButton botonAceptar;
	private JButton botonCancelar;
	ButtonGroup primeraMano;


	public LaminaFormAuto() {
		setLayout(new BorderLayout(10, 20));

		// Insertamos titulo
		JLabel titulo = new JLabel("Automovil", JLabel.CENTER);
		add(titulo, BorderLayout.NORTH);

		// Armamos formulario
		JPanel laminaFormulario = new JPanel();
		laminaFormulario.setLayout(new GridLayout(0, 2));
		// agregamos la laminaFormulario
		add(laminaFormulario, BorderLayout.CENTER);

		// id
		JLabel idLabel = new JLabel("Id", JLabel.LEFT);
		id = new JFormattedTextField(NumberFormat.getIntegerInstance());
		id.setEnabled(false);
		laminaFormulario.add(idLabel);
		laminaFormulario.add(id);

		// marca
		JLabel marcaLabel = new JLabel("Marca", JLabel.LEFT);
		String[] marcas = { "", "Ford", "Renault", "Audi", "Fiat", "Citroen" };
		marca = new JComboBox(marcas);
		marca.setSelectedIndex(0);
		laminaFormulario.add(marcaLabel);
		laminaFormulario.add(marca);

		// modelo
		JLabel modeloLabel = new JLabel("Modelo", JLabel.LEFT);
		modelo = new JTextField();
		laminaFormulario.add(modeloLabel);
		laminaFormulario.add(modelo);

		// anio
		JLabel anioLabel = new JLabel("Año", JLabel.LEFT);
		anio = new JFormattedTextField(NumberFormat.getIntegerInstance());
		laminaFormulario.add(anioLabel);
		laminaFormulario.add(anio);

		// propietario
		JLabel propietarioLabel = new JLabel("Propietario", JLabel.LEFT);
		propietario = new JTextField();
		laminaFormulario.add(propietarioLabel);
		laminaFormulario.add(propietario);

		// costo
		JLabel costoLabel = new JLabel("Costo", JLabel.LEFT);
		costo = new JFormattedTextField(NumberFormat.getNumberInstance());
		laminaFormulario.add(costoLabel);
		laminaFormulario.add(costo);


		// primera mano
		JPanel opcionesPrimeraMano = new JPanel();
		JLabel primeraManoLabel = new JLabel("Primera Mano", JLabel.LEFT);
		primeraMano = new ButtonGroup();
		primeraManoTrue = new JRadioButton("Si",true);
		primeraMano.add(primeraManoTrue);
		primeraManoFalse = new JRadioButton("No",false);
		primeraMano.add(primeraManoFalse);
		laminaFormulario.add(primeraManoLabel);
		opcionesPrimeraMano.add(primeraManoTrue);
		opcionesPrimeraMano.add(primeraManoFalse);
		laminaFormulario.add(opcionesPrimeraMano);

		// Insertamos botones
		JPanel botonera = new JPanel();
		botonAceptar = new JButton("Aceptar");
		botonera.add(botonAceptar);
		botonCancelar = new JButton("Cancelar");
		botonera.add(botonCancelar);
		add(botonera, BorderLayout.SOUTH);

	}

	//Getters y Setters
	public JTextField getModelo() {
		return modelo;
	}

	public void setModelo(JTextField modelo) {
		this.modelo = modelo;
	}

	public JComboBox getMarca() {
		return marca;
	}

	public void setMarca(JComboBox marca) {
		this.marca = marca;
	}

	public JFormattedTextField getAnio() {
		return anio;
	}

	public void setAnio(JFormattedTextField anio) {
		this.anio = anio;
	}

	public JTextField getPropietario() {
		return propietario;
	}

	public void setPropietario(JTextField propietario) {
		this.propietario = propietario;
	}

	public JFormattedTextField getCosto() {
		return costo;
	}

	public void setCosto(JFormattedTextField costo) {
		this.costo = costo;
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public void setBotonAceptar(JButton botonAceptar) {
		this.botonAceptar = botonAceptar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void setBotonCancelar(JButton botonCancelar) {
		this.botonCancelar = botonCancelar;
	}

	public JFormattedTextField getId() {
		return id;
	}

	public void setId(JFormattedTextField id) {
		this.id = id;
	}

	public JRadioButton getPrimeraManoTrue() {
		return primeraManoTrue;
	}

	public void setPrimeraManoTrue(JRadioButton primeraManoTrue) {
		this.primeraManoTrue = primeraManoTrue;
	}

	public JRadioButton getPrimeraManoFalse() {
		return primeraManoFalse;
	}

	public void setPrimeraManoFalse(JRadioButton primeraManoFalse) {
		this.primeraManoFalse = primeraManoFalse;
	}

	public ButtonGroup getPrimeraMano() {
		return primeraMano;
	}

	public void setPrimeraMano(ButtonGroup primeraMano) {
		this.primeraMano = primeraMano;
	}
	
	

}
