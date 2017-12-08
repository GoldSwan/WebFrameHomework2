package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class SplitCourseBySemester {
	
	int years;//년도 학년별
	int semester;//학기
	int totalGrades;//총이수학점
	
}
