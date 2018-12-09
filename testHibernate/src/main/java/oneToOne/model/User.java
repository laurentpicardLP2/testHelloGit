package oneToOne.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User implements Serializable {

	// default serial
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "UserID")
	private Long id;

	@MapsId()
	@OneToOne(optional=true, cascade=CascadeType.REMOVE)
    private Profile profile;


	@NotNull
	@Size(max = 65)
	@Column(name = "Name")
	private String theName;

	@Size(max = 65)
	@Column(name = "Email")
	private String email;
	

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(@NotNull @Size(max = 65) String name, @Size(max = 65) String email) {
		this.theName = name;
		this.email = email;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
		
	}

}