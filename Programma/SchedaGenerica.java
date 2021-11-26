package com.catello.product.palestra; //Package che racchiude tutte le classi del programma.

import java.util.ArrayList; //Libreria per usare gli array.
import java.util.Date; //Libreria per aggiungere la data.
public class SchedaGenerica implements Scheda,java.io.Serializable{ //Implementazione di una classe serializable (Serializable=tutto ciò che è trasportabile in byte).
	private static final long serialVersionUID = 1L;
	
	ArrayList<Esercizo> listaEsercizi;
	Date dataInizioScheda = new Date(); 

	public SchedaGenerica() {
		super(); //Super= esegue il costruttore della superclasse.
		listaEsercizi = new ArrayList();
		Date dataInizioScheda = new Date(); }

	public ArrayList<Esercizo> getListaEsercizi() {
		return listaEsercizi; }

	public void setListaEsercizi(ArrayList<Esercizo> listaEsercizi) {
		this.listaEsercizi = listaEsercizi; }
	
	public int getTempoTotale(){  //Metodo per il calcolo del Tempo Totale.
		int tempoTotale = 0;
		
		for (Esercizo esercizio:listaEsercizi)
			tempoTotale += (esercizio.tempo+esercizio.tempoRiposoSerie);
		return tempoTotale; }
	
	public float getCalorieNecessarie(){  //Metodo per il calcolo delle Calorie Necessarie.
		float calorieNecessarie = 0;
		
		for (Esercizo esercizio:listaEsercizi)
			calorieNecessarie += esercizio.calorieMedieNecessarie;
		return calorieNecessarie; }
	
	@Override //Override= possibilità di riscrittura di un metodo ereditato.
	public String toString() { //Metodo toString aggiunge la possibilità di stampare l'oggetto.
		return "SchedaGenerica [listaEsercizi=" + listaEsercizi + ", dataInizioScheda=" + dataInizioScheda + "]"; } }