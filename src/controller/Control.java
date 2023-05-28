package controller;

import Persistence.MyFile;
import Persistence.MyFile;
import model.Business;
import model.Date;
import model.Employee;
import view.IoManager;

public class Control {
	private IoManager io = new IoManager();
	Business business = new Business();
	private MyFile myFile;

	public Control() {
		myFile = new MyFile("C:/Temp2/empleados.csv");
	}

	public void init() {
		this.business.setName(this.io.readGraphicInput("Nombre del negocio"));
		this.business.setCity(this.io.readGraphicInput("Ciudad"));
		this.business.loadEmployees(myFile);
		this.menu();
		myFile.closeFile();
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
					this.modifyEmployee();
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
					this.business.recordEmployees(myFile);
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
		employee.setSalary(io.readDoubleGraphicInput("Ingrese su salario"));
		employee.setNumberChildrens(io.readByteGraphicInput("Ingerse su numero de hijos"));
		employee.setComission(io.readDoubleGraphicInput("Ingrese la comision"));
		try {
			employee.setBirthDate(io.readGraphicDate("Fecha de nacimiento - "));
			employee.setHireDate(io.readGraphicDate("Fecha de contratacion - "));
		} catch (Exception e) {
			io.showGraphicErrorMessage("Fecha invalida, porfavor ingrese el empleado otra vez");
			this.createEmployee();
		}
		business.addEmployee(employee);


	}

	public void deleteEmployeeData() {
		short id = Short.parseShort(this.io.readGraphicInput("Ingrese el id del empleado que quiera borrar"));
		this.business.deleteEmployee(this.business.findEmployee(id));
		this.printAllEmployees();
	}

	public void modifyEmployee() {
		short id = Short.parseShort(this.io.readGraphicInput("Ingrese el id del empleado que quiera modificar"));
		this.business.modify(this.business.findEmployee(id));
		this.printAllEmployees();
	}

	public void printEmployeeData() {
		short id = Short.parseShort(this.io.readGraphicInput("Ingrese el id del empleado que quiere buscar"));
		this.io.showGraphicMessage(this.business.getEmployeeData(this.business.findEmployee(id)));
	}
		public void printAllEmployees(){
			String output = "ID   Nombre            Salario         N. Hijos    Comision    F. Contratación      F.Nacimiento\n-----------------------------------------------------------------------------------------------------------\n";

			for (Employee employee : business.getEmployeesList()) {
				if (employee != null) {
					output += employee.getId() + ". " +
							employee.getFirstName() + " " + employee.getLastName() + "     " + employee.getSalary()
							+ "       " + employee.getNumberChildrens()+ "       "+
							employee.getComission() + "      " + employee.getHireDate() + "       "
							+ employee.getBirthDate() + "\n";
				}
			}

			io.showGraphicMessage(output);
}

	public void liquidateEmployee() {

	}



}

