package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import modelo.Conector;
import modelo.bean.Actividad;

public class ModeloActividad extends Conector{
	
	public ArrayList<Actividad> selectAll(){
		
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setFechaInicio(rs.getDate("fecha_Inicio"));
				actividad.setDiasSemana(rs.getString("dias_Semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_Participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				actividades.add(actividad);
			}
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return actividades;
		
	}
	
	public ArrayList<Actividad> buscar(String query){
		
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where nombre like ?");
			pst.setString(1, "%"+query+"%");
			ResultSet rs = pst.executeQuery();
			
			Actividad actividad = new Actividad();
			actividad.setId(rs.getInt("id"));
			actividad.setNombre(rs.getString("nombre"));
			actividad.setFechaInicio(rs.getDate("fechaInicio"));
			actividad.setDiasSemana(rs.getString("diasSemana"));
			actividad.setHoras(rs.getInt("horas"));
			actividad.setMaxParticipantes(rs.getInt("maxParticipantes"));
			actividad.setPrecio(rs.getDouble("precio"));

			actividades.add(actividad);
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return actividades;
		
	}
	
	public ArrayList<Actividad> selectAllConInscripciones(){
		
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setFechaInicio(rs.getDate("fecha_Inicio"));
				actividad.setDiasSemana(rs.getString("dias_Semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_Participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				
			}
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return null;
		
		
		
	}
	
	public ArrayList<Actividad> selectAllMasCarosQue(double precio){
		
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where precio > ?");
			pst.setDouble(1, precio);
			ResultSet rs = pst.executeQuery();
			
				while (rs.next()) {
				
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setFechaInicio(rs.getDate("fecha_Inicio"));
				actividad.setDiasSemana(rs.getString("dias_Semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_Participantes"));
				actividad.setPrecio(rs.getDouble("precio"));
				
				actividades.add(actividad);
			
			
		}
		
	}catch (SQLException e){
		
		e.printStackTrace();
		
	}
		
		return actividades;
		
	}
	
	public Actividad select(int id) {
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setFechaInicio(rs.getDate("fecha_Inicio"));
				actividad.setDiasSemana(rs.getString("dias_Semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_Participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				return actividad;
			}
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	public Actividad selectPrecio(int id) {
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select actividades.precio from actividades where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				
				Actividad actividad = new Actividad();
				actividad.setPrecio(rs.getDouble("precio"));

				return actividad;
			}
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	public ArrayList<Actividad> actividadesFiltradosPorPrecio (int min, int max){
		
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		
			try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where actividades.precio BETWEEN ? AND ?");
			pst.setInt(1, min);
			pst.setInt(2, max);
			ResultSet rs = pst.executeQuery();
			
				while (rs.next()) {
				
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setFechaInicio(rs.getDate("fecha_Inicio"));
				actividad.setDiasSemana(rs.getString("dias_Semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_Participantes"));
				actividad.setPrecio(rs.getDouble("precio"));
				
				actividades.add(actividad);
			
			
		}
		
	}catch (SQLException e){
		
		e.printStackTrace();
		
	}
		
		return actividades;
		
	}
	
	public void update(Actividad actividad) {
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE actividades "
					+ "SET nombre=?, dias_semana = ?, fecha_inicio=?, horas=?, max_participantes=?, precio=? "
					+ "WHERE id = ?");
			
			pst.setString(1, actividad.getNombre());
			pst.setString(2, actividad.getDiasSemana());
			pst.setDate(3, new java.sql.Date(actividad.getFechaInicio().getTime()));
			pst.setInt(4, actividad.getHoras());
			pst.setInt(5, actividad.getMaxParticipantes());
			pst.setDouble(6, actividad.getPrecio());
			pst.setInt(7, actividad.getId());
			pst.executeUpdate();

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

	}
	
	public void insert(Actividad actividad) {
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("insert into actividades (nombre, fecha_inicio, dias_semana, horas, max_participantes, precio) values (?, ?, ?, ?, ?, ?)");
			
			pst.setString(1, actividad.getNombre());
			pst.setDate(2, new java.sql.Date(actividad.getFechaInicio().getTime()));
			pst.setString(3, actividad.getDiasSemana());
			pst.setInt(4, actividad.getHoras());
			pst.setInt(5, actividad.getMaxParticipantes());
			pst.setDouble(6, actividad.getPrecio());

			pst.execute();

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	
	

}
