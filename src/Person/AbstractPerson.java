package Person;
import dataStructures.*;
import Course.Course;
import evaluation.Evaluation;
import evaluation.Project;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        return Objects.equals(name, other.getName());
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
    public int getNumberOfEvaluations(){
        int counter = 0;
        Iterator<Course> it = coursesIterator();
        while(it.hasNext()){
            Course c = it.next();
            counter += c.getNumberOfEvaluations();
        }
        return counter;
    }

    @Override
    public boolean deadlineIsEmpty(){
        int projects = 0;
        for(int i = 0; i < courses.size(); i++){
            projects += courses.get(i).getNumberProjects();
        }
        return projects == 0;
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

