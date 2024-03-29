package Person;
import Course.*;
import dataStructures.*;
import evaluation.*;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)

/**
 * Creates a Student object
 */
public class StudentClass extends AbstractPerson implements Student  {

    /**
     * student id
     */
    int id;

    /**
     * Constuctor
     * @param id
     * @param name
     */
    public StudentClass(int id, String name) {
        super(name);
        this.id = id;
    }
/**
 * Get an array with all the evaluations of a student (used in the array class)
 * @return an array with all the evaluations
 */

    private Array<Evaluation> getEvaluations() {
        Array<Evaluation> evaluations = new ArrayClass<Evaluation>();
        Iterator<Course> itCourse = coursesIterator();
        while(itCourse.hasNext()) {
            Course c = itCourse.next();
            Iterator<Evaluation> itEval = c.evaluationsIterator();
            while(itEval.hasNext()) {
                Evaluation e = itEval.next();
                evaluations.insertLast(e);
            }
        }
        return evaluations;
    }


    @Override
    public Iterator<Test> personalTestIterator() {
        Array<Test> tests = new ArrayClass<Test>();
        Iterator<Course> itCourse = coursesIterator();
        while(itCourse.hasNext()) {
            Course c = itCourse.next();
            Iterator<Evaluation> itEval = c.evaluationsIterator();
            while(itEval.hasNext()) {
                Evaluation e = itEval.next();
                if(e instanceof Test) {
                    tests.insertLast((Test) e);
                }
            }
        }
        tests.sort();
        return tests.iterator();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getStraightDays() {
        return new Stress(getEvaluations()).getStraightDays();
    }

    @Override
    public int getNumberOfEvaluations() {
        return new Stress(getEvaluations()).getNumberEvaluations();
    }

    @Override
    public int compareTo(Student other) {
        if (this.getStraightDays() != other.getStraightDays()) {
            return this.getStraightDays() - other.getStraightDays();
        } if (this.getStraightDays() == other.getStraightDays()
                && this.getNumberOfEvaluations() != other.getNumberOfEvaluations()) {
            return this.getNumberOfEvaluations() - other.getNumberOfEvaluations();
        } else if(this.getStraightDays() == other.getStraightDays()
                && this.getNumberOfEvaluations() == other.getNumberOfEvaluations()
                    && this.numberOfCourses() != other.numberOfCourses()) {
            return this.numberOfCourses() - other.numberOfCourses();
        } else {
            return this.getId() - other.getId();
        }
    }

    @Override
    public boolean testsIsEmpty() {
        Iterator<Course> it = coursesIterator();
        int counter = 0;
        while (it.hasNext()) {
            Course c = it.next();
            counter += c.getNumberTests();
        }
        return counter == 0;
    }
}

