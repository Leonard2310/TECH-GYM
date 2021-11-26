package com.catello.product.palestra; //Package che racchiude tutte le classi del programma.

import java.util.ArrayList; //Libreria per i vettori.
import java.util.Scanner; //Libreria per lo scanner.

public class PalestraUI { //Classe PalestraUserInterface.

	public static ArrayList<Persona> personeIscritte = null; //Inizializzazione array
		

	private static void inizializzazionePalestra() { //Carica oggetto a file o inizializza a codice.
		ArrayList palestra = Utility.caricaObject();
		
		if(palestra!=null) 
			personeIscritte = (ArrayList)palestra;
			else
				personeIscritte = new ArrayList(); }

	public static void main(String[] args) { //Main
		inizializzazionePalestra(); //Chiamata funzione per inizializzare la palestra nel file.
		displayMenuGenerale(); } //Chiamata funzione per il menù

	private static void displayMenuGenerale(){ //Funzione menù
		Scanner in = new Scanner(System.in); //Creazione Scanner
		int scelta,scelta1 = 0; //Inizializzazione variabili per il ciclo di iterazione post-condizionato do-while e lo switch.
		
		do { //Inizio ciclo di iterazione post-condizionata per ripetere il programma.
			System.out.println("\t\tBenvenuto nella Tech-Gym, la palestra del futuro!");
			System.out.println("\t 1=ISCRIVI UTENTE \t 2=VISUALIZZA UTENTE \t 3=ASSESTMENT \t 4=VISUALIZZA PERSONE ISCRITTE");
			scelta= in.nextInt();
				
			switch(scelta){
				case 1: 
						iscriviPersona(); //Chiamata funzione per iscrivere un nuovo utente.
						Utility.salvaObject(personeIscritte); //Salvataggio nuovo utente sul file.
						break;
					
				case 2: 
						visualizzaSchedaDellaPersona(); //Chiamata funzione per visualizzare dati utente già registrato.
						break;
					
				case 3:
						nuovoAssestment(); //Chiamata funzione per aggiornare i dati della persona.
						Utility.salvaObject(personeIscritte); //Salvataggio dati cambiati.
						break;
						
				case 4:
						visualizzaPersona();
						break;
						
				default: 
						System.out.println("\t\t VALORE NON VALIDO"); //Messaggio di default se viene immesso valore non valido.
						break; }
						
					do{ //Inizio ciclo di iterazione post-condizionato se non viene inserito un carattere valido alla domanda sulla ripetizione del programma.
						  System.out.println("\n\n\tVUOI RIPETERE IL PROGRAMMA? DIGITA 1/2 (1=SI,2=NO): "); 
						  scelta1=in.nextInt(); }         
					while(scelta1!=1&&scelta1!=2);
					System.out.println(""); } 
			while(scelta1==1); }

