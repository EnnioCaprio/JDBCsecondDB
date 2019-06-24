package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Controller;
import model.Persone;
import model.Titolo;
import model.dao.CrudStudenti;
import model.dao.CrudTitoli;

public class View {

	Scanner input = new Scanner(System.in);

	CrudStudenti c = new CrudStudenti();

	Controller co = new Controller();

	CrudTitoli ct = new CrudTitoli();

	public static int ricerca;

	public static int size;

	public void view(Persone p, Titolo t) throws SQLException {
		boolean light = true;

		int scelta;

		while(light) {
			c.countUsers(p);
			ArrayList<Titolo> list = ct.getTitoli();
			for(Titolo l : list) {
				System.out.println(l);
			}
			System.out.println("Scegli 0-Inserisci, 1-Leggi, 2-Update, 3-Delete, 4-Read Single User");
			System.out.println("Lunghezza " + "= " + size);
			scelta = Integer.parseInt(input.nextLine());
			switch(scelta) {
			case 0: System.out.println("Inserimento");
			co.inserimentoInput(p, t);
			c.inserimento(p,t);
			break;
			case 1: if(size > 0) {
				System.out.println("Lettura");
				co.letturaUtenti(p);
				c.leggiUtenti(p);
			}else {
				System.out.println("Lunghezza non esistente");
			}
			break;
			case 2: if(size > 0) {
				System.out.println("Update");
				co.updateUtenti(p);
				c.updateUtenti(p);
			}else {
				System.out.println("Lunghezza non esistente");
			}
			break;
			case 3: if(size > 0) {
				System.out.println("Delete");
				co.deleteUtenti(p);
				c.deleteUtenti(p);
			}else {
				System.out.println("Lunghezza non esistente");
			}
			break;
			case 4: if(size > 0) {
				System.out.println("Single user");
				co.leggiSingoloUtente(p);
				c.ricercaUtente(p);
			}else {
				System.out.println("Lunghezza non esistente");
			}
			break;
			case 100: System.out.println("Exit");
			light = false;
			break;
			default: System.out.println("Non c'è questa specifica scelta !");
			}
		}
	}

}
