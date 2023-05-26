package model;

import view.IoManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Business {
    private String name;
    private String city;
    private Employee[] employeesArray = new Employee[1];
    private ArrayList<Employee> employeesList = new ArrayList<Employee>();

    public Business() {
        this.employeesArray[0] = null;
    }

    public void addEmployee(Employee employee) {
        this.employeesList.add(employee);
    }

    /*
    public void incremVectorSize() {
        Employee[] vector = new Employee[this.employeesArray.length + 1];

        for(int i = 0; i < this.employeesArray.length; ++i) {
            vector[i] = this.employeesArray[i];
        }

        vector[this.employeesArray.length] = null;
        this.employeesArray = vector;
    }



    public void decrementVectorSize() {
        Employee[] vector = new Employee[this.employeesArray.length - 1];

        for(int i = 0; i < vector.length; ++i) {
            vector[i] = this.employeesArray[i];
        }

        vector[vector.length - 1] = null;
        this.employeesArray = vector;
    }
    */

    public String myGetStringEmployeesArray2() {
        String output = "/n";
        Employee[] var5;
        int var4 = (var5 = this.employeesArray).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Employee employee = var5[var3];
            if (employee != null) {
                output = output + employee;
            }
        }

        return output;
    }

    public short findEmployee(short id) {
        short position = -1;

        for(short i = 0; i < this.employeesList.size() - 1; ++i) {
            if (this.employeesList.get(i).getId() == id) {
                position = i;
            }
        }

        return position;
    }

    public String getEmployeeData(int pos) {
        String txt = "";
        return txt + this.employeesList.get(pos);
    }

    public void deleteEmployee(short pos){
        this.employeesList.remove(pos);
    }
    /*
    public void deleteEmploye(short pos) {
        Employee[] temp = new Employee[this.employeesArray.length];
        this.employeesArray[pos] = null;

        for(int i = pos; i + 1 < this.employeesArray.length; ++i) {
            if (this.employeesArray[i + 1] != null) {
                temp[0] = this.employeesArray[i + 1];
                this.employeesArray[i + 1] = this.employeesArray[i];
                this.employeesArray[i] = temp[0];
            }
        }

        this.decrementVectorSize();
    }

     */

    public void modify(short id) {
        IoManager io = new IoManager();
        this.employeesList.get(id).setFirstName(io.readGraphicInput("Ingrese el nuevo nombre"));
        this.employeesList.get(id).setLastName(io.readGraphicInput("Ingrese el nuevo apellido"));
        this.employeesList.get(id).setSalary(io.readDoubleGraphicInput("ingrese el nuevo salario"));
        this.employeesList.get(id).setNumberChildrens(io.readByteGraphicInput("Ingrese el nuevo número de hijos"));
    }

    public void verifyId(short id) throws Exception{
        short listID;
        
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Employee>  getEmployeesList(){
        return this.employeesList;
    }

    public void setEmployeesList(ArrayList<Employee> employeesList){
        this.employeesList = employeesList;
    }
    /*
    public Employee[] getEmployeesArray() {
        return this.employeesArray;
    }

    public void setEmployeesArray(Employee[] employeesArray) {
        this.employeesArray = employeesArray;
    }
    */

}
