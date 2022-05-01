/**
 * Student class
 * Created by Joao Julio && Rodrigo Freitas
 */
package Person;

import Course.*;
import dataStructures.*;
import evaluation.*;

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

    /**
     * Get a sorted iterator with all the tests of a student (falta fazer o compareTo)
     * @return sorted iterator with all the tests
     */
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

    /**
     * Get an array with all the evaluations of a student (falta fazer o compareTo)
     * @return an array with all the evaluations
     */
    private Iterator<Project> personalProjectsIterator() {
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

    @Override
    public int getId() {
        return id;
    }

    /**
     * Get number of straight days with evaluations
     *
     * @return number of days
     */
    @Override
    public int getStraightDays() {
        return new Stress(getEvaluations()).getStraightDays();
    }

    /**
     * Get number of evaluations during those straight days
     *
     * @return number of evaluations
     */
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
}

