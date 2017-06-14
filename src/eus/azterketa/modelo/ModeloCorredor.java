package eus.azterketa.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import eus.azterketa.modelo.Conectar;
public class ModeloCorredor extends Conectar {

	public ModeloCorredor() {
		super();
	}

	public ArrayList<Corredor> selectAll() {
		ArrayList<Corredor> corredores = new ArrayList<Corredor>();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from corredor");

			while (rs.next()) {
				Corredor corredor = new Corredor();
				corredor.setId(rs.getInt("id"));
				corredor.setNombre(rs.getString("nombre"));
				corredor.setApellido(rs.getString("apellido"));
				corredor.setNombre_grupo(rs.getString("equipo"));
				corredores.add(corredor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corredores;
	}

	public Corredor selectById(int id) {
		Corredor corredor = null;
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from corredor where id=" + id);
			rs.next();

			corredor = new Corredor();
			corredor.setId(rs.getInt("id"));
			corredor.setNombre(rs.getString("nombre"));
			corredor.setApellido(rs.getString("apellido"));
			corredor.setNombre_grupo(rs.getString("nombre_grupo"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corredor;
	}

	public Corredor selectCorredor(String nombre,String apellido) {
		Corredor corredor = null;
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from corredor where nombre='" + nombre + "'and apellido='"+ apellido + "'");
			if (rs.next()) {
				corredor = new Corredor();
				corredor.setId(rs.getInt("id"));
				corredor.setNombre(rs.getString("nombre"));
				corredor.setApellido(rs.getString("apellido"));
				corredor.setNombre_grupo(rs.getString("nombre_grupo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return corredor;
	}

	public void borrarCorredor(String nombre, String apellido) {
		try {
			Statement st = super.getCn().createStatement();
			st.execute("DELETE FROM corredor " + " WHERE nombre = ('" + nombre + "') and apellido = ('"+ apellido +"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
