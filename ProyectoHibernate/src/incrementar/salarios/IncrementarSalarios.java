package incrementar.salarios;





import java.math.BigDecimal;
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
	private  static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	private static Transaction transaction;
	
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
    	//sesion.disconnect();
	}
	
	private static void obtenerSesion(){
		sesion = factory.getCurrentSession();
	}
	
	private static void cerrarSesion(){
		sesion.disconnect();
	}
	
	public static void desconectarBBDD(){
		sesion.disconnect();
		sesion.close();
		factory.close();
	}
	
	public static void obtenerEmpleadosVentas(){
		//List<Employees> lista = null;
		System.out.println("AAAAAAAAAAAAAAA");
		//obtenerSesion();
    	transaction = sesion.beginTransaction();
    	@SuppressWarnings("unchecked")									
    	List<Employees> lista = sesion.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE 'Sales')").addEntity(Employees.class).list();
    	
		Iterator<Employees> it = lista.iterator();
		Employees empleado;
		while (it.hasNext())
		{
			empleado = it.next();
			System.out.println(empleado);
		}
		cerrarSesion();

	}
	
	/*private static void aumentarSueldo(List<Employees> list){
		BigDecimal bd = new BigDecimal(1.2);
		Iterator<Employees> it = list.iterator();
		Employees empleado;
		while (it.hasNext())
		{
			empleado = it.next();
			empleado.setSalary(empleado.getSalary().multiply(bd));
		}
	}*/
	
	
	public static void incrementarSalario20(){
		BigDecimal bd = new BigDecimal(1.2);
		try 
    	{
			//obtenemos los Empleados...
			//obtenerSesion();
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
				sesion.saveOrUpdate(empleado);
				
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
