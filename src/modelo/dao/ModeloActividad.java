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
				/*actividad.setId(rs.getInt("id"));
				/*actividad.setNombre(rs.getString("nombre"));
				actividad.setFechaInicio(rs.getDate("fecha_Inicio"));
				actividad.setDiasSemana(rs.getString("dias_Semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_Participantes"));*/
				actividad.setPrecio(rs.getDouble("precio"));

				return actividad;
			}
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	
	

}
