package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class SplitGrades {
	
	private int Divisiongrades1; //교필
	private int Divisiongrades2; //일교
	private int Divisiongrades3; //전기
	private int Divisiongrades4; //핵교A
	private int Divisiongrades5; //핵교B
	private int Divisiongrades6; //전선
	private int Divisiongrades7; //자율
	private int Divisiongrades8; //인재
	private int totalDivisionGrades; //총학점

}
