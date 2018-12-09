package oneToOne.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Profiles")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Gender {
		M,
		F
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProfileID")
	public Long id;

	@Size(max = 255)
	@Column(name = "Address")
	private String address;

	@Column(name = "DateOfBirth")
	private LocalDate dateOfBirth;

	@Size(max = 10)
	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Gender gender;

	public Profile() {
		// TODO Auto-generated constructor stub
	}

	public Profile(@Size(max = 255) String address1, LocalDate dateOfBirth,
			@Size(max = 10) String phoneNumber, Gender gender) {
		this.address = address1;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

}