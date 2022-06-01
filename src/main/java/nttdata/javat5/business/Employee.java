package nttdata.javat5.business;

/**
 * Clase Employee para crear un objeto empleado
 * 
 * @author jose
 *
 */
public class Employee {
	private Integer id;
	private String rank;
	private String name;
	private static final String COMPANY_NAME = "NTTDATA";
	private static final int MAX_NUM_EMPLOYEES = 10;

	/**
	 * Constructor de empleado
	 * 
	 * @param iD   (ID)
	 * @param name (nombre)
	 * @param rank (Categoria)
	 */
	public Employee(int iD, String name, String rank) {
		id = iD;
		this.name = name;
		this.rank = rank;
	}

	/**
	 * Metodo getter para la categoria
	 * 
	 * @return category (categoria)
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Metodo getter para el ID
	 * 
	 * @return ID (ID)
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo getter para el nombre de empleado
	 * 
	 * @return name (nombre)
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo getter del nombre de la empresa
	 * 
	 * @return COMPANY_NAME (Nombre de la empresa)
	 */
	public String getCompanyName() {
		return COMPANY_NAME;
	}

	/**
	 * Metodo estatico que devuelve el limite de empleados
	 * 
	 * @return MAX_NUM_EMPLOYEES (numero maximo de empleado)
	 */
	public static int getMaxNumEmployees() {
		return MAX_NUM_EMPLOYEES;
	}

	/**
	 * Metodo toString personalizado
	 */
	@Override
	public String toString() {
		return "Empleado: " + name + ", " + "categoria: " + rank + ", empresa: " + COMPANY_NAME + ", ID: " + id;
	}

}
