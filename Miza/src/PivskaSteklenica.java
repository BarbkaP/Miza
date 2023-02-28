/*
	Ime datoteke: 	PivskaSteklenica.java
	Avtor:			Barbka Podbregar
*/

// Deklariramo javni razred, ki razširja razred Steklenica
// in implementira vmesnik AlkoholnaPijaca
public class PivskaSteklenica extends Steklenica implements AlkoholnaPijaca {

	// Vse lastnosti od nadrazreda se prenesejo
	// Deklariramo nove lastnosti
	private String znamka;
	private boolean jePovratna;
	private double temperatura;		// v stopnijah celzija
	private double stopnjaAlkohola;
	
	// Javni konstruktor
	// Vhodni parametri: z - znamka, k - kapaciteta, s - stopnja alkohola
	// Potek/opis: ustvari nov objekt tipa PivskaSteklenica (predvidevamo, da ni povratna)
	// Vrne vrednost: nov objekt
	public PivskaSteklenica(String z, int k, double s) {
	
		// Tukaj ne sme biti nič drugega
		
		// Pokličemo konstruktor nadrazreda - ustvarimo prazno steklenico
		super(k);
		
		// Napolnimo steklenico - pokličemo metodo, deklarirano v nadrazredu
		odpri();
		try {
			napolni(k, "Pivo");
		}
		catch(Exception e) {
			System.out.println("Napaka pri uvodnem polnjenju nove steklenice: " + e);
		}
		zapri();
		
		// Inicializiramo še ostale lastosti
		znamka = z;
		jePovratna = false;
		temperatura = 22.0;
		stopnjaAlkohola = s;
		
	}
	
	// Javna metoda, ki ohladi pivo za želeno temperaturo [st. C]
	// Vhodni parametri: t - temperatura
	// Potek/opis: zniža temperaturo
	// Vrne vrednost: /
	public void ohladi(double t) {
	
		System.out.print("Hladim pivo " + znamka + " iz " + temperatura + " na ");
	
		// Znižamo temperaturo piva
		temperatura -= t;
		
		System.out.println(temperatura + " st. C.");
	
	}

	// Javna getter metoda, ki vrne znamko in količino
	// Vhodni parametri: /
	// Potek/opis: vrne vrednosti
	// Vrne vrednost: niz z znamko in količino vsebine
	public String getZnamkaKolicina() {
	
		return znamka + ", " + getKolicinaVsebine() + " ml";
	
	}
	
	// Implementiramo metodo, ki vrne stopnjo alkohola 
	// in jo predpisuje vmesnik AlkoholnaPijaca
	// Vhodni parametri: /
	// Potek/opis: vrne stopnjo
	// Vrne vrednost: double - stopnja alkohola
	public double getStopnjaAlkohola() {
	
		return stopnjaAlkohola;
	
	}
}
