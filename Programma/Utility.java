package com.catello.product.palestra; //Package che racchiude tutte le classi del programma.

import java.io.File; //Libreria per salvare su file le persone iscritte.
import java.io.FileInputStream; //Libreria per scanner.
import java.io.FileNotFoundException; //Libreria per le eccezzioni.
import java.io.FileOutputStream; //Libreria per la lettura su file.
import java.io.IOException; //Libreria per le eccezzioni.
import java.io.ObjectInputStream; //Libreria per la scrittura di un oggetto su un file.
import java.io.ObjectOutputStream; //Libreria per la lettura di un oggetto su un file.
import java.util.ArrayList; //Libreria per gli array.
import java.math.*; //Libreria matematica.

public class Utility { //Classe per implementazione della sequenza per l'ID.
	private static int sequence=0;
	
	public static int getSequence(){
		sequence++;
		return sequence; }
	
	
	public static Scheda SchedaConsigliata(Persona persona){ //Metodo per scheda consigliata a seconda del BMI e della classificazione.
		Scheda scheda = null;
		
		float bmi= (persona.getDatiFisici().getPeso()/((persona.getDatiFisici().getAltezza()/100)*(persona.getDatiFisici().getAltezza()/100))); //Calcolo BMI.
		persona.getDatiFisici().setBmi(bmi); 


		String classificazione = classificazione(persona.getDatiFisici().getBmi());
		persona.setClassificazione(classificazione);
		massaGrassa(persona);
		
		if (classificazione.equals("sottopeso")){
			System.out.println("SchedaConsigliata-->classificazione: sottopeso");
			scheda = new SchedaMassa(); 
			System.out.println("SchedaConsigliata-->SchedaMassa"); }
		
		if (classificazione.equals("normale")){
			System.out.println("SchedaConsigliata-->classificazione: normale");
			scheda = new SchedaDefinizione();
			System.out.println("SchedaConsigliata-->SchedaDefinizione"); } 
		
		if (classificazione.equals("sovrappeso")){
			System.out.println("SchedaConsigliata-->classificazione: sovrappeso");
			scheda = new SchedaForza(); 
			System.out.println("SchedaConsigliata-->SchedaForza"); } 
		
		if (classificazione.equals("obeso")){
			System.out.println("SchedaConsigliata-->classificazione: obeso");
			scheda = new SchedaTonificante(); 
			System.out.println("SchedaConsigliata-->SchedaTonificante"); } 
	
		persona.setSchedaCorrente(scheda);
		persona.getSchedeHistory().add(scheda);
		persona.getProgressoHistory().add(persona.getDatiFisici());
		return scheda; }

	
	public static String classificazione(float bmi){ //Metodo per classificazione attraverso BMI.
		if (bmi<=18.4) {
			return "sottopeso"; }
		else if ((18.4<bmi) && (bmi<=24.9)) {
			return "normale"; }
		else if ((24.9<bmi) && (bmi<=30)) {
			return "sovrappeso"; }
		else {
			return "obeso"; } }
	
	public static double massaGrassa(Persona persona){ //Metodo per calcolo massa grassa.
		double massaGrassa;
		
		if (Persona.getDatiFisici().getSesso()== "maschile") { //calcolo massa grassa con metodo di Wilmore e Behnke
			massaGrassa= (495/(1.0324-0.19077*(Math.log(Persona.getDatiFisici().getCfrVita()-Persona.getDatiFisici().getCfrCollo()))+0.15456*(Math.log(Persona.getDatiFisici().getAltezza()))))-450; 
			Persona.getDatiFisici().setMassaGrassa(massaGrassa); }
		else {
			massaGrassa= (495/(1.29579-0.35004*(Math.log(persona.getDatiFisici().getCfrVita()+persona.getDatiFisici().getCfrFianchi()-persona.getDatiFisici().getCfrCollo()))+0.22100*(Math.log(persona.getDatiFisici().getAltezza()))))-450;
			Persona.getDatiFisici().setMassaGrassa(massaGrassa); }
				 
		return massaGrassa; }
	
	
	public static void salvaObject(ArrayList o){ //Scrittura oggetto su file.
		try { 
			FileOutputStream fos = new FileOutputStream(new File("Tech-Gym2")); 
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close(); }
		catch (FileNotFoundException e) {
			System.out.println("file non trovato"); }
		catch (IOException e) {
			e.printStackTrace(); } }
	

	public static ArrayList caricaObject(){ //Lettura oggetto dal file.
		ArrayList  result =null;
		try { 
			FileInputStream fis = new FileInputStream(new File("Tech-Gym2"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			result =  ((ArrayList)ois.readObject());
			ois.close(); }
		catch (FileNotFoundException e) {
			System.out.println("file non trovato"); }
		catch (IOException e) {
			e.printStackTrace(); }
		catch (ClassNotFoundException e) {
			e.printStackTrace(); }
		
		return result; } }