	private static Persona iscriviPersona(){ //Funzione per l'iscrizione di un nuovo utente
		Scanner scanner = new Scanner(System.in);
		Persona persona = new Persona(); //Creazione dell'oggetto persona.
		
		persona.setId(personeIscritte.size()+1); //Creazione dell'ID sequenziale identificativo.
		
		int scelta,scelta1 = 0;
	
		do { //Inizio ciclo di iterazione post-condizionata per ripetere il programma.
				System.out.println("\t ISCRIZIONE DEL NUOVO MEMBRO, INSERISCI I SEGUENTI DATI: ");
				System.out.print("Nome: ");
				persona.setNome(scanner.nextLine()); //Carica degli attributi tramite scanner.
				System.out.print("Cognome: ");
				persona.setCognome(scanner.nextLine());
				System.out.print("E-mail: ");
				persona.setEmail(scanner.nextLine());
				System.out.print("Telefono: ");
				persona.setTelefono(scanner.nextLine());
				System.out.print("Comune di Residenza: ");
				persona.setComune(scanner.nextLine());
				System.out.print("Indirizzo di Residenza: ");
				persona.setIndirizzoResidenza(scanner.nextLine());
				System.out.print("Sesso (femminile/maschile): ");
				persona.getDatiFisici().setSesso(scanner.nextLine());
				System.out.print("Altezza (cm): ");
				persona.getDatiFisici().setAltezza(scanner.nextFloat());
				System.out.print("Peso (kg): ");
				persona.getDatiFisici().setPeso(scanner.nextFloat());
				System.out.print("Circonferenza Collo (cm): ");
				persona.getDatiFisici().setCfrCollo(scanner.nextFloat());
				System.out.print("Circonferenza Vita (cm): ");
				persona.getDatiFisici().setCfrVita(scanner.nextFloat());
				System.out.print("Circonferenza Fianchi (cm): ");
				persona.getDatiFisici().setCfrFianchi(scanner.nextFloat()); 
				do{ //Inizio ciclo di iterazione post-condizionato se non viene inserito un carattere valido alla domanda sulla ripetizione del programma.
		            System.out.println("\n\n\tCONFERMI I DATI INSERITI? DIGITA 1/2 (1=SI,2=NO): ");        
		            scelta1=scanner.nextInt(); }
				while(scelta1!=1&&scelta1!=2);
				System.out.println("  "); }
		while(scelta1==2);
		Scheda scheda = Utility.SchedaConsigliata(persona); //Chiamata della funzione per il calcolo del BMI della massa grassa e della classificazione, quindi della scheda consigliata.
		System.out.println("\nI DATI INSERITI SONO: "+persona); //Stampa dei dati della persona.
		System.out.println("\nLA SCHEDA CONSIGLIATA E`: "+scheda); //Stampa della scheda.
		
		personeIscritte.add(persona); //Aggiunta della persona alla lista delle persone iscritte.
		return persona; }
	
	
	private static void visualizzaSchedaDellaPersona(){ //Funzione per visualizzare i dati di un utente già registrato.
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID="); 
		int idPersona= scanner.nextInt(); 
		
		for (Persona personaDaVisualizzare1:personeIscritte ) //Ricerca tramite dell'ID inserito tra quelli salvati nel file.
			if (personaDaVisualizzare1.id == idPersona){ //Selezione per stampare i dati dell'ID corrispondente
				System.out.println("\nLA SCHEDA ASSOCIATA ALL`ID "+ idPersona +" E`: "+personaDaVisualizzare1.getSchedaCorrente()); 
				System.out.println("\nLA HISTORY ASSOCIATA ALL`ID "+ idPersona +" E`: "+personaDaVisualizzare1.getSchedeHistory().toString()); 
				System.out.println("\nIL PROGRESSO ASSOCIATO ALL`ID "+ idPersona +" E`: "+personaDaVisualizzare1.getProgressoHistory().toString());} }
	
	private static void visualizzaPersona(){ //Funzione per stampare a schermo tutte le persone iscritte.
		System.out.println("LA LISTA DELLE PERSONE ISCRITTE E`: ");
		for (Persona personaDaVisualizzare1:personeIscritte ){
				System.out.println(""+ personaDaVisualizzare1.toStringForVisualizza()); } }
	
	
	private static void nuovoAssestment(){ //Funzione per l'aggiornamento dei dati di una persona e assegnazione di una nuova scheda.
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID=");
		int idPersona= scanner.nextInt();
		
		for (Persona persona:personeIscritte )
			if (persona.id == idPersona){
				System.out.println("AGGIORNAMENTO DATI FISICI E SCHEDA DELL`ID "+ idPersona);
				System.out.println("--> "+ persona);
				DatiFisici nuovoDatiFisici = new DatiFisici(persona.getDatiFisici().getAltezza(),persona.getDatiFisici().getPeso(),persona.getDatiFisici().getSesso(), persona.getDatiFisici().getCfrFianchi(),persona.getDatiFisici().getCfrCollo(), persona.getDatiFisici().getCfrVita(), persona.getDatiFisici().getBmi(), persona.getDatiFisici().getMassaGrassa()); //Creazione di un nuovo oggetto dati fisici.
				
				System.out.print("Altezza (cm)=");
				nuovoDatiFisici.setAltezza(scanner.nextFloat());
				System.out.print("Peso (kg)=");
				nuovoDatiFisici.setPeso(scanner.nextFloat());
				System.out.print("Circonferenza Collo (cm)=");
				nuovoDatiFisici.setCfrCollo(scanner.nextFloat());
				System.out.print("Circonferenza Vita (cm)=");
				nuovoDatiFisici.setCfrVita(scanner.nextFloat());
				System.out.print("Circonferenza Fianchi (cm)=");
				nuovoDatiFisici.setCfrFianchi(scanner.nextFloat()); 
				System.out.println("L`ID E I DATI INSERITI SONO: "+persona);
			    persona.setDatiFisici(nuovoDatiFisici);
				Scheda scheda = Utility.SchedaConsigliata(persona);
				System.out.println("LA SCHEDA CONSIGLIATA E`: "+scheda); } } }


