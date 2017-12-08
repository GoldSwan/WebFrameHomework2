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

	public List<SplitCourseBySemester> MakeSplitCourseBySemesters() {// �⵵ �б� �̼������ո� �ִ� �� �����

		List<Course> courses = getCurrent();
		List<SplitCourseBySemester> splitCourseBySemesters = new ArrayList<>();

		Course samplecourse = courses.get(0);// ó�� courses���� ã�´�.

		SplitCourseBySemester sampleSplitCourseBySemester = new SplitCourseBySemester();// �񱳸����� ó���� �߰�
		sampleSplitCourseBySemester.setYears(samplecourse.getYears());
		sampleSplitCourseBySemester.setSemester(1);
		sampleSplitCourseBySemester.setTotalGrades(0);// �ش��б� �� �̼������� 0���� �ʱ�ȭ

		SplitCourseBySemester sampleSplitCourseBySemester2 = new SplitCourseBySemester();// �񱳸����� ó���� �߰�
		sampleSplitCourseBySemester2.setYears(samplecourse.getYears());
		sampleSplitCourseBySemester2.setSemester(2);
		sampleSplitCourseBySemester2.setTotalGrades(0);// �ش��б� �� �̼������� 0���� �ʱ�ȭ

		splitCourseBySemesters.add(sampleSplitCourseBySemester);// splitCourseBySemesters ����Ʈ�ȿ� �߰�
		splitCourseBySemesters.add(sampleSplitCourseBySemester2);

		int j = 0;
		for (int i = 0; i < courses.size(); i++) {// courses���� years �ѹ��� ��
			if (courses.get(0).getYears() != courses.get(i).getYears()) {// courses �� �ε���0���� �ٸ� ����
				if (courses.get(i).getYears() != splitCourseBySemesters.get(j).getYears()) {
					// �ʱ⿡ splitCourseBySemesters�� �߰��� ���� �ٸ� ���
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
				if(course.getYears()==splitCourseBySemester.getYears()) {//�⵵�� ���� ��
					if(course.getSemester()==splitCourseBySemester.getSemester()) {//�б⵵ ���ٸ�
						splitCourseBySemester.setTotalGrades(splitCourseBySemester.getTotalGrades()+course.getGrades());
						//���̼����� �߰�
					}
				}
			}
		}

		return splitCourseBySemesters;
	}

	public void MakeSplitGrade() {

	}

}
