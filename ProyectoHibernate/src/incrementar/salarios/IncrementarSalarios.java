package incrementar.salarios;





import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import tablas_Clases.Employees;

public class IncrementarSalarios {

	private static Session sesion;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	private static Transaction transaction;
	private static Connection conexion;
	
	/**
	 * Constructor, establece los valores iniciales para la conexion a la base de datos
	 */
	public IncrementarSalarios(){
		//Cargo la configuración: MAPPING entre Tablas y Objetos así como La descripción de la base de de datos
    	//Dicho de otra forma: cargamos en memoria en la clase Configuration el hibernate.cfg.xml
    	configuration = new Configuration().configure();
    	//Preparo a un objeto, que será el encargado de generarme el estado de comunicación con la base de datos
    	//StandardServiceRegistryBuilder se preconfigura el entorno a emplear
    	builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	
    	//Ahora sí, obtengo el objeto SessionFactory, a partir de la anterior clase /servicio
    	//que ya es la clase que encapsula al Pool y demás recursos físicos
    	factory = configuration.buildSessionFactory(builder.build());//Solo se hace una vez en cada programa
    	
    	//Ahora ya con sesion, obtengo y manejo conexiones que me va dando SessionFactory
    	sesion = factory.openSession(); //Se hace al menos una vez
    	//Session session = factory.getCurrentSession(); // para obtener la session actual y se hace cada vez que quiera operar sobre la BBDD
    	conexion = sesion.disconnect();
	}
	
	/**
	 * Activa la sesion asiganando al atributo sesion el valor de la sesion actual
	 */
	private static void activarSesion(){
		//sesion.reconnect(conexion);
		//sesion = factory.getCurrentSession();
		if(!sesion.isConnected()){
			sesion = factory.getCurrentSession();
		}
	}
	
	/**
	 * Desconexta la sesion
	 */
	private static void cerrarSesion(){
		conexion = sesion.disconnect();
	}
	
	/**
	 * Cierra la sesion y el factory
	 */
	public static void desconectarBBDD(){
		//sesion.disconnect();
		sesion.close();
		factory.close();
	}
	
	
	
	/**
	 * Incrementa el salario de los empleados del departamentos de Ventas en un 20%
	 */
	public static void incrementarSalario20(){
		BigDecimal bd = new BigDecimal(1.2);
		try 
    	{
			//obtenemos los Empleados...
			activarSesion();
	    	transaction = sesion.beginTransaction();
	    	@SuppressWarnings("unchecked")									
	    	List<Employees> lista = sesion.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE 'Sales')").addEntity(Employees.class).list();
	    	//aumentamos el sueldo...	
			Iterator<Employees> it = lista.iterator();
			Employees empleado;
			while (it.hasNext())
			{
				empleado = it.next();
				empleado.setSalary(empleado.getSalary().multiply(bd));
				System.out.println(empleado);
				//sesion.saveOrUpdate(empleado);//no hace falta porque esta en persistent
				
			}
	    	transaction.commit();
    	}
    	catch (Exception e)
    	{
    		transaction.rollback();//si algo ha ido mal, deshago la transacción
    	}
		finally{
			cerrarSesion();
			
		}
	}
	 
	 /**
	  * Decrementa el salario de los empleados del departamentos de Ventas en un 20%
	  */
	 public static void decrementarSalario20(){
		BigDecimal bd = new BigDecimal(0.8);
		try 
    	{
			//obtenemos los Empleados...
			activarSesion();
	    	transaction = sesion.beginTransaction();
	    	@SuppressWarnings("unchecked")									
	    	List<Employees> lista = sesion.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE 'Sales')").addEntity(Employees.class).list();
	    	//aumentamos el sueldo...	
			Iterator<Employees> it = lista.iterator();
			Employees empleado;
			while (it.hasNext())
			{
				empleado = it.next();
				empleado.setSalary(empleado.getSalary().multiply(bd));
				System.out.println(empleado);
				//sesion.saveOrUpdate(empleado);//no hace falta porque esta en persistent
				
			}
	    	transaction.commit();
    	}
    	catch (Exception e)
    	{
    		transaction.rollback();//si algo ha ido mal, deshago la transacción
    	}
		finally{
			cerrarSesion();
			
		}
	}
	
	
}
