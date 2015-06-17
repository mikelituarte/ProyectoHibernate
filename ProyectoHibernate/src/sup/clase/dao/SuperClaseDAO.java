package sup.clase.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;



public class SuperClaseDAO {


	private Session sesion;

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}
	
	public void cerrarSesion(){
		this.sesion.disconnect();
		this.sesion.close();
	}
	
}
