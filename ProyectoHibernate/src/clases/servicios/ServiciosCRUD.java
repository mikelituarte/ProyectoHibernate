package clases.servicios;

import java.io.Serializable;

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
	
	/**
	 * Inserta el objeto pasado como parametro en la BBDD y retorna el objeto Insertado
	 */
	@Override
	public Object insertar(Object objeto){
		Transaction transaccion = null;
		Session sesion = SesionManager.getSesion();
		objetoDao.setSesion(sesion);
		try{
			transaccion = sesion.beginTransaction();
			//objetoDao.insertar(objeto);
			objetoDao.getSesion().save(objeto);
			transaccion.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			transaccion.rollback();
		}
		finally{
			objetoDao.cerrarSesion();
		}
		return objeto;
	}

	/**
	 * Actualiza el objeto pasado como parametro de la BBDD, retorna el objeto Actualizado
	 */
	@Override
	public Object actualizar(Object objeto) {
		Transaction transaccion = null;
		Session sesion = SesionManager.getSesion();
		objetoDao.setSesion(sesion);
		try{
			transaccion = sesion.beginTransaction();
			objetoDao.getSesion().saveOrUpdate(objeto);
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

	/**
	 * Borra el objeto pasado como parametro de la BBDD, retorna el objeto Borrado
	 */
	@Override
	public Object borrar(Object objeto) {
		Transaction transaccion = null;
		Session sesion = SesionManager.getSesion();
		objetoDao.setSesion(sesion);
		try{
			transaccion = sesion.beginTransaction();
			//objetoDao.borrar(objeto);
			objetoDao.getSesion().delete(objeto);
			transaccion.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			transaccion.rollback();
		}
		finally{
			objetoDao.cerrarSesion();
		}
		return objeto;
	}

	/**
	 * Obtiene un registro de la BBDD dado su tabla (.class) y su identificador
	 * Retorna el objeto leido de la BBDD
	 */
	@Override
	public Object leer(Class clase, Object id) {
		// TODO Auto-generated method stub

		Object objetoLeido =null;
		Transaction transaccion = null;
		try{
			Session s = SesionManager.getSesion();
			objetoDao.setSesion(s);
			transaccion = s.beginTransaction();
			//objetoLeido = (Object)objetoDao.leer(clase,id);
			objetoLeido = objetoDao.getSesion().get(clase, (Serializable)id);
			
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

	/**
	 * Desconecta el servicio (cierra el SesionFactory)
	 */
	public void desconectarServicio(){
		SesionManager.cerrarfactory();
	}
}
