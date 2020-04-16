package com.adrino.aehsas;

class ClassRoom {
    int capasity, row, column;
    Student seatedStudent[][];

    ClassRoom(int capasity, int row, int column) {
        this.capasity = capasity;
        this.row = row;
        this.column = column;
        seatedStudent = new Student[this.row + 1][this.column + 1];    // +1 because, since array starts from 1
    }

    int allocateStudentsToSeat(Student[] sList, int studentPointer, int totalNumberOfStudents) {
        //Assigning classroom
        //sw=switch pointer
        //col = column pointer
        //row = row pointer
        //student pointer points to the student list and assignes to the student array of the classobj.
        int sw = 0;
        for (int col = 1; col <= this.column; col++) {
            if (sw == 0) {
                for (int row = 1; row <= this.row && studentPointer <= totalNumberOfStudents; row++) //Patter 1 2 3
                {
                    this.seatedStudent[row][col] = sList[studentPointer++];
                    //System.out.println(seatedStudent[row][col].stuUsn);
                }
                sw = 1;
            } else if (sw == 1) {
                for (int row = this.row; row >= 1 && studentPointer <= totalNumberOfStudents; row--)    //Pattern 3 2 1
                {
                    this.seatedStudent[row][col] = sList[studentPointer++];
                    //System.out.println(seatedStudent[row][col].stuUsn);
                }
                sw = 0;
            }
        }
        return studentPointer;
    }

    void printClassRoomArrangemet() {
        System.out.println("Class Room - " + this.toString());
        for (int i = 1; i <= this.row; i++) {
            for (int j = 1; j <= this.column; j++)
                try {
                    System.out.print(this.seatedStudent[i][j].stuUsn + " ");
                } catch (java.lang.NullPointerException e) {
                    System.out.print("NULL ");
                }
            System.out.println();
        }
    }
}