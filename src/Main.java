import Person.Person;
import evaluation.Evaluation;
import evaluationCalendar.*;
import dataStructures.*;
import Person.*;

import java.awt.*;
import java.util.Scanner;

public class Main {

    /**
     * User commands.
     */
    private static final String PEOPLE = "PEOPLE";
    private static final String PROFESSOR = "PROFESSOR";
    private static final String STUDENT = "STUDENT";
    private static final String COURSES = "COURSES";
    private static final String COURSE = "COURSE";
    private static final String ROSTER = "ROSTER";
    private static final String ASSIGN = "ASSIGN";
    private static final String ENROL = "ENROL";
    private static final String INTERSECTION = "INTERSECTION";
    private static final String COURSEDEADLINES = "COURSEDEADLINES";
    private static final String PERSONALDEADLINES = "PERSONALDEADLINES";
    private static final String DEADLINE = "DEADLINE";
    private static final String COURSETESTS = "COURSETESTS";
    private static final String PERSONALTESTS = "PERSONALTESTS";
    private static final String SCHEDULE = "SCHEDULE";
    private static final String SUPERPROFESSOR = "SUPERPROFESSOR";
    private static final String STRESSOMETER = "STRESSOMETER";
    private static final String HELP = "HELP";
    private static final String EXIT = "EXIT";

    /**
     * Program feedback.
     */
    private static final String EXITING = "Bye!\n";
    private static final String NO_PEOPLE = "No people registered!";
    private static final String HEADER_LIST_PEOPLE = "All people:";
    private static final String LIST_STUDENT = "[%d] %s (%d)\n";
    private static final String LIST_PROFESSOR = "%s (%d)\n";
    private static final String PROFESSOR_ADDED = "%s added.\n";
    private static final String PERSON_EXISTS = "%s already exists!\n";
    private static final String STUDENT_ADDED = "%s added.\n";
    private static final String STUDENT_NUMBER_TAKEN = "There is already a student with the number %d!\n";
    private static final String NO_COURSES = "No courses registered!\n";
    private static final String HEADER_LIST_COURSES = "All courses:";
    private static final String LIST_COURSE = "%s: %d professors, %d students, %d tests, %d deadlines.\n";
    private static final String COURSE_ADDED = "Course %s added.\n";
    private static final String COURSE_EXISTS = "Course %s already exists!\n";
    private static final String COURSE_DOESNT_EXIST = "Course %s does not exist!\n";
    private static final String HEADER_LIST_ROSTER = "Roster for course %s:\n";
    private static final String HEADER_LIST_PROFESSORS = "Professors:";
    private static final String HEADER_LIST_STUDENTS = "Students:";
    private static final String COURSE_EMPTY = "Course %s has no assigned professors and no enrolled students.";
    private static final String PROFESSOR_ASSIGNED = "Professor %s assigned to %s.\n";
    private static final String PROFESSOR_DOESNT_EXIST = "Professor %s does not exist!\n";
    private static final String STUDENT_DOESNT_EXIST = "Student %s does not exist!\n";
    private static final String PERSON_DOESNT_EXIST = "%s does not exist!\n";
    private static final String PROFESSOR_IS_ASSIGNED = "Professor %s is already assigned to course %s!\n";
    private static final String STUDENTS_ENROLLED = "%d students added to course %s.\n";
    private static final String STUDENT_IS_ENROLLED = "Student %s is already enrolled in course %s!\n";
    private static final String INADEQUATE_NUMBER_OF_STUDENTS = "Inadequate number of students!";
    private static final String HEADER_LIST_INTERSECTION = "Intersection:";
    private static final String EMPTY_INTERSECTION = "No professors or students to list!";
    private static final String INADEQUATE_NUMBER_OF_COURSES = "Inadequate number of courses!";
    private static final String HEADER_LIST_COURSEDEADLINES = "Deadlines for course %s:\n";
    private static final String AVAILABLE_DEADLINE = "%s: %d-%d-%d\n";
    private static final String NO_COURSEDEADLINES = "No deadlines defined for %s!\n";
    private static final String HEADER_LIST_PERSONALDEADLINES = "Deadlines for %s:\n";
    private static final String NO_PERSONALDEADLINES = "No deadlines defined for %s!\n";
    private static final String DEADLINE_ADDED = "Deadline %s added to %s.\n";
    private static final String HEADER_LIST_COURSETESTS = "Tests for course %s:\n";
    private static final String AVAILABLE_TESTS = "%d-%d-%d %dh%d-%dh%d: %s\n";
    private static final String NO_COURSETESTS = "No scheduled tests for %s!\n";
    private static final String HEADER_LIST_PERSONALTESTS = "Tests for %s:\n";
    private static final String AVAILABLE_PERSONALTESTS = "%d-%d-%d %dh%d-%dh%d: %s - %s\n";
    private static final String NO_PERSONALTESTS = "No scheduled tests for %s!\n";
    private static final String FREE = "free";
    private static final String MILD = "mild";
    private static final String SEVERE = "severe";
    private static final String TEST_ADDED = "%s %s %s %d-%d-%d %dh%d-%dh%d (%d, %d)\n";
    private static final String TEST_EXISTS = "Course %s already has a test named %s!\n";
    private static final String INVALID_TEST_TIME = "Cannot schedule test %s at that time!\n";
    private static final String LIST_SUPERPROFESSOR = "%s (%d).\n";
    private static final String NO_PROFESSORS = "There are no professors!";
    private static final String HEADER_LIST_STRESSOMETER = "Most stressed students:";
    private static final String MOST_STRESSED = "%d %s (%d days, %d evaluations)\n";
    private static final String NO_STRESSED_STUDENTS = "There are no stressed students right now!";
    private static final String INVALID_NUMBER = "Invalid number of students!";

