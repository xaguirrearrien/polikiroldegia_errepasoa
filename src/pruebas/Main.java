package pruebas;

import java.util.ArrayList;

import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.dao.ModeloActividad;
import modelo.dao.ModeloInscripcion;

public class Main {

	public static void main(String[] args) {
		
		/*ModeloActividad ma = new ModeloActividad();
		
		ArrayList<Actividad> actividades = ma.selectAll();
		
		System.out.println(actividades);*/
		
		
		ModeloInscripcion mi = new ModeloInscripcion();
		
		ArrayList<Inscripcion> inscripciones = mi.selectAll();
		
		System.out.println(inscripciones);

	}

}
