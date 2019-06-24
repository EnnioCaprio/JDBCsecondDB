package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import java.sql.*;

import controller.ConnessioneDatabase;
import model.Persone;
import model.Titolo;
import view.View;


public class CrudStudenti implements ICRUDS{

	@Override
	public boolean inserimento(Persone p, Titolo t) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnessioneDatabase.getTheConnection();
			PreparedStatement ps = null;
			String sql = "insert into studenti (nome, cognome, Titoli_id) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getNome()); 
			ps.setString(2, p.getCognome());
			ps.setInt(3, p.getTitoli().getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			conn.close();
		}
		return true;
	}

	@Override
	public boolean leggiUtenti(Persone p) throws SQLException {
		Connection connection = null;
		try {
			connection = ConnessioneDatabase.getTheConnection();
			Statement s = null;
			String sql = "select * from studenti";
			s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {

				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getString(4));
			}
			s.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
			connection.close();
		}
		return true;
	}

	@Override
	public boolean updateUtenti(Persone p) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnessioneDatabase.getTheConnection();
			PreparedStatement ps = null;
			String sql = "update studenti set nome=?, cognome=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCognome());
			ps.setInt(3, p.getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			conn.close();
		}
		return true;
	}

	@Override
	public boolean deleteUtenti(Persone p) throws SQLException {
		boolean light = true;
		Connection conn = null;
		try {
			conn = ConnessioneDatabase.getTheConnection();
			PreparedStatement ps = null;
			Statement s = null;
			String sql = "delete from studenti where id=?";
			String sql2 = "SELECT id FROM studenti ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql2);
			while(rs.next()) {
				if(rs.getInt(1) == p.getId()) {
					ps.executeUpdate();
					light = true;
				}else {
					light = false;
				}
			}
			if(light == false) {
				System.out.println("Non esiste l'id");
			}
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			conn.close();
		}
		return true;
	}

	@Override
	public boolean ricercaUtente(Persone p) {
		Connection conn = null;
		String sql = null;
		try {
			conn = ConnessioneDatabase.getTheConnection();
			PreparedStatement ps = null;
			if(View.ricerca == 1) {
				sql = "select * from studenti where id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, p.getId());
			}else if(View.ricerca == 3) {
				sql = "select * from studenti where nome = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, p.getNome());
			}else if(View.ricerca == 6) {
				sql = "select * from studenti where cognome = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, p.getCognome());
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean countUsers(Persone p) {
		Connection conn = null;
		try {
			conn = ConnessioneDatabase.getTheConnection();
			Statement s = null;
			String sql = "SELECT count(id) FROM studenti";
			s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				if(rs.getInt(1) > 0) {
					View.size = rs.getInt(1);
				}else {
					View.size = 0;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
