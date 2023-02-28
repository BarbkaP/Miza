// Vključimo paket za delo z vhodno izhodnimi napravami
import java.io.*;
import java.util.*;

/*
	Ime datoteke: 	HelloWorld.java
	Avtor:			Barbka Podbregar
	Vhodni podatki: /
	Opis: 			Izpiše pozdrav
	Izhodni podatki:Hello world
*/

// Deklariramo javni razred
public class HelloWorld {

	// Deklariramo statično lastnost za vnos iz konzole
	private static BufferedReader in;
	
	// Deklariramo statično lastnost s seznamom steklenic
	private static ArrayList<PivskaSteklenica> steklenice;

	// Deklariramo javno statično metodo, ki se izvede ob zagonu programa
	public static void main(String[] args) {
	
		// Inicializiramo statično lastnost za vnos iz konzole
		in = new BufferedReader(new InputStreamReader(System.in));
		
		// Inicializiramo seznam steklenic
		steklenice = new ArrayList<PivskaSteklenica>();
		
		// Izpišemo pozdrav v konzolo
		System.out.println("Hello World!");
		
		// Iz česa so steklenice
		System.out.println("Vse steklenice so iz " + Steklenica.material);
		
		// Deklariramo objekt tipa Steklenica
		Steklenica zelenaSteklenica = new Steklenica(500);
		Steklenica rdecaSteklenica = new Steklenica();
		
		// Spremenljivka z imenom znamke piva
		String znamka = "";
		// Skušamo vprašati uporabnika, steklenico katere znamke piva naj ustvarimo
		try {
			System.out.print("Vnesi znamko piva: ");
			znamka = in.readLine();
		}
		// Če je bila sporočena izjema
		catch(Exception e) {
			System.out.println("Napaka pri vnosu znamke: " + e);
		}
		
		// Ustvarimo novo pivsko steklenico
		PivskaSteklenica velikoLasko = new PivskaSteklenica(znamka, 500, 5.0);
		
		// Steklenico dodamo na seznam
		steklenice.add(velikoLasko);
		
		// Na seznam dodamo še tri druge steklenice
		steklenice.add(new PivskaSteklenica("Union", 500, 4.5));
		steklenice.add(new PivskaSteklenica("Kramah", 500, 7.5));
		steklenice.add(new PivskaSteklenica("Tak", 330, 5.5));
		
		// Preverimo koliko steklenic je v seznamu
		System.out.println("Na seznamu je " + steklenice.size() + " steklenic.");
		
		// Izpišemo vse steklenice v seznamu
		for (int c=0; c<steklenice.size(); c++) {
		
			System.out.println(c + ". steklenica: " + steklenice.get(c).getZnamkaKolicina() + ", stopnja alkohola: " + steklenice.get(c).getStopnjaAlkohola() + ".");
		
		}
		
		// Skušamo vprašati uporabnika, za koliko naj ohladi pivo in ga ohladiti
		try {
			System.out.print("Za koliko stopinj Celzija naj ohladim pivo: ");
			double temp = Double.parseDouble(in.readLine());
			
			// Pivo ohladimo za vnešeno temperaturo
			velikoLasko.ohladi(temp);
		}
		// Če je bila sporočena izjema
		catch(Exception e) {
			System.out.println("Napaka pri vnosu temperature: " + e);
			System.out.println("Pivo ne bo ohlajeno!");
		}
		
		// Skušamo odpreti in napolniti zeleno steklenico s špricerjem
		try {
			zelenaSteklenica.odpri();
			zelenaSteklenica.napolni(200, "Slatina");
			zelenaSteklenica.napolni(100, "Vino");
		}
		catch(Exception e) {
			System.out.println("Napaka pri polnjenju zelene steklenice: " + e);
		}
		
		// Skušamo rdečo steklenico napolniti z vodo, vendar je zaprta
		try {
			rdecaSteklenica.napolni(500, "Voda");
		}
		catch(Exception e) {
			System.out.println("Napaka pri polnjenju rdeče steklenice: " + e);
		}
	}

}
