package dao;

import java.util.ArrayList;
import java.util.List;

import model.Auto;

public class AutoDAO {

	static List<Auto> listaAutos = new ArrayList<Auto>();

	private AutoDAO() {
		listaAutos.add(new Auto(1L, "Clio", "Renault", "white", 1999, "Pedro Perez", (double) 40000, true));
	}

	// Crear un unico objeto AutoDAO
	public static AutoDAO getAutoDAO() {
		if (ref == null)
			// it's ok, we can call this constructor
			ref = new AutoDAO();
		return ref;
	}

	private static AutoDAO ref;

	public List<Auto> getAll() {
		return listaAutos;
	}

	public Auto getOne(Long id) {
		for (Auto auto : listaAutos) {
			if (auto.getId() == id) {
				return auto;
			}
		}
		return null;
	}

	public void insert(Auto auto) {
		Long ultimoId = (long) listaAutos.size();
		auto.setId(ultimoId + 1);
		listaAutos.add(auto);
	}

	public void update(Auto autoModificado) {
		for (int i = 0; i < listaAutos.size(); i++) {
			if (listaAutos.get(i).getId() == autoModificado.getId()) {
				listaAutos.set(i, autoModificado);
				break;
			}
		}
	}

	public void eliminar(Long id) {
		for (int i = 0; i < listaAutos.size(); i++) {
			if (listaAutos.get(i).getId() == id) {
				listaAutos.remove(i);
				break;
			}
		}
	}
}
