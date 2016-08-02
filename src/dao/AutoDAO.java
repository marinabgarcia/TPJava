package dao;

import java.util.List;

import model.Auto;

public interface AutoDAO {
	
	public List<Auto> getAll() throws Exception;
	public Auto getOne(Long id) throws Exception;
	public void insert(Auto auto) throws Exception;
	public void update(Auto autoModificado) throws Exception;
	public void eliminar(Long id) throws Exception;

}
