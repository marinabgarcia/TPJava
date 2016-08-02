package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.AutoDAO;
import model.Auto;

public class AutoDAOBasicImpl implements AutoDAO{

	static List<Auto> listaAutos = new ArrayList<Auto>();

	private AutoDAOBasicImpl() {
		listaAutos.add(new Auto(1L, "Clio", "Renault", "white", 1999, "Pedro Perez", (double) 40000, true));
	}

	// Crear un unico objeto AutoDAO
	public static AutoDAOBasicImpl getAutoDAO() {
		if (ref == null)
			// it's ok, we can call this constructor
			ref = new AutoDAOBasicImpl();
		return ref;
	}

	private static AutoDAOBasicImpl ref;

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
