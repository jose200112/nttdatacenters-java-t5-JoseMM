package nttdata.javat5.business;

/**
 * Interfaz cuyos metodos ofrecen manejar la gestion de empleados
 * @author jose
 *
 */
public interface ManagementServiceI {
	
	/**
	 * Metodo que da de alta empleados si hay plaza
	 * @param name (nombre de empleado)
	 * @param rank (categoria de empleado)
	 */
	public void addNewEmployee(String name, String rank);
	
	/**
	 * Metodo que muestra todos los empleados
	 */
	public void printAllEmployees();
	
	/**
	 * Metodo que muestra el total de empleados
	 */
	public void printEmployeesTotalNum();

}
