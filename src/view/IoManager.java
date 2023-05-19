package view;

import java.awt.Component;
import javax.swing.JOptionPane;

public class IoManager {
	public IoManager() {
	}

	public void showGraphicMessage(String message) {
		JOptionPane.showMessageDialog((Component)null, message);
	}

	public String readGraphicInput(String message) {
		return JOptionPane.showInputDialog(message);
	}

	public int readIntGraphicInput(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(message));
	}

	public short readShortGraphicInput(String message) {
		return Short.parseShort(JOptionPane.showInputDialog(message));
	}

	public double readDuoubleGraphicInput(String message) {
		return Double.parseDouble(JOptionPane.showInputDialog(message));
	}

	public byte readByteGraphicInput(String message) {
		return Byte.parseByte(JOptionPane.showInputDialog(message));
	}

	public void showGraphicErrorMessage(String message) {
		JOptionPane.showMessageDialog((Component)null, message);
	}

	public int readMenu() {
		String mensaje = "\tMenu \n1. Imprimir datos de la empresa \n2. Adicionar un empleado \n3. Borrar un empleado \n4. Modificar datos de un empleado \n5. Mostrar datos de un empleado \n6. Mostrar datos de todos los empleados \n7. Liquidar\n8. Salir \n";
		return Integer.parseInt(this.readGraphicInput(mensaje));
	}
}
