import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Inserisci il tuo nome: ");
		String no = in.nextLine();
		no = no.toUpperCase();
		System.out.print("Inserisci il tuo cognome: ");
		String co = in.nextLine();
		co = co.toUpperCase();
		System.out.print("Inserisci la data di nascita (2 cifre per il giorno, 2 cifre per il mese, due cifre per l'anno) separate da /: ");
		String na = in.nextLine();
		System.out.print("Inserisci il sesso (M/F): ");
		char se = in.nextLine().toUpperCase().charAt(0);
		System.out.print("Inserisci il tuo comune di nascita: ");
		String cm = in.nextLine();
		cm = cm.toUpperCase();
		
		CodiceFiscale cf = new CodiceFiscale(no, co, na, se, cm);
		
		System.out.println(cf.getCF());
	}

}
