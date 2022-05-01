package Course;
import Person.*;
import dataStructures.*;
import evaluation.*;
import java.time.*;

/**
 * Course is a set of <code>Person</code>, <code>Evaluation</code>. The person array <code>Person</code> will
 * have both students and professors and the set <code>Evaluation</code> will have tests and project
 * This interface implements all methods of a course
 */
public interface Course {

    /**
     * add a person <code>obj</code>, it can be a student or professor
     * @param obj
     */
    void addPerson(Person obj);

    /**
     * Returns an iterator of all evaluations (all tests + projects)
     * @return iterator of all evaluations
     */
    Iterator<Evaluation> evaluationsIterator();

    /**
     * Returns an iterator of all students + teachers in the course
     * @return students + teachers iterator
     */
    Iterator<Person> personIterator();

    /**
     * Add test to the course
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param duration
     * @param name
     */
    void addTest(int year, int month, int day, int hour,
                 int minute, int duration, String name);

    /**
     * Add project to the course
     * @param year
     * @param month
     * @param day
     * @param name
     */
    void addProject(int year, int month, int day, String name);

    /**
     * Get name of the course
     * @return name
     */
    String getName();

    /**
     * Get number of people in the course
     * @return number of people
     */
    int getSize();

    boolean hasPerson(String name);

    /**
     * Check if a professor with a given name exists
     * @param name
     * @return true if the professor exists, false otherwise
     */
    boolean hasProfessor(String name);

    /**
     * Check if a student with a given name exists
     * @param name
     * @return true if the student exists, false otherwise
     */
    boolean hasStudent(String name);

    /**
     * Get number of scheduled tests
     * @return number of tests
     */
    public int getNumberTests();

    /**
     * Get number of scheduled projects
     * @return number of projects
     */
    public int getNumberProjects();

    /**
     * Get number of professors in the course
     * @return number of professors
     */
    int getNumberProfessors();

    /**
     * Get number of students in the course
     * @return number of students
     */
    int getNumberStudents();

    Array<Person> IntersectCourses(Course c2);

    Iterator<Project> projectsIterator();

    Iterator<Test> testIterator();
}