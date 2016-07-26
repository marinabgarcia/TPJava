package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.AutoDAO;
import model.Auto;
import view.MarcoAutos;
import view.MarcoFormAuto;

public class Controller {

	private MarcoAutos marcoPrincipal;
	private MarcoFormAuto formulario;
	private WindowAdapter windowListener;
	private ActionListener actionListenerBotonAgregar;
	private ActionListener actionListenerBotonAceptar;
	private ActionListener actionListenerBotonModificar;
	private ActionListener actionListenerBotonEliminar;
	private ActionListener actionListenerBotonCancelar;

	/**
	 * Constructor del Controller
	 * 
	 * @param marco
	 * @param formulario
	 */
	public Controller(MarcoAutos marco, MarcoFormAuto formulario) {
		this.marcoPrincipal = marco;
		this.formulario = formulario;
	}

	/**
	 * Metodo control. Este metodo se inicia cuando inicia el programa.
	 */
	public void control() {

		// oyente ante la apertura del marco principal
		windowListener = new WindowAdapter() {
			public void windowOpened(WindowEvent event) {
				recargar();
			}

		};
		marcoPrincipal.addWindowListener(windowListener);

		// oyente para el boton AGREGAR
		actionListenerBotonAgregar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Vaciar los valores de auto en los componentes de la interfaz
				formulario.getLamina().getId().setValue(null);
				formulario.getLamina().getAnio().setValue(null);
				formulario.getLamina().getCosto().setText("");
				formulario.getLamina().getMarca().setSelectedItem("");
				formulario.getLamina().getModelo().setText("");
				formulario.getLamina().getPropietario().setText("");
				formulario.getLamina().getPrimeraManoTrue().setSelected(true);

				// Mostrar formulario
				formulario.setVisible(true);
				formulario.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		};
		marcoPrincipal.getLamina().getBotonAgregar().addActionListener(actionListenerBotonAgregar);

		// oyente para el boton MODIFICAR
		actionListenerBotonModificar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Obtengo el id de la fila seleccionada en la tabla
				Long id = (Long) marcoPrincipal.getLamina().getTablaAutos().getModel()
						.getValueAt(marcoPrincipal.getLamina().getTablaAutos().getSelectedRow(), 0);
				// Obtengo el auto que corresponde con ese id
				Auto autoAModificar = AutoDAO.getAutoDAO().getOne(id);
				// Cargar los valores de auto en los componentes de la interfaz
				formulario.getLamina().getId().setValue(autoAModificar.getId());
				formulario.getLamina().getAnio().setValue(autoAModificar.getAnio());
				formulario.getLamina().getCosto().setText(autoAModificar.getCosto().toString());
				formulario.getLamina().getMarca().setSelectedItem(autoAModificar.getMarca());
				formulario.getLamina().getModelo().setText(autoAModificar.getModelo());
				formulario.getLamina().getPropietario().setText(autoAModificar.getPropietario());
				if (autoAModificar.getPrimeraMano())
					formulario.getLamina().getPrimeraManoTrue().setSelected(true);
				else
					formulario.getLamina().getPrimeraManoTrue().setSelected(false);

