package clases.dao;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;

import sup.clase.dao.SuperClaseDAO;
import tablas_Clases.Departments;
import tablas_Clases.Employees;

public class EmployeesDAO extends SuperClaseDAO {

		
	/**
	 * Asigna la sesion a la SuperClaseDAO
	 */
	public void setSesion(Session sesion){
		super.setSesion(sesion);
	}
	
	/**
	 * Cierra la sesion de la SuperClaseDAO
	 */
	public void cerrarSesion(){
		super.cerrarSesion();
	}
	
	/**
	 * Obtiene de la BBDD la lista de todos los empleados de la tabla Employees
	 * @return Devuelve una lista<Employees> con todos los empleados de la tabla Employees
	 */
	public List<Employees> obtenerEmpleados(){
		@SuppressWarnings("unchecked")
		List<Employees> lista = super.getSesion().createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();
		return lista;
	}
	
	/**
	 * Obtiene de la BBDD una lista con los empleados de un departamento pasado como parametro
	 * @param departamento_id Es el ID del departamento que se usara para returnar todos sus empleados
	 * @return Devuelve una Lista<Empleados> del departamento pasado como parametro
	 */
	public List<Employees> obtenerEmpleadosPorDepartamento(short departamento_id){
		//int deprt = (Integer)departamento;
		@SuppressWarnings("unchecked")
		List<Employees> lista = super.getSesion().createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = "+ departamento_id).addEntity(Employees.class).list();
		return lista;
	}
	
	/**
	 * Obtiene de la BBDD una lista  con los empleados mejor pagados de cada departamentos
	 * @return Devueleve un List<Empleados> que contiene el empleado mejor pagado de cada de departamento
	 */
	public List<Employees> getEmpleadosMejorPagadosPorDepartamento(){
		@SuppressWarnings("unchecked")
		List<Employees> listaEmpleados =  super.getSesion().createSQLQuery("SELECT * FROM employees WHERE(department_id, salary) IN (SELECT department_id, MAX(salary) FROM employees GROUP BY department_id)").addEntity(Employees.class).list();
		return listaEmpleados;
	}
	
}
