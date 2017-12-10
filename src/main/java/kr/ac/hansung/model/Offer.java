package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {

	private int id;

	@NotEmpty(message="The year cannot be empty")
	private int year;
	@NotEmpty(message="The term cannot be empty")
	private int term;
	@NotEmpty(message="The cord cannot be empty")
	private String cord;
	@NotEmpty(message="The name cannot be empty")
	private String name;
	@NotEmpty(message="The type cannot be empty")
	private String type;
	private double grade;
	
/*	@Size(min=2, max=100, message="Name must be between 2 and 100 chars")
	private String name;
	@Email(message="Please provide a valid email address")
	@NotEmpty(message="The email address cannot be empty")
	private String email;
	@Size(min=5, max=100, message="Name must be between 5 and 100 chars")
	private String text;*/
}
