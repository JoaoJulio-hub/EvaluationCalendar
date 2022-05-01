import Course.*;
import Person.*;
import evaluation.*;
import evaluationCalendar.*;
import dataStructures.*;

import java.util.Scanner;

public class Main {

    /**
     * User commands.
     */
    private static final String PEOPLE = "PEOPLE";
    private static final String PROFESSOR = "PROFESSOR";
    private static final String STUDENT = "STUDENT";
    private static final String COURSE = "COURSE";
    private static final String INTERSECTION = "INTERSECTION";
    private static final String EXIT = "EXIT";

    /**
     * Program feedback.
     */
    private static final String EXITING = "Bye!\n";
    private static final String DATA_BASE_EMPTY = "No people registered!\n";
    private static final String HEADER_LIST_ACCOUNTS = "All people:";
    private static final String LIST_STUDENT = "[%d] %s (%d)\n";
    private static final String LIST_PROFESSOR = "%s (%d)\n";
    private static final String PERSON_EXISTS = "%s already exists!\n";
    private static final String PROFESSOR_ADDED = "%s added.\n";
    private static final String COURSE_EXISTS = "Course %s already exists!\n";

    /**
     * Main program. Calls the commands interpreter
     *
     * @param args - arguments for the execution of the aplication.
     */
    public static void main(String[] args) {
        Main.commands();
    }

    /**
     * Command interpreter
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

                case COURSE:
                    addCourse(in, ec);
                    break;
                case INTERSECTION:
                    intersection(in, ec);
                    break;


            }
            c = in.next().toUpperCase();
        }
        System.out.println(EXITING);
        in.close();
    }

    /**
     * Lists everyone
     *
     * @param ec - the evaluation calendar
     */
    private static void listPeople(EvaluationCalendar ec) {
        if (ec.isEmpty()) {
            System.out.println(DATA_BASE_EMPTY);
        } else {
            Iterator<Person> it = ec.listAll();
            System.out.println(HEADER_LIST_ACCOUNTS);
            while (it.hasNext()) {
                Person p = it.next();
                if (p instanceof Student) {
                    System.out.printf(LIST_STUDENT, ((Student) p).getId(), p.getName(), p.numberOfCourses());
                } else {
                    System.out.printf(LIST_PROFESSOR, p.getName(), p.numberOfCourses());
                }
            }
        }
    }

    private static void addProfessor(Scanner in, EvaluationCalendar ec) {
        String name = in.nextLine().trim();
        if (ec.personExists(name))
            System.out.printf(PERSON_EXISTS, name);
        else {
            ec.addProfessor(in.nextLine().trim());
            System.out.printf(PROFESSOR_ADDED, name);
        }
    }

    private static void addStudent(Scanner in, EvaluationCalendar ec) {
        int id = in.nextInt();
        String name = in.nextLine().trim();
        if (ec.personExists(name))
            System.out.printf(PERSON_EXISTS, name);
        if(ec.studentNumberTaken(id))
            System.out.printf();
        if (ec.personExists(name))
            System.out.printf(PERSON_EXISTS, name);
        else {
            ec.addProfessor(in.nextLine().trim());
            System.out.printf(PROFESSOR_ADDED, name);
        }
    }

    /**
     * adds a course to the system
     *
     * @param in
     * @param ec
     */
    private static void addCourse(Scanner in, EvaluationCalendar ec) {
        String course = in.nextLine();
        if (ec.courseExists(course))
            System.out.printf(COURSE_EXISTS, course);
        else {
            ec.addCourse(course);
            System.out.println("Course " + course + " added.");
        }
    }

    /**
     * checks the intersections
     *
     * @param in
     * @param ec
     */
    private static void intersection(Scanner in, EvaluationCalendar ec) {
        int numbOfCourses = in.nextInt();
        String course1 = in.nextLine().trim();
        Array<Person> people = new ArrayClass<Person>();
        for (int i = 0; i < numbOfCourses - 1; i++) {
            if (i == 0) ec.intersectCourses(course1, in.nextLine().trim());
            else people = ec.intersectCourses(              , in.nextLine().trim());
        }
    }


}
