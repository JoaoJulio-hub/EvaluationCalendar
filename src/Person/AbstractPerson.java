package Person;
import dataStructures.*;
import Course.Course;

/**
 * Abstract class for person
 * Created by Joao Julio && Rodrigo Freitas
 */
public abstract class AbstractPerson implements Person{

    /**
     * Name of the person
     */
    private String name;

    /**
     * Array containing every course a person is participating in
     */
    private ArrayClass<Course> courses;
    /**
     * Constructor
     * @param name
     */
    protected AbstractPerson(String name){
        this.name = name;
        this.courses = new ArrayClass<Course>();
    }
    /**
     * Add course to the Array
     *
     * @param c
     */
    @Override
    public void addCourse(Course c) {
        courses.insertLast(c);
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

