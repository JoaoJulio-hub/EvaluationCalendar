package evaluationCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import dataStructures.*;
import Person.*;
import Course.*;
import evaluation.*;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)

public interface EvaluationCalendar {

    /**
     * Return the person with the given name
     *
     * @param name * @pre personExists
     * @return person with the given name
     */
    Person getPerson(String name);

    /**
     * Checks if a person is a student
     *
     * @param name
     * @return true if person is a student, false otherwise
     * @pre personExists()
     */
    boolean isStudent(String name);

    /**
     * Checks if there is no person in the system
     *
     * @return true if there is no person in the system, false if otherwise
     */
    boolean peopleIsEmpty();

    /**
     * Checks if there is no course in the system
     *
     * @return true if there is no course in the system, false if otherwise
     */
    boolean coursesIsEmpty();

    /**
     * Checks if a person with the given name is already in the system
     *
     * @param name
     * @return true if person exists, false otherwise
     */
    boolean personExists(String name);

    /**
     * Checks if a student with the given name is already in the system
     *
     * @param name
     * @return true if the student exists, false otherwise
     */
    boolean studentExists(String name);

    /**
     * Checks if a professor with the given name is already in the system
     *
     * @param name
     * @return true if the professor exists, false otherwise
     */
    boolean professorExists(String name);

    /**
     * Checks if a student number is already taken
     *
     * @param id
     * @return true if number is taken, false otherwise
     */
    boolean studentIdExists(int id);

    /**
     * Checks if a course with the given name already exists
     *
     * @param name
     * @return true if course exists, false otherwise
     */
    boolean courseExists(String name);

    /**
     * Checks if a given professor is already assigned to a course
     * @param course
     * @param name
     * @return true if professor is already assigned to a course, false otherwise
     */
    boolean professorIsAssigned(String name, String course);

    /**
     * Checks if a student is already enrolled in a given course
     *
     * @param name
     * @param course
     * @return true if the student is enrolled in the course, false otherwise
     */
    boolean studentIsEnrolledToCourse(String name, String course);

    /**
     * Checks if a project with the given name already exists
     *
     * @param projectName
     * @return true if project exists, false  otherwise
     */
    boolean deadlineExists(String projectName);

    /**
     * Checks if there is any person with a test in the same day
     *
     * @param date
     * @return true if there is any conflict, false otherwise
     */
    boolean dateConflict(LocalDate date);

    /**
     * Checks if there is any person with a test in a time that intersects with the given time
     *
     * @param time
     * @return true if there is any conflict, false otherwise
     */
    boolean timeConflict(LocalDateTime time);

    /**
     * Checks if a test can be scheduled to a given time
     *
     * @param course
     * @param date
     * @param time
     * @return true if the course doesn't have any test scheduled for any intersecting time, false otherwise
     */
    boolean validTestTime(String course, LocalDate date, LocalDateTime time);

    /**
     * Returns the number of professors with a test scheduled in the given date
     *
     * @param date
     */
    int professorsWithDateConflict(LocalDate date);

    /**
     * Returns the number of students with a test scheduled in the given date
     *
     * @param date
     */
    int studentsWithDateConflict(LocalDate date);

    /**
     * Returns the number of professors with a test scheduled in the given time
     *
     * @param time
     */
    int professorsWithTimeConflict(LocalDateTime time);

    /**
     * Returns the number of students with a test scheduled in the given time
     *
     * @param time
     */
    int studentsWithTimeConflict(LocalDateTime time);

    /**
     * Adds a professor to the system
     *
     * @param name
     * @pre !personExists(name)
     */
    void addProfessor(String name);

    /**
     * Adds a student to the system
     *
     * @param id
     * @param name
     * @pre !personExists(name)
     * @pre !studentIdExists(id)
     */
    void addStudent(int id, String name);

    /**
     * Adds a course to the system
     *
     * @param name
     * @pre !courseExists(name)
     */
    void addCourse(String name);

    /**
     * Assigns a professor to a course
     *
     * @param name
     * @param course
     * @pre professorExists(name) && courseExists(course) && !professorIsAssigned(name)
     */
    void assignProfessor(String name, String course);

    /**
     * enrols a student to a course
     *
     * @param course
     * @param name
     * @pre courseExists(course) && studentExists(name)
     * @pre !studentIsEnroledToCourse(name, course)
     */
    void enrolToCourse(String name, String course);

    /**
     * Defines a new project deadline for a given course
     *
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
     *
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
     *
     * @return the iterator
     */
    Iterator<Person> listAll();

    /**
     * Returns an iterator for every course in the system
     *
     * @return the iterator
     */
    Iterator<Course> listCourses();

    /**
     * Returns an iterator for every person in a given course
     *
     * @param courseName
     * @return the iterator
     * @pre courseExists(courseName)
     */
    Iterator<Person> listCourseRoster(String courseName);

    /**
     * Gets the course with the given name
     *
     * @param course
     * @return a course
     */
    Course getCourseByName(String course);

    /**
     * Returns an iterator for the deadlines of a course
     *
     * @param course
     * @return the iterator
     * @pre courseExists(course)
     */
    Iterator<Project> courseDeadlines(String course);

    /**
     * Returns an iterator for the deadlines of a person
     *
     * @param name
     * @return the iterator
     * @pre personExists(name)
     */
    Iterator<Project> personalDeadlines(String name);

    /**
     * Returns an iterator for the tests of a course
     *
     * @param course
     * @return the iterator
     * @pre courseExists(course)
     */
    Iterator<Test> courseTests(String course);

    /**
     * Returns an iterator for the tests of a person
     *
     * @param name
     * @return the iterator
     * @pre studentExists(name)
     */
    Iterator<Test> personalTests(String name);

    /**
     * Returns an iterator for the Students with the most consecutive days with a test or a project;
     *
     * @return the iterator
     */
    Iterator<Student> mostStressedStudents();

    Array<Person> multiIntersectCourses(Array<Person> persons);

    /**
     * Returns the professor with the most students
     */
    Professor superProfessor();

    boolean noProfessors();

    int numberOfStudentsWithEvaluation();
}