package kr.ac.hansung.model;

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

public class Course {
	
	private int id;
	private int years;
	private int semester;
	@NotEmpty(message="The coursecode cannot be empty")
	private String coursecode;
	@NotEmpty(message="The coursename cannot be empty")
	private String coursename;
	@NotEmpty(message="The division cannot be empty")
	private String division;
	private int grades;

}
