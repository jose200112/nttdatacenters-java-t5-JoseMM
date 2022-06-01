package nttdata.javat5;

import nttdata.javat5.business.ManagementServiceImpl;

/**
 * Clase con metodo Main
 * 
 * @author jose
 *
 */
public class T5MainJMM {

	/**
	 * Metodo main que demuestra el correcto funcionamiento
	 * 
	 * @param args main
	 */
	public static void main(String[] args) {
		// Constantes
		final String JUNIOR_DEV = "Programador junior";
		final String ANALYST = "Analista programador";
		final String PROJECT_MAN = "Jefe de proyecto";
		final String TESTER = "Tester";

		// Creamos la instancia
		ManagementServiceImpl m = new ManagementServiceImpl();

		// Agregamos empleados
		m.addNewEmployee("Laura", JUNIOR_DEV);
		m.addNewEmployee("Jose", JUNIOR_DEV);
		m.addNewEmployee("Maria", ANALYST);
		m.addNewEmployee("Juan", TESTER);
		m.addNewEmployee("Manuel", PROJECT_MAN);
		m.addNewEmployee("Marina", PROJECT_MAN);
		m.addNewEmployee("Raul", ANALYST);
		m.addNewEmployee("Sara", ANALYST);
		m.addNewEmployee("Estrella", JUNIOR_DEV);
		m.addNewEmployee("Ernesto", TESTER);

		// Supera el limite por lo que no se agrega
		m.addNewEmployee("Margarita", "Analista programador");

		// Se vuelcan los empleados en un Excel
		m.printAllEmployees();

		// Se imprimen en numero total de empleados
		m.printEmployeesTotalNum();
		
		// Se borra el empleado con id 1
		m.deleteEmployee(1);

		// Comprueba si el empleado con id 1 sigue de alta
		m.containsEmployee(1);

	}

}
