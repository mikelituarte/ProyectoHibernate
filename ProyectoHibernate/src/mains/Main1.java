package mains;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import tablas_Clases.Departments;
import tablas_Clases.Employees;
import tablas_Clases.Jobs;
import clases.servicios.EmployeesServices;

public class Main1 {

	public static void main(String[] args) {
		/*Jobs j = new Jobs("AAA", "BBB");
		Date d = new Date(2015, 4, 8);
		int employeeId;
		short p = 100;
		Departments departments = new Departments(p, "Mi Departamento");
		Employees employees = null;
		String firstName = "Nombre";
		String lastName ="Apellido";
		String email = "EMILIO";
		String phoneNumber ="12345678";
		Date hireDate = d;
		BigDecimal salary = new BigDecimal(200);
		BigDecimal commissionPct = new BigDecimal(2000);
		Set employeeses  =null;
		Set departmentses = null;
		Set jobHistories = null;
		Employees empleado = new Employees(8, j, departments, employees, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, employeeses, departmentses, jobHistories);
		Employees e = new Employees(employeeId, jobs, departments, employees, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, employeeses, departmentses, jobHistories)
		//Employees empleado = new Employees(207, j, "KK", "kk@popo.es", d);
		//Employees empleado = new Emplo
		EmployeesServices es = new EmployeesServices();
		//System.out.println(es.incrementarSalario());*/
		EmployeesServices es = new EmployeesServices();
		//System.out.println(es.read(105));
		System.out.println(es.obtenerEmpleados());
		//System.out.println(es.insertarEmpleado(empleado));
		es.desconectarServicio();
		System.out.println("---- FIN PROGRAMA -----");
		
	}
}
