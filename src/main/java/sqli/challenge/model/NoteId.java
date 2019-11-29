package sqli.challenge.model;



import javax.persistence.ManyToOne;



public class NoteId implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Activite activite;
	@ManyToOne
	private Sejour sejour;
	
	public Activite getActivite() {
		return activite;
	}
	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	
	public Sejour getSejour() {
		return sejour;
	}
	public void setSejour(Sejour sejour) {
		this.sejour = sejour;
	}
	
}
