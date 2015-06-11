package clases.servicios;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sesion.manager.SesionManager;
import tablas_Clases.Employees;
import clases.dao.EmployeesDAO;

public class EmployeesServices {
	
	private EmployeesDAO empleadoDao;
	
	
	
	public EmployeesServices(){
		empleadoDao = new EmployeesDAO();
	}
	
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
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		return lista;
	}
	
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
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		return lista;
	}
	
	public boolean insertarEmpleado(Employees empleado){
		boolean res = false;
		Transaction transaccion = null;
		try{
			Session s = SesionManager.getSesion();
			empleadoDao.setSesion(s);
			transaccion = s.beginTransaction();
			res = empleadoDao.insertar(empleado);
			if (res)
				transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		
		return res;
	}
	
	public Employees read(int id){
		Employees empleado =null;
		Transaction transaccion = null;
		try{
			Session s = SesionManager.getSesion();
			empleadoDao.setSesion(s);
			transaccion = s.beginTransaction();
			empleado = (Employees)empleadoDao.read(id);
			
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			SesionManager.cerrarSesion();
		}
		return empleado;
	}
	
	
	public void desconectarServicio(){
		SesionManager.cerrarfactory();
	}

}