    /**
    Main program. Calls the commands interpreter
    @param args - arguments for the execution of the aplication.
     */
    public static void main(String[] args) {
        Main.commands();
    }

    /**
    Command interpreter
     */
    private static void commands() {
        EvaluationCalendar ec = new EvaluationCalendarClass();
        Scanner in = new Scanner(System.in);
        String c = in.next().toUpperCase();
        while (!c.equals(EXIT)) {
            switch (c) {
                case PEOPLE:
                    listPeople(ec);
                    break;
                case PROFESSOR:
                    addProfessor(in, ec);
                    break;
                case STUDENT:
                case COURSES:
                case COURSE:
                    addCourse(in, ec);
                case ROSTER:
                case ASSIGN:
                case ENROL:
                case INTERSECTION:
                case COURSEDEADLINES:
                case PERSONALDEADLINES:
                case DEADLINE:
                case COURSETESTS:
                case PERSONALTESTS:
                case SCHEDULE:
                case SUPERPROFESSOR:
                case STRESSOMETER:
                case HELP:


            }
            c = in.next().toUpperCase();
        }
        System.out.println(EXITING);
        in.close();
    }

    /**
     * Lists everyone
     * @param ec - the evaluation calendar
     */
    private static void listPeople(EvaluationCalendar ec){
        if(ec.isEmpty()){
            System.out.println(NO_PEOPLE);
        } else {
            Iterator<Person> it =  ec.listAll();
            System.out.println(HEADER_LIST_PEOPLE);
            while(it.hasNext()){
                Person p = it.next();
                if(p instanceof Student) {
                    System.out.printf(LIST_STUDENT, ((Student) p).getId(), p.getName(), p.numberOfCourses());
                } else {
                    System.out.printf(LIST_PROFESSOR, p.getName(), p.numberOfCourses());
                }
            }
        }
    }

    private static void addProfessor(Scanner in, EvaluationCalendar ec){
        String name = in.nextLine().trim();
        if(ec.personExists(name))
            System.out.printf(PERSON_EXISTS, name);
        else {
            ec.addProfessor(name);
            System.out.printf(PROFESSOR_ADDED, name);
        }
    }

    private static void addStudent(Scanner in, EvaluationCalendar ec){
        int id = in.nextInt();
        String name = in.nextLine().trim();
        if(ec.personExists(name)) {
            System.out.printf(PERSON_EXISTS, name);
        } else if(ec.studentIdExists(id)){
            System.out.printf(STUDENT_NUMBER_TAKEN, id);
        } else {

        }
    }

    private static void addCourse(Scanner in, EvaluationCalendar ec){
        String course = in.nextLine();

    }

    private static void stress(Scanner in, EvaluationCalendar ec) {
        int n = in.nextInt();
        Iterator<Person> it = ec.mostStressedStudents();
        int i = 0;
        while(it.hasNext() && i != n) {
            System.out.println(it.next());
        }
    }
}
