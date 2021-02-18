package model.bean;

public class Musica { 
	private int musica_id;
	private String musica_titulo;
	private String musica_cantores;
	private String musica_compositores;
	private String musica_letra;
	private float musica_duracao;
	private boolean musica_nacional;
	
	public int getMusica_id() {
		return musica_id;
	}
	public void setMusica_id(int musica_id) {
		this.musica_id = musica_id;
	}
	public String getMusica_titulo() {
		return musica_titulo;
	}
	public void setMusica_titulo(String musica_titulo) {
		this.musica_titulo = musica_titulo;
	}
	public String getMusica_cantores() {
		return musica_cantores;
	}
	public void setMusica_cantores(String musica_cantores) {
		this.musica_cantores = musica_cantores;
	}
	public String getMusica_compositores() {
		return musica_compositores;
	}
	public void setMusica_compositores(String musica_compositores) {
		this.musica_compositores = musica_compositores;
	}
	public String getMusica_letra() {
		return musica_letra;
	}
	public void setMusica_letra(String musica_letra) {
		this.musica_letra = musica_letra;
	}
	public float getMusica_duracao() {
		return musica_duracao;
	}
	public void setMusica_duracao(float musica_duracao) {
		this.musica_duracao = musica_duracao;
	}
	public boolean isMusica_nacional() {
		return musica_nacional;
	}
	public void setMusica_nacional(boolean musica_nacional) {
		this.musica_nacional = musica_nacional;
	}
	
	

}