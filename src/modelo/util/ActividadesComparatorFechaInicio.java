package modelo.util;

import java.util.Comparator;

import modelo.bean.Actividad;

public class ActividadesComparatorFechaInicio implements Comparator<Actividad> {
	
	@Override
	public int compare(Actividad o1, Actividad o2) {
		
		if(o2.getFechaInicio(). > o1.getFechaInicio()) {
			return 1;
		}else if(o2.getFechaInicio() < o1.getFechaInicio()) {
			return -1;
		}else {
			return 0;
		}
			
	}

}
