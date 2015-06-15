package clases.dao;

import org.hibernate.Session;

import sup.clase.dao.SuperClaseDAO;

public class DepartmentsDAO extends SuperClaseDAO {

	public void setSesion(Session sesion){
		super.setSesion(sesion);
	}
	
	public void cerrarSesion(){
		super.cerrarSesion();
	}
}
