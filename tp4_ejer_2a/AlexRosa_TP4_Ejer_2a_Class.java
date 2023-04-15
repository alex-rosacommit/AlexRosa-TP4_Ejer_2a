package tp4_ejer_2a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class AlexRosa_TP4_Ejer_2a_Class {

	public static void main(String[] args) {
		// a. Al programa anterior agreguele un parámetro para que la operación
		//pueda ser suma o multiplicación. 
		String url = "numeros.txt";
		
		SumaNumArchivo(url);
	}
	
	public static void SumaNumArchivo(String urlArchivo) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		Scanner leer = new Scanner(System.in);
		String numerosEnArchivo = "";
		
		try {
			archivo = new File(urlArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				numerosEnArchivo = numerosEnArchivo + linea;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		String[] numerosArray  = numerosEnArchivo .split("_");
		
		System.out.println("Los numeros en el archivo son los siguentes: \n" + numerosEnArchivo);
		
		System.out.println("=====================================================");
		
		System.out.println("El archivo se encuentra en: " + urlArchivo);
		
		System.out.println("=====================================================");

		int eleccion = 0;
		
		do{
			System.out.println("Seleccione una opcion:");
			System.out.println("1 --> Sumar los numeros.");
			System.out.println("2 --> Multiplicar los numeros");
			eleccion = leer.nextInt();
		}while(eleccion != 1 && eleccion != 2);
		
		leer.close();
		
		if(eleccion == 1) {
			int sumaNumeros = 0;
			for(int i = 0;  i < numerosArray.length; i++) {
				sumaNumeros = sumaNumeros + Integer.parseInt(numerosArray[i]);
			}
			System.out.println("=====================================================");
			System.out.println("La suma de los numeros es: " + sumaNumeros);
		}
		
		if(eleccion == 2) {
			double multiNumeros = 0;
			for(int i = 0;  i < numerosArray.length; i++) {
				if(multiNumeros == 0) {
					multiNumeros = Double.parseDouble(numerosArray[i]); 
				}
				else{
					multiNumeros = multiNumeros * Double.valueOf(numerosArray[i]);
					System.out.println(multiNumeros);
				}
				
			}
			System.out.println("=====================================================");
			System.out.printf("La multiplicacion de los numeros es: %.2f" , multiNumeros);
		}
		
		
	}

}
