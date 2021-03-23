package ro.itschool.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.itschool.enums.Specializations;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "members")
public class PTrainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column(nullable = false)
	private Specializations specializations;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy= "pTrainer")
	private List<Member> members;

	public PTrainer(String name, String surname, Specializations specializations) {
		super();
		this.name = name;
		this.surname = surname;
		this.specializations = specializations;
	}

}
