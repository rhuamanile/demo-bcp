import java.util.Scanner;

public class NumeroPrimo {

	public static void main(String args[]) {        
		
		System.out.println("Ingrese un numero");
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		//validamos si es # valido
		if(n <= 0 ) {
			System.err.println("El Numero debe ser mayor a 0");
		} else {
			//
			System.out.println("El Numero ingresado es : " + n);
						
			//mostramos salida
			System.out.println("Los numeros primos en forma descendente son: " + orderNumbes(n));
		}
		input.close();
	}
	
	public static String orderNumbes(int n) {		
		String res = "";
		
		for (int i = n; i > 1; i--) {
			
			if(isPrime(i) == true) {
				//validamos la concatenación de ","
				if(i > 2) {
					res += (i + ",");
				} else {
					res += (i);
				}				
			}			
		}	
		return res;
	}
	
	public static boolean isPrime (int n) {
		for (int i = 2; i < n; i++) {
			
			if(n <= 1) {
				return false;
			}
			
			if( n % i == 0 && n!= 1) {
				//no primos
				return false;
			} 
		}
		return true;
	}
}
