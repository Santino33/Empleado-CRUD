package model;

import Persistence.MyFile;
import view.IoManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Business {
    private String name;
    private String city;

    private ArrayList<Employee> employeesList;

    public Business() {
        this.employeesList = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        this.employeesList.add(employee);
    }

    public short findEmployee(short id) {
        short position = -1;

        for(short i = 0; i < this.employeesList.size() ; ++i) {
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

    public Date createDate(String dateString){
        String [] dateRead;
        dateRead = dateString.split("/");
        Date date = new Date(Short.parseShort(dateRead[0]) , Short.parseShort(dateRead[1]), Short.parseShort(dateRead[2]));
        return date;
    }
    public void loadEmployees(MyFile myFile){
        //Abrir un archivo, hacer un while infinito hasta que se encuentren datos
        myFile.openFile('r');
        String input ="";
        String [] employeeData;
        while ((input=myFile.read()) != null){
            employeeData = input.split(",");
            Employee employee = new Employee(Short.parseShort(employeeData[0]), employeeData[1], employeeData[2], Double.parseDouble(employeeData[3]), Byte.parseByte(employeeData[4]), Double.parseDouble(employeeData[5]), createDate(employeeData[6]), createDate(employeeData[7]));
            this.addEmployee(employee);
        }
        myFile.closeFile();
        //Hacer un split al buffer leido
        //Interpretar cada uno de los elementos de la cadena para ir
        //Construyendo cada elemento que requiere el objeto empleado
        //objeto fecha
        //cerrar el archivo
    }
    public void recordEmployees(MyFile myfile){
        //abrir el archivo en modo W
        myfile.openFile('w');
        //Hacer un for each al arreglo de empleados
        for(Employee employee : employeesList){
            //en cada elemento se va emppaquetando en un string de salida
            String output = "";
            //cada uno de los datos, intercalados con una coma ya que esta trabajando con csv
            output += employee.getId()+",";
            output += employee.getFirstName()+",";
            output += employee.getLastName()+",";
            output += employee.getSalary()+",";
            output += employee.getNumberChildrens()+",";
            output += employee.getComission()+",";
            output += employee.getBirthDate()+",";
            output += employee.getHireDate();
            //se manda grabar la cadena al archivo
            myfile.record(output);
            System.out.print("Ya se guardo");
        }
        //cuando se salga del for each se cierra el archivo
        myfile.closeFile();





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

}
