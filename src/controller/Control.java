package controller;

import model.Business;
import model.Date;
import model.Employee;
import view.IoManager;

public class Control {
	private IoManager io = new IoManager();
	Business business = new Business();

	public Control() {
	}

	public void init() {
		this.business.setName(this.io.readGraphicInput("Nombre del negocio"));
		this.business.setCity(this.io.readGraphicInput("ciudad"));
		this.menu();
	}

	public void menu() {
		int opt = 0;

		do {
			opt = this.io.readMenu();
			switch (opt) {
				case 1:
					this.printBussinesData();
					break;
				case 2:
					this.createEmployee();
					break;
				case 3:
					this.deleteEmployeeData();
					break;
				case 4:
					this.modifiEmployee();
					break;
				case 5:
					this.printEmployeeData();
					break;
				case 6:
					this.printAllEmployees();
					break;
				case 7:
					this.liquidateEmployee();
					break;
				case 8:
					this.io.showGraphicMessage("Finalizar");
					break;
				default:
					this.io.showGraphicErrorMessage("Opcion Incorrecta");
			}
		} while(opt != 8);

	}

	public void printBussinesData() {
		this.io.showGraphicMessage(this.business.getName() + "\n" + this.business.getCity());
	}

	public void createEmployee() {
		Employee employee = new Employee();
		employee.setId(io.readShortGraphicInput("Ingrese el ID"));
		employee.setFirstName(io.readGraphicInput("Ingrese su nombre"));
		employee.setLastName(io.readGraphicInput("Ingrese su apellido"));
		business.addEmployee(employee);
		/*
		new Employee();
		Date d1 = new Date((short)1, (short)5, (short)2001);
		Date d2 = new Date((short)12, (short)9, (short)2023);
		Date d3 = new Date((short)24, (short)12, (short)1999);
		Date d4 = new Date((short)29, (short)5, (short)2015);
		Employee employee1 = new Employee((short)1, "Juancho", "Roiz", 130000.0, (byte)1, 120000.0, d1, d2);
		Employee employee2 = new Employee((short)2, "Benito", "Martine", 180000.0, (byte)0, 125000.0, d3, d4);
		this.business.addEmployee(employee1);
		this.business.addEmployee(employee2);

		 */
	}

	public Date getDate() {
		Date date = new Date();
		date.setDay(Short.parseShort(this.io.readGraphicInput("Ingrese el dia : ")));
		date.setMonth(Short.parseShort(this.io.readGraphicInput("Ingrese el mes : ")));
		date.setYear(Short.parseShort(this.io.readGraphicInput("Ingrese el año : ")));
		return date;
	}

	public void deleteEmployeeData() {
		short id = Short.parseShort(this.io.readGraphicInput("Ingrese el id del empleado que quiera borrar"));
		this.business.deleteEmploye(this.business.findEmployee(id));
		this.printAllEmployees();
	}

	public void modifiEmployee() {
		short id = Short.parseShort(this.io.readGraphicInput("Ingrese el id del empleado que quiera modificar"));
		this.business.modify(this.business.findEmployee(id));
		this.printAllEmployees();
	}

	public void printEmployeeData() {
		short id = Short.parseShort(this.io.readGraphicInput("Ingrese el id del empleado que quiere buscar"));
		this.io.showGraphicMessage(this.business.getEmployeeData(this.business.findEmployee(id)));
	}
		public void printAllEmployees(){
			String output = "ID   Nombre            Salario         N. Hijos   F. Contratación      F.Nacimiento\n-----------------------------------------------------------------------------------------------------------\n";

			for (Employee employee : business.getEmployeesArray()) {
				if (employee != null) {
					output += employee.getId() + ". " +
							employee.getFirstName() + " " + employee.getLastName() + "     " + employee.getSalary()
							+ "       " +
							employee.getNumberChildrens() + "      " + employee.getHireDate() + "       "
							+ employee.getBirthDate() + "\n";
				}
			}

			io.showGraphicMessage(output);
}

	public void liquidateEmployee() {

	}
}

