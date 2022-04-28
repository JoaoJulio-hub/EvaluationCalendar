package Course;
import Person.*;
import dataStructures.*;
import evaluation.*;
import java.time.*;

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
     *
     * @param date
     * @param time
     * @param duration
     * @param name
     */
    @Override
    public void addTest(LocalDate date, LocalDateTime time, int duration, String name) {
        evaluations.insertLast(new Test(date, time, duration, name));
    }

    /**
     * Add project to the course
     *
     * @param date
     * @param name
     */
    @Override
    public void addProject(LocalDate date, String name) {
        evaluations.insertLast(new ProjectClass(date, name));
    }
}
