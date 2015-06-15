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
	
	public Object insertar(Object obj){
		 obj = sesion.save(obj);
		return obj;
	}
	
	public Object borrar(Object obj){
		sesion.delete(obj);
		return obj;
	}
	
	
	public Object leer(Class clase, Object clave){
		//Object objetoDevuelto = sesion.get(objeto.getClass(),clave);
		return this.sesion.get(clase, (Serializable)clave);
	}
	
}
