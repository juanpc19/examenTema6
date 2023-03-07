package ahorcado;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String palabraUsuario = "";

		String letraUsuario = "";

		Scanner dogma = new Scanner(System.in);

		Funciones.generaPalabra();

		System.out.println(Funciones.palabraPista);

		do {

			if (Funciones.menu() == 1) {
				System.out.println("Introduzca una letra: ");
				letraUsuario = dogma.nextLine();
				Funciones.comprobarLetra(letraUsuario);
			}

			else if (Funciones.menu() == 2) {
				System.out.println("Introduzca una palabra: ");
				palabraUsuario = dogma.nextLine();
				Funciones.comprobarPalabra(palabraUsuario);
			}

			else if (Funciones.menu() != 1 && (Funciones.menu() != 2)) {
				System.out.println("Asegurese de seleccionar 1 o 2. ");
				Funciones.menu();
			}

			Funciones.pintaPista();

		} while (!Funciones.palabraSecreta.equals(palabraUsuario)
				&& (Funciones.NUMINTENTOS > Funciones.noAcertadas.length()));

		if (Funciones.NUMINTENTOS <= Funciones.noAcertadas.length()) {
			System.out.println("GAME OVER");

		} else {
			System.out.println("¡¡ENHORABUENA!! HAS ACERTADO.");
		}

		dogma.close();

	}
}
