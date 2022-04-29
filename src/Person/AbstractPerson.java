/**
 * Abstract class for person
 * Created by Joao Julio && Rodrigo Freitas
 */
package Person;

import Course.Course;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public abstract class AbstractPerson implements Person{

    /**
     * Name of the person
     */
    String name;

    /**
     * Array containing every course a person is participating in
     */
    ArrayClass<Course> courses = new ArrayClass<>();

    /**
     * Constructor
     * @param name
     */
    protected AbstractPerson(String name){
        this.name = name;
    }


    @Override
    public String getName(){
        return name;
    }

    @Override
    public Iterator<Course> coursesIterator(){
        return courses.iterator();
    }

    @Override
    public int numberOfCourses(){
        return courses.size();
    }
}
