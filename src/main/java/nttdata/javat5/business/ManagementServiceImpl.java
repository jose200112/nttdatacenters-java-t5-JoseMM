package nttdata.javat5.business;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que implementa la interfaz con metodos para la gestion de empleados
 * 
 * @author jose
 *
 */
public class ManagementServiceImpl implements ManagementServiceI {

	private static final Logger LOG = LoggerFactory.getLogger(ManagementServiceImpl.class);
	private Map<Integer, Employee> database = new HashMap<>();
	private Integer genID = 0;

	/**
	 * Metodo que registra empleados si hay plazas
	 * 
	 * @param name (nombre de empleado)
	 * @param rank (categoria de empleado)
	 */
	public void addNewEmployee(String name, String rank) {

		// Generamos el ID
		genID++;

		// Creamos el objeto
		Employee e = new Employee(genID, name, rank);

		// Restamos la constante con el numero de empleados en el mapa
		int count = Employee.getMaxNumEmployees() - database.size();

		if (count > 0) {

			// Metemos el objeto y su ID en el mapa
			database.put(e.getId(), e);

			LOG.info("Empleado registrado, quedan {} vacantes", count - 1);

		} else {
			LOG.info("Supera el limite de empleados");
		}

	}

	/**
	 * Metodo que vuelca la informacion de todos los empleados en un excel
	 */
	public void printAllEmployees() {

		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet("Empleados");
			int rowno = 0;
			
				for (Entry<Integer, Employee> entry : database.entrySet()) {
					
					//Se cre una instancia con los valores del mapa
					Employee e = entry.getValue();
					int id = e.getId();
					String name = e.getName();
					String rank = e.getRank();
					String companyName = e.getCompanyName();

					//Creamos el row para crear varias filas
					XSSFRow row = sheet.createRow(rowno++);

					// Personalizamos el color de fila
					CellStyle style = workbook.createCellStyle();
					style.setFillBackgroundColor(IndexedColors.SKY_BLUE.getIndex());
					style.setFillPattern(FillPatternType.BIG_SPOTS);

					// Se agranda la columna del dato categoria
					sheet.setColumnWidth(2, 6500);

					// Se le aplica el color al id para decorar el Excel
					XSSFCell cell1 = row.createCell(0);
					cell1.setCellValue(id);
					cell1.setCellStyle(style);

					// Se recorren el resto de datos
					row.createCell(1).setCellValue(name);
					row.createCell(2).setCellValue(rank);
					row.createCell(3).setCellValue(companyName);

				}

				// Se especifica la ruta donde volcar la informacion y se cierra el fichero
				FileOutputStream fos = new FileOutputStream("C:\\dev\\Empleados.xlsx");
				workbook.write(fos);
				fos.close();
				LOG.info("Excel creado con exito");
			} catch (IOException e) {
				LOG.error("Cierre el Excel antes de ejecutar el programa");
			}


	}

	/**
	 * Metodo que da de baja a un empleado
	 * 
	 * @param id (ID)
	 */
	public void deleteEmployee(Integer id) {
		if (database.containsKey(id)) {
			database.remove(id);
			LOG.info("Empleado dado de baja con exito");
		} else {
			LOG.info("El empleado no existe");
		}
	}

	/**
	 * Metodo que muestra el total de empleados
	 */
	public void printEmployeesTotalNum() {
		System.out.println(database.size());
	}

	/**
	 * Metodo que comprueba si un empleado esta de alta
	 * 
	 * @param id (ID)
	 */
	public void containsEmployee(Integer id) {
		if (database.containsKey(id)) {
			LOG.info("{}, se encuentra de alta", database.get(id));
		} else {
			LOG.info("Ese empleado no se encuentra de alta");
		}
	}

}
