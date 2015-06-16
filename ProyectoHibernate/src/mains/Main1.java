package mains;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import tablas_Clases.Departments;
import tablas_Clases.Employees;
import tablas_Clases.Jobs;
import tablas_Clases.Locations;
import tablas_Clases.Regions;
import clases.servicios.EmployeesServices;

public class Main1 {
	
	public static void mostrarLista(List lista){
		java.util.Iterator it = lista.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

	public static void main(String[] args) {
		List<Employees> lista = null;
		EmployeesServices es = new EmployeesServices();
		short departamento_id = 80;

		System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
		System.out.println("Mostrar todos los empleados de la tabla EMPLOYEES");
		lista = es.obtenerEmpleados();
		mostrarLista(lista);
		System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
		System.out.println("Incrementamos el salario de todos los empleados");
		lista = es.incrementarSalario();
		mostrarLista(lista);
		System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
		System.out.println("Lista de los empleados mejor pagados por departamento");
		lista = es.obtenerEmpleadosMejorPagadosPorDepartamento();
		mostrarLista(lista);
		System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
		System.out.println("Lista de los empleados de un departamento");
		lista = es.obtenerEmpleadosPorDepartamento(departamento_id);
		mostrarLista(lista);
		
		es.desconectarServicio();
		System.out.println("---- FIN PROGRAMA -----");
		
	}
}
