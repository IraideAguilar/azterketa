package eus.azterketa.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloClasificacion extends Conectar {

	public ModeloClasificacion() {
		super();
	}

	public void borraClasificacion(int corredorId) {
			try {
				Statement st = super.getCn().createStatement();
				st.execute("DELETE FROM clasificacion " + " WHERE id_corredor = ('" + corredorId + "')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
		public void insertPosicion(Clasificacion clasificacion) {
			
					try {
						PreparedStatement ps = this.cn
								.prepareStatement("insert into clasificacion (id_etapa,id_corredor,posicion) values(?,?,?)");
						ps.setInt(1, clasificacion.getId_etapa());
						ps.setInt(2, clasificacion.getId_corredor());
						ps.setInt(3, clasificacion.getPosicion());
						ps.execute();

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		
		public ArrayList<Clasificacion> selectClasificacion() {
			ArrayList<Clasificacion> clasificaciones = new ArrayList<Clasificacion>();
			try {
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery("select * from clasificacion");
				while (rs.next()) {
					Clasificacion clasificacion = new Clasificacion();
					clasificacion.setId_corredor(rs.getInt("id_corredor"));
					clasificacion.setId_etapa(rs.getInt("id_etapa"));
					clasificacion.setPosicion(rs.getInt("posicion"));
					
					clasificaciones.add(clasificacion);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return clasificaciones;
		}
		
	}

