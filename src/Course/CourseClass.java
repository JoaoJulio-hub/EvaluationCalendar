package Course;
import Person.*;
import dataStructures.*;
import evaluation.*;

import dataStructures.Array;

import java.util.Objects;

/**
 * Creates a Course with a given name
 */
public class CourseClass implements Course{
    /**
     * Name of the course
     */
    private String name;

    /**
     * Array of students and professors
     */
    private Array<Person> people;

    /**
     * Array of evaluations
     */
    private Array<Evaluation> evaluations;

    /**
     * Constructor of the CourseClass, receives a name for the course
     * @param name
     */
    public CourseClass(String name) {
        this.name = name;
        this.people = new ArrayClass<Person>();
        this.evaluations = new ArrayClass<Evaluation>();
    }

    /**
     * add a person <code>obj</code>, it can be a student or professor
     *
     * @param obj
     */
    @Override
    public void addPerson(Person obj) {
        people.insertLast(obj);
    }

    /**
     * Returns an iterator of deadlines (all tests + projects)
     *
     * @return deadlines iterator
     */
    @Override
    public Iterator<Evaluation> evaluationsIterator() {
        return evaluations.iterator();
    }

    /**
     * Returns an iterator of all students + teachers in the course
     *
     * @return students + teachers iterator
     */
    @Override
    public Iterator<Person> personIterator() {
        return people.iterator();
    }

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
    @Override
    public void addTest(int year, int month, int day, int hour,
                        int minute, int duration, String name) {
        evaluations.insertLast(new TestClass(year, month, day,
                hour, minute, duration, name));
    }

    /**
     * Add project to the course
     * @param year
     * @param month
     * @param day
     * @param name
     */
    @Override
    public void addProject(int year, int month, int day, String name) {
        evaluations.insertLast(new ProjectClass(year, month, day, name));
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getSize(){
        return people.size();
    }

    /**
     * equals method
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Course))
            return false;
        Course other = (Course) obj;
        return Objects.equals(name, other.getName());
    }

    @Override
    public boolean hasPerson(String name){
        return people.searchForward(new ProfessorClass(name));
    }

    @Override
    public Array<Person> IntersectCourses(Course c2) {
        Array<Person> intersection = people;
        Iterator<Person> it = personIterator();
        while(it.hasNext()){
            Person p = it.next();
            if(!c2.hasPerson(p.getName())) {
                int pos = people.searchIndexOf(new ProfessorClass(p.getName()));
                intersection.removeAt(pos);
            }
        }
        return intersection;
    }
}
