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
     * Returns an iterator of deadlines (all tests + projects)
     * @return deadlines iterator
     */
    Iterator<Evaluation> deadlinesIterator();

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

    String getName();

    int getSize();

    boolean hasPerson(String name);

    Array<Person> IntersectCourses(Course c2);
}