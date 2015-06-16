package clases.servicios;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

//import org.junit.AfterClass;

import tablas_Clases.Employees;
import junit.framework.TestCase;

public class TestEmployeesServices extends TestCase {
	
	
	private static EmployeesServices servicio;
	
	//@BeforeClass
	public static void inicioClase(){
		servicio = new EmployeesServices();
	}
	
	public void testEmployeesServices() {
		//fail("Not yet implemented");
	}

	public void testObtenerEmpleados() {		
		//fail("Not yet implemented");
		//EmployeesServices servicio = new EmployeesServices();
		inicioClase();

		Employees empleado = (Employees)servicio.leer(Employees.class,105);
		assertTrue("El empleado no esta en la lista de empleados ",servicio.obtenerEmpleados().contains(empleado));
	}
	
	private BigDecimal salarioAumentado(BigDecimal salario){
		BigDecimal i = new BigDecimal(1.2);
		return (salario.multiply(i));
	}

	public void testIncrementarSalario() {
		inicioClase();
		Employees empleado = (Employees)servicio.leer(Employees.class,105);
		BigDecimal salario = empleado.getSalary();
		salario = salarioAumentado(salario);
		servicio.incrementarSalario();
		empleado = (Employees)servicio.leer(Employees.class,105);
		assertEquals("El salario no se ha incrementado correctamente un 20% ",salario.intValue(), empleado.getSalary().intValue());
	}

	public void testInsertarEmpleado() {
		//fail("Not yet implemented");
	}

	public void testRead() {
		Employees empleado = null;
		Employees empleadoLeido = null;
		inicioClase();
		Employees e = null;
		//EmployeesServices servicio = new EmployeesServices();
		List<Employees> lista = servicio.obtenerEmpleados();
		Iterator it = lista.iterator();
		if(it.hasNext()){
			empleado = (Employees)it.next();
		}
		empleadoLeido = null;
		empleadoLeido = (Employees)servicio.leer(Employees.class,empleado.getEmployeeId());
		assertNotNull(empleadoLeido);
	}
	
	public void testobtenerEmpleadosPorDepartamento() {
		/*inicioClase();
		Employees empleado = (Employees)servicio.leer(Employees.class,105);
		BigDecimal salario = empleado.getSalary();
		salario = salarioAumentado(salario);
		servicio.incrementarSalario();
		empleado = (Employees)servicio.leer(Employees.class,105);
		assertEquals("El salario no se ha incrementado correctamente un 20% ",salario.intValue(), 10);*/
	}

	public void testDesconectarServicio() {
		//fail("Not yet implemented");
	}
	
	//@AfterClass
	public static void finalClase(){
		servicio.desconectarServicio();
	}

}
