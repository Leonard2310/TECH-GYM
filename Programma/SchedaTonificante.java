package com.catello.product.palestra; //Package che racchiude tutte le classi del programma.

public class SchedaTonificante extends SchedaGenerica { //Implementazione di una classe serializable (Serializable=tutto ciò che è trasportabile in byte).
	private static final long serialVersionUID = 1L;
	
	static final int tempoRecupero =120;  //Tempo di recupero costante.
	
	public SchedaTonificante() {
		super(); //Super= esegue il costruttore della superclasse.
		this.listaEsercizi.add(new Esercizo("Cyclette", 600, 105, 3, 1, 69));
		this.listaEsercizi.add(new Esercizo("Stepper", 3, 105, 4, 15, 0.4));
		this.listaEsercizi.add(new Esercizo("Squat Machine", 6, 105, 4, 20, 1.4));
		this.listaEsercizi.add(new Esercizo("Abductor Machine", 3, 105, 4, 20, 0.3));
		this.listaEsercizi.add(new Esercizo("Leg Press", 6, 105, 4, 20, 0.4));
		this.listaEsercizi.add(new Esercizo("Piegamenti", 5, 105, 3, 5,  0.75));
		this.listaEsercizi.add(new Esercizo("Panca Piana", 5, 105, 4, 10, 0.5)); }

	public int getTempoTotale(){ //Metodo per il calcolo del Tempo Totale.
		int tempoTotale = 0;
		
		for (Esercizo esercizio:listaEsercizi)
			tempoTotale += (esercizio.tempo+esercizio.tempoRiposoSerie*esercizio.getSerie()+tempoRecupero);
		return tempoTotale; }
	
	public double CalorieNecessarie(){ //Metodo per il calcolo delle Calorie Necessarie.
		double calorieNecessarie = 0;
		
		for(Esercizo esercizio:listaEsercizi) {
			calorieNecessarie += (esercizio.calorieMedieNecessarie*esercizio.getSerie()*esercizio.getSerie()); }
		return calorieNecessarie; }

	@Override //Override= possibilità di riscrittura di un metodo ereditato.
	public String toString() { //Metodo toString aggiunge la possibilità di stampare l'oggetto.
		return "Scheda Tonificante:\n" + listaEsercizi + "\n\t\t\t Data di inizio: " + dataInizioScheda
				+ ", Tempo:" + (getTempoTotale()/60) + "min, Calorie necessarie:" + CalorieNecessarie() + "kcal]"; } }
