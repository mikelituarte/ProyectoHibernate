package sesion.manager;

//import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SesionManager {
	
	//private static SessionFactory sesionFactory;
	
	private  Session sesion;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	
	private static SesionManager sesionManager = new SesionManager();
	
	
	private SesionManager(){
    	configuration = new Configuration().configure();
    	builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	factory = configuration.buildSessionFactory(builder.build());//Solo se hace una vez en cada programa
	}
	

	public static Session getSesion(){
		sesionManager.sesion = factory.openSession();
		return sesionManager.sesion;
	}
	
	public static void cerrarSesion(){
		sesionManager.sesion.close();
	}
	
	public static void desconectarSesion(){
		sesionManager.sesion.disconnect();
	}
	
	public static void cerrarfactory(){
		sesionManager.factory.close();
	}
	
	/*public static SesionManager getSesionManager(){
		return sesionManager;
	}*/
	
}
