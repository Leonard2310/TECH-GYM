package com.catello.product.palestra; //Package che racchiude tutte le classi del programma.

public class DatiFisici implements java.io.Serializable { //Implementazione di una classe serializable (Serializable=tutto ciò che è trasportabile in byte). 
	private static final long serialVersionUID = -5832273946049860949L; 
	

	float altezza; //Attributi della classe DatiFisici.
	float peso;
	float cfrFianchi;
	float cfrCollo;
	float cfrVita;
	float bmi;
	double massaGrassa;
	String sesso;
	
	public DatiFisici(float altezza, float peso, String sesso, float cfrFianchi, float cfrCollo, float cfrVita, float bmi, double massaGrassa) { //Costruttore di copia.
		super();
		this.altezza = altezza;
		this.peso = peso;
		this.cfrFianchi = cfrFianchi;
		this.cfrCollo = cfrCollo;
		this.cfrVita = cfrVita;
		this.bmi = bmi;
		this.sesso = sesso;
		this.massaGrassa = massaGrassa; }
	
	public DatiFisici() { } //Costruttore di default.

	public float getAltezza() { //Getter, metodo modificatore.
		return altezza; }
	
	public void setAltezza(float altezza) { //Setter, metodo di accesso.
		this.altezza = altezza; }
	
	public float getPeso() {
		return peso; }
	
	public void setPeso(float peso) {
		this.peso = peso; }
	
	public float getCfrFianchi() {
		return cfrFianchi; }
	
	public void setCfrFianchi(float cfrFianchi) {
		this.cfrFianchi = cfrFianchi; }
	
	public float getCfrCollo() {
		return cfrCollo; }
	
	public void setCfrCollo(float cfrCollo) {
		this.cfrCollo = cfrCollo; }
	
	public float getCfrVita() {
		return cfrVita; }
	
	public void setCfrVita(float cfrVita) {
		this.cfrVita = cfrVita; }
	
	public float getBmi() {
		return bmi; }
	
	public void setBmi(float bmi) {
		this.bmi = bmi; }
	
	public double getMassaGrassa() {
		return massaGrassa; }
	
	public void setMassaGrassa(double massaGrassa) {
		this.massaGrassa = massaGrassa; }
	
	public String getSesso() {
		return sesso; }
	
	public void setSesso(String sesso) {
		this.sesso = sesso; }

	@Override //Override= possibilità di riscrittura di un metodo ereditato.
	public String toString() { //Metodo toString aggiunge la possibilità di stampare l'oggetto.
		return "sesso:" + sesso + ", altezza:" + altezza + "; peso:" + peso + "; cfrCollo:"
				+ cfrCollo + "; cfrVita:" + cfrVita + ", cfrFianchi=" + cfrFianchi + ", bmi:" + bmi + "; massa Grassa:" + massaGrassa +"%"; } }
		
