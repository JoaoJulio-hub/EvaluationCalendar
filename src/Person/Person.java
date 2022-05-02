/**
 * Person interface, represented by his name
 * Created by Joao Julio && Rodrigo Freitas
 */
package Person;
import dataStructures.*;
import Course.*;
import evaluation.Project;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)

/**
 * Interface that implements the methods for all <code>Person</code> objects
 */
public interface Person {
    /**
     * Add course to the array
     */
    void addCourse(Course c);

    int getNumberOfEvaluations();

    boolean deadlineIsEmpty();

    /**
     * Returns person name
     * @return - person name
     */
    String getName();

    /**
     * Returns an iterator
     * @return - the iterator
     */
    Iterator<Course> coursesIterator();

    /**
     * Returns the number of courses a person participates in
     * @return - the number of courses
     */
    int numberOfCourses();

    /**
     * Get an array with all the evaluations of a student
     * @return an array with all the evaluations
     */
    Iterator<Project> personalProjectsIterator();
}
