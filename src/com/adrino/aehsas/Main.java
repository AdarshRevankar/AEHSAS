package com.adrino.aehsas;

import java.util.Scanner;
//Allocation Logic code.
//Date: 09-11-2018|12-11-2018|
//Work:Creation|
//To allocate Student seat to respective class

class listPointer {
    int left;
    int right;

    public listPointer() {
        left = right = 1;
    }

    void incLeft() {
        left++;
    }

    void incRight() {
        right++;
    }
}

public class Main {
    //Scanner object.
    static Scanner s;
    static int leftStudentPointer, rightStudentPointer;

    public static void main(String[] args) {
        System.out.println("Enter ClassRoom Count:");
        s = new Scanner(System.in);
        int classCount = s.nextInt();

        //Class Array for certain number of class
        ClassRoom classRooms[] = new ClassRoom[classCount + 1];

        for (int i = 1; i <= classCount; i++) {
            //System Console Input
            System.out.println("Enter Class " + i + " details");
            System.out.println("Capacity :");
            int cap = s.nextInt();
            System.out.println("No of rows :");
            int row = s.nextInt();
            System.out.println("No of Columns :");
            int col = s.nextInt();

            //Class Object
            classRooms[i] = new ClassRoom(cap, row, col);
        }
        //System Console Input
        System.out.print("Enter Total Number of Students :");
        int totalStudents = s.nextInt();

        //CreateStudentListObject
        //For dummy input purpose.
        Student sList[] = new Student[totalStudents + 1];

        //Points to the remaining allocated student list first student
        //This provides pointer for allocating students.
        listPointer stuListPointer = new listPointer();

        //Assigning values to Student List (dummy)
        for (int i = 1; i <= (totalStudents / 2); i++) {
            sList[i] = new Student("stu " + i, "4mt16cs00" + i, "5CS0" + i, 'M');
        }
        for (int i = (totalStudents / 2) + 1; i <= totalStudents; i++) {
            sList[i] = new Student("stu " + (i - (totalStudents / 2)),
                    "4mt17cs00" + (i - (totalStudents / 2)),
                    "3CS0" + (i - (totalStudents / 2)), 'M');
        }

        //Call for allocation
        for (int i = 1; i <= classCount; i++) {
            stuListPointer = classRooms[i].allocateStudentsToSeat(sList, stuListPointer, totalStudents);
            classRooms[i].printClassRoomArrangemet();

            //classRooms[i].printSeated(sList, totalStudents);
        }
    }
}
