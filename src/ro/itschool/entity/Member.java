package ro.itschool.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Member")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private Date dateOfBirth;

	@ManyToOne(cascade = CascadeType.ALL)
	private PTrainer pTrainer;

	public Member(String name, String surname, Date dateOfBirth, PTrainer pTrainer) {
		super();
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.pTrainer = pTrainer;
	}

}
