package model;

import java.util.Calendar;

public class Employee {
	private short id;
	private String firstName;
	private String lastName;
	private double salary;
	private byte numberChildrens;
	private double comission;
	private Date birthDate;
	private Date hireDate;

	public Employee(short id, String firstName, String lastName, double salary, byte numberChildrens, double comission, Date birthDate, Date hireDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.numberChildrens = numberChildrens;
		this.comission = comission;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
	}

	public Employee() {
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public byte getNumberChildrens() {
		return this.numberChildrens;
	}

	public void setNumberChildrens(byte numberChildrens) {
		this.numberChildrens = numberChildrens;
	}

	public double getComission() {
		return this.comission;
	}

	public void setComission(double comission) {
		this.comission = comission;
	}

	public Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		return new Date((short)calendar.get(5), (short)(calendar.get(2) + 1), (short)calendar.get(1));
	}

	private int getDistanceBetweenDates(Date date) {
		Date currentDate = this.getCurrentDate();
		int distance = currentDate.getYear() - date.getYear();
		return distance;
	}

	public int getAge() {
		return this.getDistanceBetweenDates(this.birthDate);
	}

	public int getAntiquity() {
		return this.getDistanceBetweenDates(this.hireDate);
	}

	public String toString() {
		return "\n>>Datos del empleado: \n Código = " + this.id + "\n Nombre = " + this.firstName + "\n Apellido = " + this.lastName + "\n Número de hijos = " + this.getNumberChildrens() + "\n Comisión = " + this.comission + "\n Salario = " + this.salary + "\n Fecha de nacimiento = " + this.birthDate + "\n Fecha de contratación = " + this.hireDate;
	}
}
