package Course;
import Person.*;
import evaluation.*;
import dataStructures.*;
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
     * Returns an iterator of all evaluations (all tests + projects)
     * @return iterator of all evaluations
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
                hour, minute, duration, this.name, name));
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
        evaluations.insertLast(new ProjectClass(year, month, day, this.name, name));
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
    public boolean hasTest(String name){
        int pos = evaluations.searchIndexOf(new ProjectClass(0, 0, 0, null, name));
        return (evaluations.searchForward(new ProjectClass(0,0,0, null, name))
                    && evaluations.get(pos) instanceof Test);
    }

    public Person getPerson(String name) {
        int pos = people.searchIndexOf(new ProfessorClass(name));
        return people.get(pos);
    }

    /**
     * Check if a professor with a given name exists
     * @param name
     * @return true if the professor exists, false otherwise
     */
    @Override
    public boolean hasProfessor(String name) {
        return getPerson(name) instanceof Professor;
    }

    /**
     * Check if a student with a given name exists
     * @param name
     * @return true if the student exists, false otherwise
     */
    @Override
    public boolean hasStudent(String name) {
        return getPerson(name) instanceof Student;
    }

    @Override
    public int getNumberOfEvaluations(){
        return evaluations.size();
    }

    /**
     * Get number of scheduled tests
     *
     * @return number of tests
     */
    @Override
    public int getNumberTests() {
        Iterator<Evaluation> it = evaluations.iterator();
        int counter = 0;
        while (it.hasNext()) {
            Evaluation e = it.next();
            if (e instanceof Test) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Get number of scheduled projects
     *
     * @return number of projects
     */
    @Override
    public int getNumberProjects() {
        Iterator<Evaluation> it = evaluations.iterator();
        int counter = 0;
        while (it.hasNext()) {
            Evaluation e = it.next();
            if (e instanceof Project) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Get number of professors in the course
     *
     * @return number of professors
     */
    @Override
    public int getNumberProfessors() {
        Iterator<Person> it = people.iterator();
        int counter = 0;
        while (it.hasNext()) {
            Person p = it.next();
            if (p instanceof Professor) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Get number of students in the course
     *
     * @return number of students
     */
    @Override
    public int getNumberStudents() {
        Iterator<Person> it = people.iterator();
        int counter = 0;
        while (it.hasNext()) {
            Person p = it.next();
            if (p instanceof Student) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public Iterator<Project> projectsIterator() {
        Array<Project> projects = new ArrayClass<Project>();
        Iterator<Evaluation> it = evaluationsIterator();
        while(it.hasNext()){
            Evaluation e = it.next();
            if(e instanceof Project) {
                projects.insertLast((Project) e);
            }
        }
        projects.sort();
        return projects.iterator();
    }

    @Override
    public Iterator<Test> testIterator() {
        Array<Test> tests = new ArrayClass<Test>();
        Iterator<Evaluation> it = evaluationsIterator();
        while(it.hasNext()){
            Evaluation e = it.next();
            if(e instanceof Test) {
                tests.insertLast((Test) e);
            }
        }
        tests.sort();
        return tests.iterator();
    }

    @Override
    public Person getByPos(int pos){
        return people.get(pos);
    }
}