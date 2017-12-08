package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.SplitCourseBySemester;
import kr.ac.hansung.model.SplitGrades;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/courses")
	public String showcourses(Model model) {

		List<SplitCourseBySemester> splitCourseBySemesters = courseService.MakeSplitCourseBySemesters();
		model.addAttribute("splitCourseBySemesters", splitCourseBySemesters);

		return "courses";
	}

	@RequestMapping("/detailcourse")
	public String showdetailcourse(Model model, @RequestParam("years") int years,
			@RequestParam("semester") int semester) {

		List<Course> courses = courseService.getCurrent();
		List<Course> detailCourses = new ArrayList<>();
		for (Course course : courses) {
			if (course.getYears() == years) {
				if (course.getSemester() == semester) {
					detailCourses.add(course);
				}
			}
		}

		model.addAttribute("detailCourses", detailCourses);

		return "detailcourse";
	}

	@RequestMapping("divisioncourse")
	public String showdivisioncourse(Model model) {

		List<Course> courses = courseService.getCurrent();
		SplitGrades splitGrades = new SplitGrades();
		splitGrades.setDivisiongrades1(0);
		splitGrades.setDivisiongrades2(0);
		splitGrades.setDivisiongrades3(0);
		splitGrades.setDivisiongrades4(0);
		splitGrades.setDivisiongrades5(0);
		splitGrades.setDivisiongrades6(0);
		splitGrades.setDivisiongrades7(0);
		splitGrades.setDivisiongrades8(0);
		splitGrades.setTotalDivisionGrades(0);
		
		for (Course course : courses) {
			if (course.getDivision().equals("교필")) {
				splitGrades.setDivisiongrades1(splitGrades.getDivisiongrades1() + course.getGrades());
			}
			if (course.getDivision().equals("일교")) {
				splitGrades.setDivisiongrades2(splitGrades.getDivisiongrades2() + course.getGrades());
			}
			if (course.getDivision().equals("전기")) {
				splitGrades.setDivisiongrades3(splitGrades.getDivisiongrades3() + course.getGrades());
			}
			if (course.getDivision().equals("핵교A")) {
				splitGrades.setDivisiongrades4(splitGrades.getDivisiongrades4() + course.getGrades());
			}
			if (course.getDivision().equals("핵교B")) {
				splitGrades.setDivisiongrades5(splitGrades.getDivisiongrades5() + course.getGrades());
			}
			if (course.getDivision().equals("전선")) {
				splitGrades.setDivisiongrades6(splitGrades.getDivisiongrades6() + course.getGrades());
			}
			if (course.getDivision().equals("자율")) {
				splitGrades.setDivisiongrades7(splitGrades.getDivisiongrades7() + course.getGrades());
			}
			if (course.getDivision().equals("인재")) {
				splitGrades.setDivisiongrades8(splitGrades.getDivisiongrades8() + course.getGrades());
			}
			splitGrades.setTotalDivisionGrades(splitGrades.getTotalDivisionGrades()+course.getGrades());
		}
		
		model.addAttribute("splitGrades", splitGrades);

		return "divisioncourse";// 뷰의 이름
	}
	@RequestMapping("/createcourse")
	public String createCourse(Model model) {
		
		model.addAttribute("course",new Course());
		
		return "createcourse";
	}
	
	@RequestMapping("/docreate")
	public String docreate(Model model,@Valid Course course, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("---Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "createcourse";
		}
		courseService.insert(course);
		
		return "coursecreated";
	}
	
	@RequestMapping("/newcourses")
	public String newCourses(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		List<Course> newcourses = new ArrayList<>();
		
		for(Course course:courses) {
			if(course.getYears()==2018&&course.getSemester()==1) {
				newcourses.add(course);
			}
		}
		
		model.addAttribute("newcourses",newcourses);
		
		return "newcourses";
	}
}