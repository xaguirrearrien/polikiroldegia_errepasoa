package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;

public class ModeloInscripcion extends Conector{
	
	public ArrayList<Inscripcion> selectAll(){
		
		ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from inscripciones");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Inscripcion inscripcion = new Inscripcion();
				inscripcion.setId(rs.getInt("id"));
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				/*usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));*/
				inscripcion.setUsuario(usuario);
				
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				/*actividad.setNombre(rs.getString("nombre"));
				actividad.setFechaInicio(rs.getDate("fecha_Inicio"));
				actividad.setDiasSemana(rs.getString("dias_Semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_Participantes"));
				actividad.setPrecio(rs.getDouble("precio"));*/
				inscripcion.setActividad(actividad);

				inscripciones.add(inscripcion);
			}
			
			return inscripciones;
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return inscripciones;
		
	}
	
	
	public ArrayList<Inscripcion> getInscripcionesDeActividad(int idActividad){
		
		ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from inscripciones");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Inscripcion inscripcion = new Inscripcion();
				inscripcion.setId(rs.getInt("id"));
				
			
			}
			
			return inscripciones;
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return inscripciones;
		
	}

}
