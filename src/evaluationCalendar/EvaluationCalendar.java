/*

 */
package evaluationCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;

import dataStructures.Iterator;
import Person.*;
import Course.*;
import evaluation.*;

public interface EvaluationCalendar {

    /**
     * Checks if there is no person in the system
     * @return true if there is no person in the system, false if otherwise
     */
    boolean isEmpty();

    /**
     * Checks if a person with the given name is already in the system
     * @param name
     * @return true if person exists, false if otherwise
     */
    boolean personExists(String name);

    /**
     * Checks if a student with the given name is already in the system
     * @param name
     * @return true if the student exists, false if otherwise
     */
    boolean studentExists(String name);

    /**
     * Checks if a professor with the given name is already in the system
     * @param name
     * @return true if the professor exists, false if otherwise
     */
    boolean professorExists(String name);

    /**
     * Checks if a student number is already taken
     * @param number
     * @return true if number is taken, false if otherwise
     */
    boolean studentNumberTaken(int number);

    /**
     * Checks if a course with the given name already exists
     * @param name
     * @return true if course exists, false if otherwise
     */
    boolean courseExists(String name);

    /**
     * Checks if a given professor is already assigned to a course
     * @param name
     * @return true if professor is already assigned to a course, false if otherwise
     */
    boolean professorIsAssigned(String name);

    /**
     * Checks if a student is already enroled in a given course
     * @param name
     * @param course
     * @return true if the student is enroled in the course, false if otherwise
     */
    boolean studentIsEnroledToCourse(String name, String course);

    /**
     * Checks if a project with the given name already exists
     * @param projectName
     * @return true if project exists, false if otherwise
     */
    boolean deadlineExists(String projectName);

    /**
     * Checks if there is any person with a test in the same day
     * @param date
     * @return true if there is any conflict, false if otherwise
     */
    boolean dateConflict(LocalDate date);

    /**
     * Checks if there is any person with a test in a time that intersects with the given time
     * @param time
     * @return true if there is any conflict, false if otherwise
     */
    boolean timeConflict(LocalDateTime time);

    /**
     * Checks if a test can be scheduled to a given time
     * @param course
     * @param date
     * @param time
     * @return true if the course doesn't have any test scheduled for any intersecting time, false if otherwise
     */
    boolean validTestTime(String course, LocalDate date, LocalDateTime time);

    /**
     * Returns the number of professors with a test scheduled in the given date
     * @param date
     */
    int professorsWithDateConflict(LocalDate date);

    /**
     * Returns the number of students with a test scheduled in the given date
     * @param date
     */
    int studentsWithDateConflict(LocalDate date);

    /**
     * Returns the number of professors with a test scheduled in the given time
     * @param time
     */
    int professorsWithTimeConflict(LocalDateTime time);

    /**
     * Returns the number of students with a test scheduled in the given time
     * @param time
     */
    int studentsWithTimeConflict(LocalDateTime time);

    /**
     * Returns the professor with the most students
     */
    String superProfessor();

    /**
     * Adds a professor to the system
     * @param name
     * @pre !personExists(name)
     */
    void addProfessor(String name);

    /**
     * Adds a student to the system
     * @param number
     * @param name
     * @pre !personExists(name)
     * @pre !studentNumberTaken(number)
     */
    void addStudent(int number, String name);

    /**
     * Adds a course to the system
     * @param name
     * @pre !courseExists(name)
     */
    void addCourse(String name);

    /**
     * Assigns a professor to a course
     * @param name
     * @param course
     * @pre professorExists(name) && courseExists(course) && !professorIsAssigned(name)
     */
    void assignProfessor(String name, String course);

    /**
     * enrols a given number of students to a course
     * @param numbOfStudents
     * @param course
     * @param name
     * @pre numbOfStudents > 0 && courseExists(course) && studentExists(name)
     * @pre !studentIsEnroledToCourse(name, course)
     */
    void enrolToCourse(int numbOfStudents, String course, String name);

    /**
     * Defines a new project deadline for a given course
     * @param course
     * @param year
     * @param month
     * @param day
     * @param deadlineName
     * @pre courseExists(course) && !deadlineExists(deadlineName)
     */
    void newDeadline(String course, int year, int month, int day, String deadlineName);

    /**
     * Schedules a test for a given course
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param duration
     * @param course
     * @param test
     * @pre courseExists(course) &&
     */
    void scheduleTest(int year, int month, int day, int hour, int minute, int duration, String course, String test);

    /**
     * Returns an iterator for every person in the system
     * @return the iterator
     */
    Iterator<Person> listAll();

    /**
     * Returns an iterator for every course in the system
     * @return the iterator
     */
    Iterator<Course> listCourses();

    /**
     * Returns an iterator for every person in a given course
     * @param courseName
     * @pre courseExists(courseName)
     * @return the iterator
     */
    Iterator<Person> listCourseRoster(String courseName);

    /**
     * Returns an iterator with the people that participate in all the given courses
     * @param numbOfCourses
     * @param course
     * @pre numbOfCourses > 1 && courseExists(course)
     * @return the iterator
     */
    Iterator<Person> intersection(int numbOfCourses, String course);

    /**
     * Returns an iterator for the deadlines of a course
     * @param course
     * @pre courseExists(course)
     * @return the iterator
     */
    Iterator<Project> courseDeadlines(String course);

    /**
     * Returns an iterator for the deadlines of a person
     * @param name
     * @pre personExists(name)
     * @return the iterator
     */
    Iterator<Project> personalDeadlines(String name);

    /**
     * Returns an iterator for the tests of a course
     * @param course
     * @pre courseExists(course)
     * @return the iterator
     */
    Iterator<Test> courseTests(String course);

    /**
     * Returns an iterator for the tests of a person
     * @param name
     * @pre studentExists(name)
     * @return the iterator
     */
    Iterator<Test> personalTests(String name);

    /**
     * Returns an iterator for the Students with the most consecutive days with a test or a project;
     * @param numbOfStudents
     * @pre numbOfStudents > 0
     * @return the iterator
     */
    Iterator<StudentClass> listMostStressedStudents(int numbOfStudents);
}