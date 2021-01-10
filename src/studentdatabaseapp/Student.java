package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Creating a new student and assigning basic information about him
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name:" + " ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name:" + " ");
        this.lastName = in.nextLine();

        System.out.print("1 - for Freshmen \n2 - for Sophmore\n3 - for Junior\n4 - for Senior\nEnter student grade level:" + " ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    // Generating student ID
    private void setStudentID() {
        // The first value of the ID is the course
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Course registration and total cost
    public void enroll() {
        do {
            System.out.print("Enter course to enroll (Q for quit):" + " ");
            Scanner scan2 = new Scanner(System.in);
            String course = scan2.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + " " + " " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
    }

    // Show student balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Payment for selected courses
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner scan2 = new Scanner(System.in);
        int payment = scan2.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thanks for your payment of $" + payment);
        viewBalance();
    }

    // Show all student information
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level:" + " " + gradeYear +
                "\nStudent ID:" + " " + studentID +
                "\nCourses Enrolled:" + courses +
                "\nBalance: $" + tuitionBalance;
    }
}