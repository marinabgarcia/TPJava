package dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.AutoDAO;
import model.Auto;

public class AutoDAOJDBCImpl implements AutoDAO {

	private static AutoDAOJDBCImpl ref;
	private static String url;
	private static String username;
	private static String password;
	private static String driver;

	// Crear un unico objeto AutoDAO
	public static AutoDAOJDBCImpl getAutoDAO() throws IOException, ClassNotFoundException {
		if (ref == null)
			// it's ok, we can call this constructor
			ref = new AutoDAOJDBCImpl();
		return ref;
	}

	public AutoDAOJDBCImpl() throws IOException, ClassNotFoundException {
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("database.properties");
		props.load(in);
		in.close();
		driver = props.getProperty("jdbc.drivers");
		url = props.getProperty("jdbc.url");
		username = props.getProperty("jdbc.username");
		password = props.getProperty("jdbc.password");
		System.out.println(driver);
		Class.forName(driver);
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public List<Auto> getAll() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM auto";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(query);
		List<Auto> list = new ArrayList<Auto>();
		while (rs.next()) {
			Auto auto = new Auto();
			auto.setAnio(rs.getInt("anio"));
			auto.setCosto(rs.getDouble("costo"));
			auto.setId(rs.getLong("id"));
			auto.setMarca(rs.getString("marca"));
			auto.setModelo(rs.getString("modelo"));
			auto.setPrimeraMano(rs.getBoolean("primeraMano"));
			auto.setPropietario(rs.getString("propietario"));
			list.add(auto);
		}
		return list;
	}

	@Override
	public Auto getOne(Long id) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM auto where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		Auto auto = new Auto();
		if (rs.next()) {
			auto.setAnio(rs.getInt("anio"));
			auto.setCosto(rs.getDouble("costo"));
			auto.setId(rs.getLong("id"));
			auto.setMarca(rs.getString("marca"));
			auto.setModelo(rs.getString("modelo"));
			auto.setPrimeraMano(rs.getBoolean("primeraMano"));
			auto.setPropietario(rs.getString("propietario"));
		}
		return auto;
	}

	@Override
	public void insert(Auto auto) throws SQLException {
		Connection conn = getConnection();
		String query = "INSERT INTO auto (id,modelo,marca,anio,propietario,costo,primeraMano) VALUES (default,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, auto.getModelo());
		ps.setString(2, auto.getMarca());
		ps.setInt(3, auto.getAnio());
		ps.setString(4, auto.getPropietario());
		ps.setDouble(5, auto.getCosto());
		ps.setBoolean(6, auto.getPrimeraMano());
		ps.executeUpdate();

	}

	@Override
	public void update(Auto auto) throws SQLException {
		Connection conn = getConnection();
		String query = "UPDATE `autos`.`auto` SET `modelo` = ?,`marca` = ?,`anio` = ?,`propietario` = ?,`costo` = ?,`primeraMano` = ? WHERE `id` = ?;";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, auto.getModelo());
		ps.setString(2, auto.getMarca());
		ps.setInt(3, auto.getAnio());
		ps.setString(4, auto.getPropietario());
		ps.setDouble(5, auto.getCosto());
		ps.setBoolean(6, auto.getPrimeraMano());
		ps.setLong(7, auto.getId());
		ps.executeUpdate();

	}

	@Override
	public void eliminar(Long id) throws SQLException {
		Connection conn = getConnection();
		String query = "DELETE FROM `autos`.`auto` WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, id);
		ps.executeUpdate();

	}

}
