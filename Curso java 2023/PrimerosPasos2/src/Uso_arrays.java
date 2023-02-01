
public class Uso_arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int [] mi_matriz = new int[5];
		
		mi_matriz[0] = 5;
		mi_matriz[1] = 38;
		mi_matriz[2] = -15;
		mi_matriz[3] = 92;
		mi_matriz[4] = 71;*/
		
		//int [] mi_matriz = { 5,38,-15,92,71,15,25,67,94};
		
		//for(int i=0; i< mi_matriz.length; i++) {
			//System.out.println("Valor del índice "+ i +" = "+mi_matriz[i]);
		//}
		String [] CodeStyle = {"Florencia Oviedo","Dana Angellotti","Maria Gabriela Silva","Adriana Soledad Da Silva",
							   "Juan Pablo Ayoroa Portugal", "Ivana Germir", "Martin Verstraeten","Fernando Rojas"};
		for(int i=0; i<CodeStyle.length; i++) {
			System.out.println((i+1) +": "+ CodeStyle[i]);
		}
	}
}
