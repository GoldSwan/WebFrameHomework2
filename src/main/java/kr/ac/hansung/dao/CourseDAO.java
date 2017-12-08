package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository // courseDAO
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from courses";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

	}

	// query and return a single object
	public Course getCourse(String coursecode) {// 과목코드로 찾기
		String sqlStatement = "select * from courses where name=?";// ?:placeholder

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { coursecode }, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setId(rs.getInt("id"));
				course.setYears(rs.getInt("years"));
				course.setSemester(rs.getInt("semester"));
				course.setCoursecode(rs.getString("coursecode"));
				course.setCoursename(rs.getString("coursename"));
				course.setDivision(rs.getString("division"));
				course.setGrades(rs.getInt("grades"));

				return course;
			}
		});
	}

	// query and return multiple objects
	public List<Course> getCourses() {
		String sqlStatement = "select * from courses";// ?:placeholder

		return jdbcTemplate.query(sqlStatement, // 모든 레코드 가져와서 리턴
				new RowMapper<Course>() {
					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

						Course course = new Course();
	
						course.setId(rs.getInt("id"));
						course.setYears(rs.getInt("years"));
						course.setSemester(rs.getInt("semester"));
						course.setCoursecode(rs.getString("coursecode"));
						course.setCoursename(rs.getString("coursename"));
						course.setDivision(rs.getString("division"));
						course.setGrades(rs.getInt("grades"));

						return course;
					}
				});
	}

	public boolean insert(Course course) {

		int years = course.getYears();
		int semester = course.getSemester();
		String coursecode = course.getCoursecode();
		String coursename = course.getCoursename();
		String division = course.getDivision();
		int grades = course.getGrades();

		String sqlStatement = "insert into courses (years, semester, coursecode, coursename, division, grades) values(?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement,
				new Object[] { years, semester, coursecode, coursename, division, grades }) == 1);
	}

	public boolean update(Course course) {

		int id = course.getId();
		int years = course.getYears();
		int semester = course.getSemester();
		String coursecode = course.getCoursecode();
		String coursename = course.getCoursename();
		String division = course.getDivision();
		int grades = course.getGrades();

		String sqlStatement = "update courses set years=?, semester=?, coursecode=?, coursename=?, division=?, grades=? where id=?";

		return (jdbcTemplate.update(sqlStatement,
				new Object[] { years, semester, coursecode, coursename, division, grades, id }) == 1);
	}

	public boolean delete(int id) {
		String sqlStatement = "delete from courses where id=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);

	}
}