package oneToMany.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntiteGenerique {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
}
