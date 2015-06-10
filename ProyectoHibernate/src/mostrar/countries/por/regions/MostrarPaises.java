package mostrar.countries.por.regions;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import tablas_Clases.Employees;
import tablas_Clases.Regions;

public class MostrarPaises {

	
	private static Session sesion;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	private static Transaction transaction;
	private static Connection conexion;
	
	
	public MostrarPaises(){
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
		sesion.close();
		factory.close();
	}
	
	public void mostrarPaises(){
		ToStringSet ts = null;
		try 
    	{
			//obtenemos los Empleados...
			activarSesion();
	    	transaction = sesion.beginTransaction();
	    	@SuppressWarnings("unchecked")									
	    	List<Regions> lista = sesion.createSQLQuery("select * from regions").addEntity(Regions.class).list();
	    	//aumentamos el sueldo...
	    	Regions r = null;
			Iterator<Regions> it = lista.iterator();
			while (it.hasNext()){
				r = it.next();
				System.out.println("----------------------------------");
				System.out.println("Continente: " + r.getRegionName());
				//System.out.println(r.getCountrieses());
				ts = new ToStringSet(r.getCountrieses());
				System.out.println(ts);
				System.out.println("----------------------------------");
			}
    	}
    	catch (Exception e)
    	{
    		transaction.rollback();//si algo ha ido mal, deshago la transacción
    	}
		finally{
			cerrarSesion();
			
		}
	}
	
	public void borrarRegion(){
		
	}
	
	
}
