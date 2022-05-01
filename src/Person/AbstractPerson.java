package Person;
import dataStructures.*;
import Course.Course;
import evaluation.Evaluation;
import evaluation.Project;

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

    /**
     * Get an array with all the evaluations of a student (falta fazer o compareTo)
     * @return an array with all the evaluations
     */
    @Override
    public Iterator<Project> personalProjectsIterator() {
        Array<Project> projects = new ArrayClass<Project>();
        Iterator<Course> itCourse = coursesIterator();
        while(itCourse.hasNext()) {
            Course c = itCourse.next();
            Iterator<Evaluation> itEval = c.evaluationsIterator();
            while(itEval.hasNext()) {
                Evaluation e = itEval.next();
                if(e instanceof Project) {
                    projects.insertLast((Project) e);
                }
            }
        }
        projects.sort();
        return projects.iterator();
    }
}

