package Person;
import dataStructures.*;
import Course.*;

/**
 * Person, represented by his name
 */
public interface Person {

    /**
     * Returns person name
     * @return - person name
     */
    public String getName();

    /**
     * Returns an iterator
     * @return
     */
    public Iterator<Course> coursesIterator();


}
