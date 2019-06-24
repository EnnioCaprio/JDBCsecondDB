package controller;

import java.sql.SQLException;
import java.util.Scanner;

import model.Persone;
import model.Titolo;
import model.dao.CrudStudenti;
import view.View;

public class Controller {

	CrudStudenti c = new CrudStudenti();

	Scanner input = new Scanner(System.in);

	public void inserimentoInput(Persone p, Titolo t) {
		System.out.println("Inserisci nome");
		p.setNome(input.nextLine());
		System.out.println("Inserisci cognome");
		p.setCognome(input.nextLine());
		System.out.println("Inserisci il id del foglio");
		t.setId(Integer.parseInt(input.nextLine()));
		p.setTitoli(t);
		System.out.println("---");
		System.out.println("Inserimento completato");
	}

	public void letturaUtenti(Persone p) throws SQLException {
		
	}

	public void updateUtenti(Persone p) {
		System.out.println("Cosa vuoi modificare?");
		p.setId(Integer.parseInt(input.nextLine()));
		System.out.println("Nome");
		p.setNome(input.nextLine());
		System.out.println("Cognome");
		p.setCognome(input.nextLine());
		System.out.println("---");
		System.out.println("Aggiornato");
	}

	public void deleteUtenti(Persone p) {
		System.out.println("Chi vuoi eliminare");
		p.setId(Integer.parseInt(input.nextLine()));
	}

	public void leggiSingoloUtente(Persone p) {
		System.out.println("Modifica ricerca: ");
		View.ricerca = Integer.parseInt(input.nextLine());
		System.out.println("Chi vuoi vedere");	
		if(View.ricerca == 1) {
			System.out.println("Inserire id");
			p.setId(Integer.parseInt(input.nextLine()));
		}else if(View.ricerca == 3) {
			System.out.println("Inserisci nome");
			p.setNome(input.nextLine());
		}else if(View.ricerca == 6) {
			System.out.println("Inserisci cognome");
			p.setCognome(input.nextLine());
		}
	}

}
