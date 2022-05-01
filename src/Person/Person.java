/**
 * Person interface, represented by his name
 * Created by Joao Julio && Rodrigo Freitas
 */
package Person;
import dataStructures.*;
import Course.*;


public interface Person {
    /**
     * Add course to the Array
     */
    void addCourse(Course c);

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

}
