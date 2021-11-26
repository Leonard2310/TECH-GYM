package com.catello.product.palestra; //Package che racchiude tutte le classi del programma.

public class Esercizo implements java.io.Serializable { //Implementazione di una classe serializable (Serializable=tutto ciò che è trasportabile in byte).
	private static final long serialVersionUID = 1L;
	
	String nomeEsercizio; //Attributi della classe DatiFisici.
	int tempo;
	int tempoRiposoSerie;
	int serie;
	int eserciziSerie;
	double calorieMedieNecessarie;

	public Esercizo(String nomeEsercizio, int tempo, int tempoRiposoEsercizio, int serie, int eserciziSerie,double calorieMedieNecessarie) { //Costruttore di copia.
		super();
		this.nomeEsercizio= nomeEsercizio;
		this.tempo= tempo;
		this.tempoRiposoSerie= tempoRiposoEsercizio;
		this.serie= serie;
		this.eserciziSerie= eserciziSerie;
		this.calorieMedieNecessarie= calorieMedieNecessarie; }

	public String getNomeEsercizio() { //Getter, metodo modificatore.
		return nomeEsercizio; }

	public void setNomeEsercizio(String nomeEsercizio) { //Setter, metodo di accesso.
		this.nomeEsercizio = nomeEsercizio; }

	public int getTempo() {
		return tempo; }

	public void setTempo(int tempo) {
		this.tempo = tempo; }

	public double getCalorieMedieNecessarie() {
		return calorieMedieNecessarie; }

	public void setCalorieMedieNecessarie(float calorieMedieNecessarie) {
		this.calorieMedieNecessarie = calorieMedieNecessarie; }
	
	public int getTempoRiposoSerie() {
		return tempoRiposoSerie; }

	public void setTempoRiposoSerie(int tempoRiposoSerie) {
		this.tempoRiposoSerie = tempoRiposoSerie; }

	public int getSerie() {
		return serie; }

	public void setSerie(int serie) {
		this.serie = serie; }

	public int getEserciziSerie() {
		return eserciziSerie; }

	public void setEserciziSerie(int eserciziSerie) {
		this.eserciziSerie = eserciziSerie; }

	@Override //Override= possibilità di riscrittura di un metodo ereditato.
	public String toString() { //Metodo toString aggiunge la possibilità di stampare l'oggetto.
		return "\t\t\tEsercizio:" + nomeEsercizio + " " + serie + "X" + eserciziSerie + "   Riposo tra le serie:" + tempoRiposoSerie + "\n"; } }
