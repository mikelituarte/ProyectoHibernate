package clases.dao;

import java.util.Iterator;
import java.util.List;

import interfaces.InterfaceDAO;

import org.hibernate.Session;

import sup.clase.dao.SuperClaseDAO;
import tablas_Clases.Departments;
import tablas_Clases.Employees;

public class EmployeesDAO extends SuperClaseDAO implements InterfaceDAO {

	
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

	@Override
	public boolean insertar(Object arg) {
		// TODO Auto-generated method stub
		Employees e = (Employees)arg;
		//super.getSesion().save(e);*/
		
		int res =0;
		return true;
	}

	@Override
	public Object actualizar(Object arg) {
		// TODO Auto-generated method stub
		Employees e = (Employees)arg;
		//super.getSesion().createSQLQuery(queryString)
		return false;
	}

	@Override
	public boolean borrar(Object arg) {
		// TODO Auto-generated method stub
		boolean r = true;
		Employees e = (Employees)arg;
		super.getSesion().createSQLQuery("DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = 184");
		return false;
	}

	@Override
	public Object read(Object id) {
		// TODO Auto-generated method stub
		int i = (Integer)id;
		Employees empleado = null;
		List<Employees> lista = super.getSesion().createSQLQuery("SELECT * FROM EMPLOYEES where EMPLOYEE_ID ="+i).addEntity(Employees.class).list();
		Iterator it = lista.iterator();
		if(it.hasNext())
			empleado = (Employees)it.next();
		return empleado;
	}
	
	public List<Employees> getEmpleadosMejorPagadosPorDepartamento(){
		List<Employees> listaEmpleados = null;
		List<Departments> listaDepartamentos = null;
		
		
		
		
		return null;
	}
	
}
