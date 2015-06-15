package clases.dao;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;

import sup.clase.dao.SuperClaseDAO;
import tablas_Clases.Departments;
import tablas_Clases.Employees;

public class EmployeesDAO extends SuperClaseDAO {

	
	//private Session sesion;//esta sesion sera la asignada desde un servicio
	
	
	public void setSesion(Session sesion){
		super.setSesion(sesion);
	}
	
	public void cerrarSesion(){
		super.cerrarSesion();
	}
	
	public List<Employees> obtenerEmpleados(){
		@SuppressWarnings("unchecked")
		List<Employees> lista = super.getSesion().createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();
		return lista;
	}
	
	public List<Employees> obtenerEmpleadosPorDepartamento(Object departamento){
		int deprt = (Integer)departamento;
		List<Employees> lista = super.getSesion().createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = "+ deprt).addEntity(Employees.class).list();
		return lista;
	}
	
	public List<Employees> getEmpleadosMejorPagadosPorDepartamento(){
		List<Employees> listaEmpleados = null;
		List<Departments> listaDepartamentos = null;
		return null;
	}
	
}