				// Hago visible el marco
				formulario.setVisible(true);
				formulario.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		};
		marcoPrincipal.getLamina().getBotonModificar().addActionListener(actionListenerBotonModificar);

		// oyente para el boton ELIMINAR
		actionListenerBotonEliminar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Obtengo el id de la fila seleccionada en la tabla
				Long id = (Long) marcoPrincipal.getLamina().getTablaAutos().getModel()
						.getValueAt(marcoPrincipal.getLamina().getTablaAutos().getSelectedRow(), 0);
				// Elimino el auto que corresponde con ese id
				AutoDAO.getAutoDAO().eliminar(id);

				recargar();
			}
		};
		marcoPrincipal.getLamina().getBotonEliminar().addActionListener(actionListenerBotonEliminar);

		// oyente para el boton ACEPTAR del formulario
		actionListenerBotonAceptar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Creo objeto auto para almacenar los valores de la intefaz
				Auto auto = new Auto();
				// Valido ingreso de datos
				if (validar()) {
					// Cargo en auto todos los valores de la interfaz
					auto.setId((Long) formulario.getLamina().getId().getValue());
					auto.setAnio(((Number) formulario.getLamina().getAnio().getValue()).intValue());
					auto.setCosto(Double.valueOf(formulario.getLamina().getCosto().getText()));
					auto.setMarca((String) formulario.getLamina().getMarca().getSelectedItem());
					auto.setModelo(formulario.getLamina().getModelo().getText());
					auto.setPropietario(formulario.getLamina().getPropietario().getText());
					if (formulario.getLamina().getPrimeraManoTrue().isSelected())
						auto.setPrimeraMano(true);
					else
						auto.setPrimeraMano(false);

					// Decido si debo actualizar o crear un nuevo auto en base
					// al id
					if (auto.getId() == null)
						AutoDAO.getAutoDAO().insert(auto);
					else
						AutoDAO.getAutoDAO().update(auto);
					// Ocultar marco formulario
					formulario.dispose();
					// Recargar tabla para reflejar los cambios
					recargar();
				}
			}
		};
		formulario.getLamina().getBotonAceptar().addActionListener(actionListenerBotonAceptar);
		
		// oyente para el boton CANCELAR del formulario
		actionListenerBotonCancelar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
					// Ocultar marco formulario
					formulario.dispose();
			}
		};
		formulario.getLamina().getBotonCancelar().addActionListener(actionListenerBotonCancelar);

	}

	/**
	 * Metodo para recargar tabla
	 */
	private void recargar() {
		// Vacio la tabla
		while (marcoPrincipal.getLamina().getModelAutos().getRowCount() > 0)
			marcoPrincipal.getLamina().getModelAutos().removeRow(0);
		// Obtengo todos los valores registrados
		List<Auto> lista = AutoDAO.getAutoDAO().getAll();
		// Inserto cada valor como fila de tabla
		for (Auto auto : lista) {
			Object[] fila = new Object[7];
			fila[0] = auto.getId();
			fila[1] = auto.getMarca();
			fila[2] = auto.getModelo();
			fila[3] = auto.getAnio();
			fila[4] = auto.getPropietario();
			fila[5] = auto.getCosto();
			fila[6] = auto.getPrimeraMano();
			marcoPrincipal.getLamina().getModelAutos().addRow(fila);
		}
	}

	/**
	 * Metodo para Validar datos
	 * @return
	 */	
	private Boolean validar() {
		String mensaje = "";
		// Valido que todos los campos esten completos
		if (formulario.getLamina().getAnio().getValue() == null || formulario.getLamina().getCosto().getValue() == null
				|| formulario.getLamina().getMarca().getSelectedItem() == null
				|| formulario.getLamina().getMarca().getSelectedItem() == ""
				|| formulario.getLamina().getModelo().getText() == null
				|| formulario.getLamina().getModelo().getText() == ""
				|| formulario.getLamina().getPropietario().getText() == null
				|| formulario.getLamina().getPropietario().getText() == ""
				|| (!formulario.getLamina().getPrimeraManoTrue().isSelected()
						&& !formulario.getLamina().getPrimeraManoFalse().isSelected())) {
			mensaje += "Debe completar todos los campos. ";
		}
		if (formulario.getLamina().getAnio().getValue() != null
				&& (((Number) formulario.getLamina().getAnio().getValue()).intValue() > new GregorianCalendar()
						.get(GregorianCalendar.YEAR)
						|| ((Number) formulario.getLamina().getAnio().getValue()).intValue() < 1900)) {
			mensaje += "El año no puede ser mayor que el actual ni menor a 4 digitos";
		}
		if (mensaje != "") {
			JOptionPane.showMessageDialog(formulario, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}
}