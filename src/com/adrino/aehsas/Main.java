package com.adrino.aehsas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter ClassRoom Count:");
        Scanner s = new Scanner(System.in);
        int classCount = s.nextInt();

        //Class Array for certain number of class
        ClassRoom classRooms[] = new ClassRoom[classCount+1];

        for(int i=1;i<=classCount;i++) {
            //System Console Input
            System.out.println("Enter Class "+i+" details");
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
        Student sList[] = new Student[totalStudents+1];

        //Points to the remaining allocated student list first student
        //This provides pointer for allocating students.
        int studentPointer = 1;

        //Assigning values to Student List (dummy)
        for(int i = 1 ; i <= totalStudents; i++ ) {
            sList[i] = new Student("stu "+i, "4mt16cs00"+i, "5CS0"+i,'M');
        }

        //Call for allocation
        for(int i=1;i<=classCount;i++) {

            //This allocates students to remaining classroom, By using Student list,
            //Student pointer, and needs total student count for the allocation rest will be null
            studentPointer = classRooms[i].allocateStudentsToSeat(sList,studentPointer,totalStudents);

            //Print the arrangement of classroom after allocating.Call this function.
            classRooms[i].printClassRoomArrangemet();
        }
    }
}
