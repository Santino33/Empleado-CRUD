package runner;

import controller.Control;
import org.w3c.dom.CDATASection;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Control control = new Control();
    control.init();

	}

	static int[] datos = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 21, 50};
	static int number = 200;

	public static int busquedaBinaria(int[] array, int numberSearched){
		int start = 0;
		int end = array.length;
		int mitad;
		int pos = -1;

		do {
			mitad = ((end - start)/2) + start;
			if (array[mitad] < numberSearched) start = mitad;
			if (array[mitad] > numberSearched) end = mitad;
			pos = mitad;
		}while(array[mitad] != numberSearched);

		return pos;
	}

}
