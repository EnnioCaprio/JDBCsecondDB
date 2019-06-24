package model.dao;

import java.sql.SQLException;

import model.Persone;
import model.Titolo;

public interface ICRUDS {
	
	public boolean inserimento(Persone p, Titolo t) throws SQLException;
	
	public boolean leggiUtenti(Persone p) throws SQLException;
	
	public boolean updateUtenti(Persone p) throws SQLException;
	
	public boolean deleteUtenti(Persone p) throws SQLException;
	
	public boolean ricercaUtente(Persone p);
	
	public boolean countUsers(Persone p);

}
