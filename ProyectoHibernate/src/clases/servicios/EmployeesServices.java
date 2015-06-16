package clases.servicios;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sesion.manager.SesionManager;
import tablas_Clases.Employees;
import clases.dao.EmployeesDAO;

public class EmployeesServices extends ServiciosCRUD {
	
	private EmployeesDAO empleadoDao;
	
	
	
	public EmployeesServices(){
		empleadoDao = new EmployeesDAO();
	}
	
	/**
	 * Metodo que obtiene todos los empleados
	 * @return Devuelve una lista con los todos los empleados
	 */
	public List<Employees> obtenerEmpleados(){
		List<Employees> lista = null;
		Transaction transaccion = null;
		try{
			//obtener una sesion con el sesionManager
			Session s = SesionManager.getSesion();
			//esta secion la usara el employeesDao
			empleadoDao.setSesion(s);
			//inicio transaccion
			transaccion = s.beginTransaction();
			lista = empleadoDao.obtenerEmpleados();
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
		}
		finally{
			//SesionManager.desconectarSesion();
			//SesionManager.cerrarSesion();
			empleadoDao.cerrarSesion();
		}
		return lista;
	}
	
	/**
	 * Metodo para incrementar el salario a todos los empleados
	 * @return Devuelve un lista con todos los empleados a los que le ha incrementado el salario
	 */
	public List<Employees> incrementarSalario(){
		List<Employees> lista = null;
		Transaction transaccion = null;
		Iterator<Employees> it = null;
		Employees empleado = null;
		BigDecimal bd = new BigDecimal(1.2);
		try{
			//obtener una sesion con el sesionManager
			Session s = SesionManager.getSesion();
			//esta secion la usara el employeesDao
			empleadoDao.setSesion(s);
			//inicio transaccion
			transaccion = s.beginTransaction();
			lista = empleadoDao.obtenerEmpleados();
			it = lista.iterator();
			while(it.hasNext()){
				empleado = it.next();
				empleado.setSalary(empleado.getSalary().multiply(bd));
			}
			transaccion.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		return lista;
	}
	
	/**
	 * Metodo para obtener una lista de los empleados  de un departamento pasado como parametro
	 * @param departamento_id Es el ID del departamento del que se quiere obtener sus empleados
	 * @return Devuelve una lista de empleados con todos los empleados del departamento pasado como parametro
	 */
	public List<Employees> obtenerEmpleadosPorDepartamento(short departamento_id){
		List<Employees> lista = null;
		Transaction transaccion = null;
		try{
			Session s = SesionManager.getSesion();
			empleadoDao.setSesion(s);
			transaccion = s.beginTransaction();
			lista = empleadoDao.obtenerEmpleadosPorDepartamento(departamento_id);
			
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		
		return lista;
	}
	
	/**
	 * Metodo para obtener una lista con el empleado mejor pagado de cada departamento
	 * @return Devuelve una lista con el empleados mejor pagado de cada departamento
	 */
	public List<Employees> obtenerEmpleadosMejorPagadosPorDepartamento(){
		List<Employees> lista = null;
		
		Transaction transaccion = null;
		try{
			Session s = SesionManager.getSesion();
			empleadoDao.setSesion(s);
			transaccion = s.beginTransaction();
			lista = empleadoDao.getEmpleadosMejorPagadosPorDepartamento();
			
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		
		return lista;
	}
	
	/**
	 * Desconecta el servicio; cierra el SesionFactory
	 */
	public void desconectarServicio(){
		SesionManager.cerrarfactory();
	}

}
