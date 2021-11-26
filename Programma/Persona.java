package com.catello.product.palestra; //Package che racchiude tutte le classi del programma.

import java.util.ArrayList; //Libreria per i vettori.

public class Persona implements java.io.Serializable { //Implementazione di una classe serializable (Serializable=tutto ciò che è trasportabile in byte).
	private static final long serialVersionUID = 1L;
	
	int id; //Attributi della classe DatiFisici.
	String nome;
	String cognome;
	String telefono;
	String comune;
	String indirizzoResidenza;
	String email;
	
	Scheda schedaCorrente;
	static DatiFisici datiFisici; //Importazione dei dati fisici.
	String classificazione = "";

	ArrayList schedeHistory; //Array per lo storico delle schede.
	ArrayList progressoHistory; //Array per lo storico dei dati fisici.
	
	public Persona(String nome, String cognome, String telefono, String comune, String indirizzoResidenza, String email) { //Costruttore di copia.
		super(); //Super= esegue il costruttore della superclasse.
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.comune = comune;
		this.indirizzoResidenza = indirizzoResidenza;
		this.email = email;
		
		this.datiFisici= new DatiFisici();
		this.setId(Utility.getSequence()); 
		this.schedeHistory = new ArrayList();
		this.progressoHistory = new ArrayList(); }

	public Persona() { //Costruttore di default.
		this.datiFisici= new DatiFisici();
		this.schedeHistory = new ArrayList();
		this.progressoHistory = new ArrayList(); }

	public void setId(int id) { //Setter, metodo di accesso.
		this.id = id; }
	
	public int getId() { //Getter, metodo modificatore.
		return id; }
	
	public String getNome() {
		return nome; }
	
	public void setNome(String nome) {
		this.nome = nome; }
	
	public String getCognome() {
		return cognome; }
	
	public void setCognome(String cognome) {
		this.cognome = cognome; }
	
	public String getTelefono() {
		return telefono; }
	
	public void setTelefono(String telefono) {
		this.telefono = telefono; }
	
	public String getIndirizzoResidenza() {
		return indirizzoResidenza; }
	
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza; }
	
	public String getEmail() {
		return email; }
	
	public void setEmail(String email) {
		this.email = email; }

	public Scheda getSchedaCorrente() {
		return schedaCorrente; }
	
	public void setSchedaCorrente(Scheda schedaCorrente) {
		this.schedaCorrente = schedaCorrente; }
	
	public static DatiFisici getDatiFisici() {
		return datiFisici; }
	
	public void setDatiFisici(DatiFisici datiFisici) {
		this.datiFisici = datiFisici; }
	
	public ArrayList getSchedeHistory() {
		return schedeHistory; }
	
	public void setSchedeHistory(ArrayList schedeHistory) {
		this.schedeHistory = schedeHistory; }
	
	public ArrayList getProgressoHistory() {
		return progressoHistory; }
	
	public void setProgressoHistory(ArrayList progressoHistory) {
		this.progressoHistory = progressoHistory; }
	
	public String getClassificazione() {
		return classificazione; }

	public void setClassificazione(String classificazione) {
		this.classificazione = classificazione; }
	
	public String getComune() {
		return comune; }

	public void setComune(String comune) {
		this.comune = comune; }

	@Override //Override= possibilità di riscrittura di un metodo ereditato.
	public String toString() { //Metodo toString aggiunge la possibilità di stampare l'oggetto.
		return "ID:" + id + "; nome:" + nome + "; cognome:" + cognome + "; telefono:" + telefono
				+ "; indirizzo di residenza:" +indirizzoResidenza + ", " +comune + "; e-mail=" + email +
				"\n\t\t\t\t" + datiFisici;} 
	
	
	public String toStringForVisualizza() {
		return "ID:" + id + "; nome:" + nome + "; cognome:" + cognome + "; telefono:" + telefono
				+ "; indirizzo di residenza:" +indirizzoResidenza + ", " +comune + "; e-mail=" + email;} 

}
