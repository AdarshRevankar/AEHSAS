package com.adrino.aehsas;

//Classroom object stores the classroom attributes
//Methods to work with, Arrange seats & to print to Console.
class ClassRoom{
    int capasity, row, column;
    Student seatedStudent[][];
    static final int NUMBER_OF_STUDENTS_IN_A_BENCH = 2;
    ClassRoom(int capasity, int row, int column){
        this.capasity = capasity;
        this.row = row;
        this.column = column;
        seatedStudent = new Student[this.row+1][this.column+1];	// +1 because, since array starts from 1
    }


    int allocateStudentsToSeat(Student []sList, int studentPointer,int totalNumberOfStudents) {
        //Assigning classroom : Main Logic for allocation
        //col = column pointer
        //row = row pointer
        //student pointer points to the student list and assigns to the student array of the class object.

        //loop from 1 - number of column times
        for(int col=1;col<=this.column;col++)
        {
            if(!isEven(col))
            {
                //loop from 1 - number of row times...................Pattern 1 2 3
                //Stop this also for if student student pointer exceeds total number of students
                for(int row = 1;row<=this.row && studentPointer<=totalNumberOfStudents;row++)
                {
                    //Add student to the table & Point to next pointer.
                    this.seatedStudent[row][col] = sList[studentPointer++];
                }
            }
            else if(isEven(col))
            {
                //loop from last number of row times to 1...................Pattern 3 2 1
                //Stop this also for if student student pointer exceeds total number of students
                for(int row=this.row; row>=1 && studentPointer<=totalNumberOfStudents;row--)
                {
                    //Add student to the table & Point to next pointer.
                    this.seatedStudent[row][col] = sList[studentPointer++];
                }
            }
        }
        //return next room starting pointer starting list number
        //list number is the DB first list number.
        return studentPointer;
    }


    //Prints the location to the output console.
    void printClassRoomArrangemet() {
        System.out.println("Class Room - "+this.getClass());
        //Loop for table.
        for(int i = 1;i<=this.row;i++) {
            for(int j = 1;j<=this.column;j++)
                try{
                    System.out.print(this.seatedStudent[i][j].stuUsn+"\t");
                }catch(java.lang.NullPointerException e) {
                    System.out.print("NULL\t");
                }
            System.out.println();
        }
    }

    //Check the number is Even or not
    boolean isEven(int num) {
        return num%2==0;
    }
}