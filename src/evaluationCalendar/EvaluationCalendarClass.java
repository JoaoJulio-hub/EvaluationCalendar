package evaluationCalendar;

import Course.*;
import Person.*;
import dataStructures.*;
import evaluation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class EvaluationCalendarClass implements EvaluationCalendar {

    ArrayClass<Person> people = new ArrayClass<Person>();
    ArrayClass<Course> courses = new ArrayClass<Course>();


    @Override
    public boolean isEmpty() {
        return people.size() == 0;
    }

    @Override
    public boolean personExists(String name) {
        return people.searchForward(new ProfessorClass(name));
    }

    @Override
    public boolean studentExists(String name) {
        return false;
    }

    @Override
    public boolean professorExists(String name) {
        return false;
    }

    @Override
    public boolean studentNumberTaken(int number) {
        return false;
    }

    @Override
    public boolean courseExists(String name) {
       return courses.searchForward(new CourseClass(name));
    }

    @Override
    public boolean professorIsAssigned(String name) {
        return false;
    }

    @Override
    public boolean studentIsEnroledToCourse(String name, String course) {
        return false;
    }

    @Override
    public boolean deadlineExists(String projectName) {
        return false;
    }

    @Override
    public boolean dateConflict(LocalDate date) {
        return false;
    }

    @Override
    public boolean timeConflict(LocalDateTime time) {
        return false;
    }

    @Override
    public boolean validTestTime(String course, LocalDate date, LocalDateTime time) {
        return false;
    }

    @Override
    public int professorsWithDateConflict(LocalDate date) {
        return 0;
    }

    @Override
    public int studentsWithDateConflict(LocalDate date) {
        return 0;
    }

    @Override
    public int professorsWithTimeConflict(LocalDateTime time) {
        return 0;
    }

    @Override
    public int studentsWithTimeConflict(LocalDateTime time) {
        return 0;
    }

    @Override
    public String superProfessor() {
        return null;
    }

    @Override
    public void addProfessor(String name) {

    }

    @Override
    public void addStudent(int number, String name) {

    }

    @Override
    public void addCourse(String name) {

    }

    @Override
    public void assignProfessor(String name, String course) {

    }

    @Override
    public void enrolToCourse(int numbOfStudents, String course, String name) {

    }

    @Override
    public void newDeadline(String course, int year, int month, int day, String deadlineName) {

    }

    @Override
    public void scheduleTest(int year, int month, int day, int hour, int minute,
                             int duration, String course, String test) {

    }

    @Override
    public Iterator<Person> listAll() {
        return people.iterator();
    }

    @Override
    public Iterator<Course> listCourses() {
        return null;
    }

    @Override
    public Iterator<Person.Person> listCourseRoster(String courseName) {
        return null;
    }

    @Override
    public Iterator<Person.Person> intersection(int numbOfCourses, String course) {
        return null;
    }

    @Override
    public Array<Person> IntersectCourses(String c1, String c2) {
        return getCourseByName(c1).IntersectCourses(getCourseByName(c2));
    }

    @Override
    public Course getCourseByName(String course) {
        return courses.get(courses.searchIndexOf(new CourseClass(course)));
    }

    @Override
    public Iterator<Project> courseDeadlines(String course) {
        return null;
    }

    @Override
    public Iterator<Project> personalDeadlines(String name) {
        return null;
    }

    @Override
    public Iterator<Test> courseTests(String course) {
        return null;
    }

    @Override
    public Iterator<Test> personalTests(String name) {
        return null;
    }

    @Override
    public Iterator<Student> listMostStressedStudents(int numbOfStudents) {
        return null;
    }

}
