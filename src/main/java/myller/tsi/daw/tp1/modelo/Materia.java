package myller.tsi.daw.tp1.modelo;

public class Materia {
	private long idMateria;
	private String nomeMateria;
	private int serie;
	private Disciplina disciplina;
	
	public long getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(long idMateria) {
		this.idMateria = idMateria;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
