package Course;
import Person.*;
import dataStructures.*;
import evaluation.*;

import dataStructures.Array;

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
    public Iterator<Evaluation> deadlinesIterator() {
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
}
