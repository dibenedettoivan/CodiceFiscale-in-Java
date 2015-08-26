import java.util.HashMap;
import java.util.Map;

public class CodiceFiscale {

	// Variabili
	private String CF = "";
	private Map<String, String> comuni = new HashMap<String, String>();
	private String vocali = "AEIOU";
	
	// Costruttore
	public CodiceFiscale(String no, String co, String na, char se, String cm){
		comuni.put("VENEZIA", "L736");
		comuni.put("DOLO", "D325");
		comuni.put("CATANIA", "C351");
		comuni.put("PALERMO", "G273");
		comuni.put("RACALMUTO", "H148");
		comuni.put("AGRIGENTO", "A089");
		comuni.put("CALTANISSETTA", "B429");
		comuni.put("CENTURIPE", "C471");
		
		cognome(co);
		nome(no);
		dataNascita(na, se);
		comune(cm);
		codiceControllo();
	}
	
	// Metodi
	private void nome(String no){
		int cons = 0;
		for(int i = 0; i < no.length(); i++)
			if(no.charAt(i) != 'A' && no.charAt(i) != 'E' && no.charAt(i) != 'I' && no.charAt(i) != 'O' && no.charAt(i) != 'U')
				cons++;
		
		if(cons <= 3) {
			for(int i = 0; i < no.length(); i ++){
				if((no.charAt(i) != 'A' && no.charAt(i) != 'E' && no.charAt(i) != 'I' && no.charAt(i) != 'O' && no.charAt(i) != 'U' && no.charAt(i) != ' ') && CF.length() < 6) {
					CF += no.charAt(i);
				}
			}
			for(int i = 0; i < no.length(); i ++){
				if((no.charAt(i) == 'A' || no.charAt(i) == 'E' || no.charAt(i) == 'I' || no.charAt(i) == 'O' || no.charAt(i) == 'U') && CF.length() < 6){
					CF += no.charAt(i);
				}
			}
			if(CF.length() < 6){
				while(CF.length() < 6)
					CF += 'X';
			}
		} else {
			int cont = 0;
			for(int i = 0; i < no.length(); i++) {
				if(no.charAt(i) != 'A' && no.charAt(i) != 'E' && no.charAt(i) != 'I' && no.charAt(i) != 'O' && no.charAt(i) != 'U') {
					cont++;
					if(cont != 2)
						CF +=no.charAt(i);
				}
						
			}
		}
	}
	
	private void cognome(String co) {
		for(int i = 0; i < co.length(); i ++){
			if((co.charAt(i) != 'A' && co.charAt(i) != 'E' && co.charAt(i) != 'I' && co.charAt(i) != 'O' && co.charAt(i) != 'U' && co.charAt(i) != ' ') && CF.length() < 3) {
				CF += co.charAt(i);
			}
		}
		for(int i = 0; i < co.length(); i ++){
			if((co.charAt(i) == 'A' || co.charAt(i) == 'E' || co.charAt(i) == 'I' || co.charAt(i) == 'O' || co.charAt(i) == 'U') && CF.length() < 3){
				CF += co.charAt(i);
				
			}
		}
		if(CF.length() < 3){
			while(CF.length() < 3)
			CF += 'X';
		
		}
	}
	
	private void dataNascita(String na, char se) {
		String[] n = na.split("\\/");
		CF += n[2];
		String mesi = "ABCDEHLMPRST";
		CF += mesi.charAt(Integer.parseInt(n[1])-1);
		if(se == 'F') CF += Integer.parseInt(n[0]) + 40;
		else CF += n[0];
		
	}
	
	private void comune(String cm) {
		CF += comuni.get(cm);
		
	}
	
	private void codiceControllo(){
		String a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int[] pari = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
	            13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
		int[] dispari ={1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 1, 0, 5, 7, 9, 13, 15, 17, 19,
	               21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23};
		int cont = 0;
		for(int i = 0; i < CF.length(); i++){
			if(i % 2 == 0){
				for(int j = 0; j < a.length(); j++){
					if(CF.charAt(i) == a.charAt(j)){
						//System.out.println(dispari[j]);
						cont += dispari[j];
					}
					
				}
			}
			if(i % 2 == 1){
				for(int j = 0; j < a.length(); j++){
					if(CF.charAt(i) == a.charAt(j)){
						//System.out.println(pari[j]);
						cont += pari[j];
					}
				}
			}
			//System.out.println(cont);
			//System.out.println();
		}
		
		CF+= a.charAt(cont % 26 + 10);
	}
	
	// Getters & Setters
	public String getCF() { return CF;}
}