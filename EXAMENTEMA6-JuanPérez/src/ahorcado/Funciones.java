package ahorcado;

import java.util.Scanner;

public class Funciones {

	static String palabras[] = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza",
			"brazo", "familia" };// guardara lista de palabras de las cuales se elegira una al azar para que el
									// jugador la adivine

	static final int NUMINTENTOS = 7;// almacenará el número de intentos que tiene el jugador para adivinar la
	// palabra. Inicialmente va a valer 7

	static String palabraSecreta = "";// almacenara la palabra a acertar

	static String palabraPista = "";// almacenará la pista del juego

	static String noAcertadas = "";// almacenara las letras no acertadas

	static void generaPalabra() {
		int posicionAleatoria = 0;

		posicionAleatoria = (int) (Math.random() * palabras.length);

		palabraSecreta = palabras[posicionAleatoria];

		for (int i = 0; i < palabraSecreta.length(); i++) {

			palabraPista += "_";
		}

	} // final funcion

	static int menu() {
		int opcionSeleccionada;
		Scanner dogma = new Scanner(System.in);

		System.out.println("Seleccione una de las siguientes opciones: \n1.Introducir letra.\n2.Introducir palabra.");
		opcionSeleccionada = dogma.nextInt();

		return opcionSeleccionada;
	}// final funcion

	static void comprobarLetra(String letra) {

		char arrayLetra[] = new char[1];
		char arrayPista[] = new char[0];

		arrayPista = palabraPista.toCharArray();
		arrayLetra = palabraPista.toCharArray();

		if (palabraSecreta.contains(letra)) {

			for (int i = 0; i < palabraSecreta.length(); i++) {
				if (palabraSecreta.charAt(i) == arrayLetra[0]) {
					arrayPista[i] = arrayLetra[0];
				}
			}

			palabraPista = "";
			for (int i = 0; i < palabraSecreta.length(); i++) {
				palabraPista += arrayPista[i];
			}

		} else {
			noAcertadas += letra;
		}
	}

	static void comprobarPalabra(String palabra) {
		if (palabraSecreta.equalsIgnoreCase(palabra)) {
			palabraPista = palabra;
		}

	}

	static void pintaPista() {
		System.out.println(NUMINTENTOS - (noAcertadas.length()));
		System.out.println(palabraPista);
	}

}
