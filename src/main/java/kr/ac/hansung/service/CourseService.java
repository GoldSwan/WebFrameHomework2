package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.SplitCourseBySemester;

@Service
public class CourseService {

	@Autowired
	private CourseDAO courseDAO;

	public List<Course> getCurrent() {
		return courseDAO.getCourses();
	}

	public void insert(Course course) {
		courseDAO.insert(course);
	}

	public List<SplitCourseBySemester> MakeSplitCourseBySemesters() {// 년도 학기 이수학점합만 있는 모델 만들기

		List<Course> courses = getCurrent();
		List<SplitCourseBySemester> splitCourseBySemesters = new ArrayList<>();

		Course samplecourse = courses.get(0);// 처음 courses값을 찾는다.

		SplitCourseBySemester sampleSplitCourseBySemester = new SplitCourseBySemester();// 비교를위해 처음값 추가
		sampleSplitCourseBySemester.setYears(samplecourse.getYears());
		sampleSplitCourseBySemester.setSemester(1);
		sampleSplitCourseBySemester.setTotalGrades(0);// 해당학기 총 이수학점은 0으로 초기화

		SplitCourseBySemester sampleSplitCourseBySemester2 = new SplitCourseBySemester();// 비교를위해 처음값 추가
		sampleSplitCourseBySemester2.setYears(samplecourse.getYears());
		sampleSplitCourseBySemester2.setSemester(2);
		sampleSplitCourseBySemester2.setTotalGrades(0);// 해당학기 총 이수학점은 0으로 초기화

		splitCourseBySemesters.add(sampleSplitCourseBySemester);// splitCourseBySemesters 리스트안에 추가
		splitCourseBySemesters.add(sampleSplitCourseBySemester2);

		int j = 0;
		for (int i = 0; i < courses.size(); i++) {// courses내에 years 한번씩 비교
			if (courses.get(0).getYears() != courses.get(i).getYears()) {// courses 의 인덱스0값과 다를 때에
				if (courses.get(i).getYears() != splitCourseBySemesters.get(j).getYears()) {
					// 초기에 splitCourseBySemesters에 추가된 값과 다를 경우
					SplitCourseBySemester splitCourseBySemester = new SplitCourseBySemester();
					splitCourseBySemester.setYears(courses.get(i).getYears());
					splitCourseBySemester.setSemester(1);
					splitCourseBySemester.setTotalGrades(0);
					splitCourseBySemesters.add(splitCourseBySemester);

					SplitCourseBySemester splitCourseBySemester2 = new SplitCourseBySemester();
					splitCourseBySemester2.setYears(courses.get(i).getYears());
					splitCourseBySemester2.setSemester(2);
					splitCourseBySemester2.setTotalGrades(0);
					splitCourseBySemesters.add(splitCourseBySemester2);
					j += 2;
				}

			}
		}
		for(SplitCourseBySemester splitCourseBySemester:splitCourseBySemesters) {
			for(Course course:courses) {
				if(course.getYears()==splitCourseBySemester.getYears()) {//년도가 같을 때
					if(course.getSemester()==splitCourseBySemester.getSemester()) {//학기도 같다면
						splitCourseBySemester.setTotalGrades(splitCourseBySemester.getTotalGrades()+course.getGrades());
						//총이수학점 추가
					}
				}
			}
		}

		return splitCourseBySemesters;
	}

	public void MakeSplitGrade() {

	}

}
