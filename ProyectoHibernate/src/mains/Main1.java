package mains;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import tablas_Clases.Departments;
import tablas_Clases.Employees;
import tablas_Clases.Jobs;
import tablas_Clases.Locations;
import tablas_Clases.Regions;
import clases.servicios.EmployeesServices;

public class Main1 {

	public static void main(String[] args) {

		EmployeesServices es = new EmployeesServices();
		short departamento_id = 80;
		Departments departamento = (Departments) es.leer(Departments.class,departamento_id);
		System.out.println(departamento);
		System.out.println(departamento.getEmployees());

		es.desconectarServicio();
		System.out.println("---- FIN PROGRAMA -----");
		
	}
}
