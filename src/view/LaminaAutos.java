package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class LaminaAutos extends JPanel {

	DefaultTableModel modelAutos;
	private JTable tablaAutos;
	private JButton botonAgregar;
	private JButton botonModificar;
	private JButton botonEliminar;

	public LaminaAutos() {
		setLayout(new BorderLayout(10, 10));

		// Insertamos titulo
		JLabel titulo = new JLabel("ABM Automoviles", JLabel.CENTER);
		add(titulo, BorderLayout.NORTH);

		// Insertamos tabla
		String[] nombresCabecera = { "Id", "Marca", "Modelo", "Año", "Propietario", "Costo", "Primera mano" };
		//Inicializamos modelo solo con los nombre de cabecera sin datos
		modelAutos = new DefaultTableModel(null,nombresCabecera);
		// Creamos el JTable
		tablaAutos = new JTable(modelAutos) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		tablaAutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(tablaAutos);
		add(scrollPane, BorderLayout.CENTER);

		// Insertamos botones
		JPanel botonera = new JPanel();
		botonAgregar = new JButton("Agregar");
		botonera.add(botonAgregar);
		botonModificar = new JButton("Modificar");
		botonera.add(botonModificar);
		botonEliminar = new JButton("Eliminar");
		botonera.add(botonEliminar);
		add(botonera, BorderLayout.SOUTH);

	}

	// Getters y Setters
	public JTable getTablaAutos() {
		return tablaAutos;
	}

	public void setTablaAutos(JTable tablaAutos) {
		this.tablaAutos = tablaAutos;
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	public void setBotonAgregar(JButton botonAgregar) {
		this.botonAgregar = botonAgregar;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public void setBotonModificar(JButton botonModificar) {
		this.botonModificar = botonModificar;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}

	public DefaultTableModel getModelAutos() {
		return modelAutos;
	}

	public void setModelAutos(DefaultTableModel modelAutos) {
		this.modelAutos = modelAutos;
	}

}
