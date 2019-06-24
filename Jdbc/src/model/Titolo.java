package model;

public class Titolo {
	
	private int id;
	private String nomeDelTitolo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeDelTitolo() {
		return nomeDelTitolo;
	}
	public void setNomeDelTitolo(String nomeDelTitolo) {
		this.nomeDelTitolo = nomeDelTitolo;
	}
	
	@Override
	public String toString() {
		return "Titolo [id=" + id + ", nomeDelTitolo=" + nomeDelTitolo + "]";
	}

}
