package clases.servicios;

import interfaces.InterfaceCRUD;


import org.hibernate.Session;
import org.hibernate.Transaction;

import sesion.manager.SesionManager;
import sup.clase.dao.SuperClaseDAO;
import tablas_Clases.Employees;


public class ServiciosCRUD implements InterfaceCRUD{
	
	private SuperClaseDAO objetoDao;
	
	public ServiciosCRUD(){
		objetoDao = new SuperClaseDAO();
	}
	
	public Object insertar(Object objeto){
		Transaction transaccion = null;
		Session sesion = SesionManager.getSesion();
		objetoDao.setSesion(sesion);
		try{
			transaccion = sesion.beginTransaction();
			objetoDao.insertar(objeto);
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
		}
		finally{
			objetoDao.cerrarSesion();
		}
		return objeto;
	}

	@Override
	public Object actualizar(Object objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object borrar(Object objeto) {
		Transaction transaccion = null;
		Session sesion = SesionManager.getSesion();
		objetoDao.setSesion(sesion);
		try{
			transaccion = sesion.beginTransaction();
			objetoDao.borrar(objeto);
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
		}
		finally{
			objetoDao.cerrarSesion();
		}
		return objeto;
	}

	@Override
	public Object leer(Class clase, Object id) {
		// TODO Auto-generated method stub

		Object objetoLeido =null;
		Transaction transaccion = null;
		try{
			Session s = SesionManager.getSesion();
			objetoDao.setSesion(s);
			transaccion = s.beginTransaction();
			objetoLeido = (Object)objetoDao.leer(clase,id);
			
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
		}
		finally{
			SesionManager.desconectarSesion();
			//SesionManager.cerrarSesion();
		}
		return objetoLeido;
	}

	
	public void desconectarServicio(){
		SesionManager.cerrarfactory();
	}
}
