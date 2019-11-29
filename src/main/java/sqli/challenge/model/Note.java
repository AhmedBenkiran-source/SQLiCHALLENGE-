package sqli.challenge.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Note implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NoteId pk = new NoteId();
	
	private String description;
	
	
	public NoteId getPk() {
		return pk;
	}
	public void setPk(NoteId pk) {
		this.pk = pk;
	}
	@Transient
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
