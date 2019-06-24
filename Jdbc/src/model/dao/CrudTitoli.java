package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import controller.ConnessioneDatabase;
import model.Titolo;

public class CrudTitoli implements ICRUDT{

	
	ArrayList<Titolo> list = new ArrayList<Titolo>();
	
	@Override
	public ArrayList<Titolo> getTitolo(){
		Connection conn = null;
		try {
			conn = ConnessioneDatabase.getTheConnection();
			Statement s = null;
			String sql = "select * from clienti";
			s = conn.createStatement();
			ResultSet r = s.executeQuery(sql);
			while(r.next()) {
				Titolo t = new Titolo();
				t.setId(r.getInt(1));
				t.setNomeDelTitolo(r.getString(2));
				list.add(t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Titolo> getTitoli(){
		Connection conn = null;
		try {
			conn = ConnessioneDatabase.getTheConnection();
			Statement s = null;
			String sql = "select * from titoli";
			s = conn.createStatement();
			ResultSet r = s.executeQuery(sql);
			while(r.next()) {
				System.out.println(r.getInt(1) + " " + r.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
