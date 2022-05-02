package evaluationCalendar;
import Course.*;
import Person.*;
import dataStructures.*;
import evaluation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

// Created by Joao Julio (61610) && Rodrigo Freitas (62942)

public class EvaluationCalendarClass implements EvaluationCalendar {

    ArrayClass<Person> people = new ArrayClass<Person>();
    ArrayClass<Course> courses = new ArrayClass<Course>();


    /**
     * Return the person with the given name
     *
     * @param name
     * @return person with the given name
     * @pre personExists
     */
    @Override
    public Person getPerson(String name) {
        int pos = people.searchIndexOf(new ProfessorClass(name));
        return people.get(pos);
    }

    /**
     * Checks if a person is a student
     *
     * @param name
     * @return true if person is a student, false otherwise
     * @pre personExists()
     */
    @Override
    public boolean isStudent(String name) {
        return getPerson(name) instanceof Student;
    }

    @Override
    public boolean peopleIsEmpty() {
        return people.size() == 0;
    }

    @Override
    public boolean coursesIsEmpty() {
        return courses.size() == 0;
    }

    @Override
    public boolean personExists(String name) {
        return people.searchForward(new ProfessorClass(name));
    }

    @Override
    public boolean studentExists(String name) {
        return personExists(name) && isStudent(name);
    }

    @Override
    public boolean professorExists(String name) {
        return personExists(name) && !isStudent(name);
    }

    @Override
    public boolean studentIdExists(int id) {
        Iterator<Person> it = people.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p instanceof Student) {
                if (((Student) p).getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean courseExists(String name) {
        return courses.searchForward(new CourseClass(name));
    }

    @Override
    public boolean professorIsAssigned(String name, String course) {
        return getCourseByName(course).hasProfessor(name);
    }

    @Override
    public boolean studentIsEnrolledToCourse(String name, String course) {
        return getCourseByName(course).hasStudent(name);
    }

    @Override
    public boolean deadlineExists(String projectName) {
        return false;
    }

    @Override
    public boolean dateConflict(LocalDate date) {
        return false;
    }

    @Override
    public boolean timeConflict(LocalDateTime time) {
        return false;
    }

    @Override
    public boolean validTestTime(String course, LocalDate date, LocalDateTime time) {
        return false;
    }

    @Override
    public int professorsWithDateConflict(LocalDate date) {
        return 0;
    }

    @Override
    public int studentsWithDateConflict(LocalDate date) {
        return 0;
    }

    @Override
    public int professorsWithTimeConflict(LocalDateTime time) {
        return 0;
    }

    @Override
    public int studentsWithTimeConflict(LocalDateTime time) {
        return 0;
    }

    @Override
    public void addProfessor(String name) {
        people.insertLast(new ProfessorClass(name));
    }

    @Override
    public void addStudent(int id, String name) {
        people.insertLast(new StudentClass(id, name));
    }

    @Override
    public void addCourse(String name) {
        courses.insertLast(new CourseClass(name));
    }

    @Override
    public void assignProfessor(String name, String course) {
        getCourseByName(course).addPerson(new ProfessorClass(name));
    }

    @Override
    public void enrolToCourse( String name, String course) {
        getCourseByName(course).addPerson(getPerson(name));
    }

    @Override
    public void newDeadline(String course, int year, int month, int day, String deadlineName) {
        getCourseByName(course).addProject(year, month, day, deadlineName);
    }

    @Override
    public void scheduleTest(int year, int month, int day, int hour, int minute,
                             int duration, String course, String test) {
        getCourseByName(course).addTest(year, month, day, hour, minute, duration, test);
    }

    @Override
    public Iterator<Person> listAll() {
        return people.iterator();
    }

    @Override
    public Iterator<Course> listCourses() {
        return courses.iterator();
    }

    @Override
    public Iterator<Person> listCourseRoster(String courseName) {
        return getCourseByName(courseName).personIterator();
    }


    @Override
    public Course getCourseByName(String course) {
        return courses.get(courses.searchIndexOf(new CourseClass(course)));
    }

    @Override
    public Iterator<Project> courseDeadlines(String course) {
        return getCourseByName(course).projectsIterator();
    }

    @Override
    public Iterator<Project> personalDeadlines(String name) {
        return getPerson(name).personalProjectsIterator();
    }

    @Override
    public Iterator<Test> courseTests(String course) {
        return getCourseByName(course).testIterator();
    }

    @Override
    public Iterator<Test> personalTests(String name) {
        Student student = (Student) getPerson(name);
        return student.personalTestIterator();
    }

    @Override
    public Iterator<Student> mostStressedStudents() {
        Array<Student> tmp = new ArrayClass<Student>();
        Iterator<Person> it = people.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p instanceof Student && p.getNumberOfEvaluations() > 0) {
                tmp.insertLast((Student) p);
            }
        }
        return tmp.iterator();
    }

    @Override
    public Array<Person> multiIntersectCourses(Array<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            Person p = persons.get(i);
            int repeat = 0;
            for (int j = 0; j < persons.size(); j++) {
                if (p.equals(persons.get(j))) {
                    repeat++;
                    persons.removeAt(j);
                }
            }
            if (repeat == 0) {
                persons.removeAt(i);
            }
        }
        return persons;
    }

    public Professor superProfessor(){
        Iterator<Person> it = people.iterator();
        int maxStudents = 0;
        Professor superProfessor = null;
        while(it.hasNext()){
            int currentStudents = 0;
            Person p = it.next();
            if (p instanceof Professor){
                Iterator <Course> courseIterator = p.coursesIterator();
                while(courseIterator.hasNext()){
                    Course c = courseIterator.next();
                    currentStudents += c.getNumberStudents();
                }
                if(currentStudents > maxStudents){
                    maxStudents = currentStudents;
                    superProfessor = (Professor) p;
                }
            }
        }
        return superProfessor;
    }

    @Override
    public boolean noProfessors(){
        Iterator<Person> it = people.iterator();
        int professorsCounter = 0;
        while(it.hasNext()){
            Person p = it.next();
            if(p instanceof Professor){
                professorsCounter++;
            }
        }
        return professorsCounter == 0;
    }

    @Override
    public int numberOfStudentsWithEvaluation(){
        int counter = 0;
        Iterator<Person> it = people.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p instanceof Student && p.getNumberOfEvaluations() > 0) {
                counter++;
            }
        }
        return counter;
    }
}