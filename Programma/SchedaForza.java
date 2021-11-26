package com.catello.product.palestra; //Package che racchiude tutte le classi del programma.

public class SchedaForza extends SchedaGenerica { //Implementazione di una classe serializable (Serializable=tutto ciò che è trasportabile in byte).
	private static final long serialVersionUID = 1L;
	
	static final int tempoRecupero =60;  //Tempo di recupero costante.
	
	public SchedaForza() {
		super(); //Super= esegue il costruttore della superclasse.
		this.listaEsercizi.add(new Esercizo("Leg Press", 6, 105, 8, 5, 0.4));
		this.listaEsercizi.add(new Esercizo("Squat Bilanciere", 5, 105, 6, 5, 1.5));
		this.listaEsercizi.add(new Esercizo("Pulley Triangolo", 8, 105, 8, 5, 0.5));
		this.listaEsercizi.add(new Esercizo("Shoulder Press", 6, 105, 3, 8, 0.4)); 
		this.listaEsercizi.add(new Esercizo("Panca Piana", 5, 105, 8, 10, 0.5)); }

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
		return "Scheda Forza:\n" + listaEsercizi + "\n\t\t\t Data di inizio: " + dataInizioScheda
				+ ", Tempo:" + (getTempoTotale()/60) + "min, Calorie necessarie:" + CalorieNecessarie() + "kcal"; } }
