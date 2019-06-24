package model;

public class Persone {
	
	private int id;
	private String nome;
	private String cognome;
	private Titolo titoli;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Titolo getTitoli() {
		return titoli;
	}
	public void setTitoli(Titolo titoli) {
		this.titoli = titoli;
	}
	@Override
	public String toString() {
		return "Persone [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
	
}
