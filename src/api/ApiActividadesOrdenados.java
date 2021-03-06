package api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONStringer;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;
import modelo.util.ActividadesComparatorAsc;
import modelo.util.ActividadesComparatorDesc;
import modelo.util.ActividadesComparatorFechaInicio;

/**
 * Servlet implementation class ApiActividadesOrdenados
 */
@WebServlet("/ApiActividadesOrdenados")
public class ApiActividadesOrdenados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiActividadesOrdenados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orden = request.getParameter("orden");
		String campo = request.getParameter("campo");
		ModeloActividad modeloActividad = new ModeloActividad();
		ArrayList<Actividad> actividades = modeloActividad.selectAll();
		
		if (campo.equals("precio")) {
			if (orden.equals("asc")) {
				actividades.sort(new ActividadesComparatorAsc());
				}else if(orden.equals("desc")){
					actividades.sort(new ActividadesComparatorDesc());
				}
		}else if (campo.equals("fechaInicio")) {
			if () {
				
			}
		}
		
		if (orden.equals("asc")) {
		actividades.sort(new ActividadesComparatorAsc());
		}else if(orden.equals("desc")){
			actividades.sort(new ActividadesComparatorDesc());
		}
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");

		String jsonString = JSONStringer.valueToString(actividades);
		
	    PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
		out.print(jsonString);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
