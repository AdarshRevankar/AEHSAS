package com.adrino.aehsas;

//Classroom object stores the classroom attributes
//Methods to work with, Arrange seats & to print to Console.
class ClassRoom {
    int capasity, row, column;
    Student seatedStudent[][];

    ClassRoom(int capasity, int row, int column) {
        this.capasity = capasity;
        this.row = row;
        this.column = column;
        seatedStudent = new Student[this.row + 1][(2 * this.column + 1)];    // +1 because, since array starts from 1
    }


    listPointer allocateStudentsToSeat(Student[] sList, listPointer stuListPointer, int totalNumberOfStudents) {
        //Assigning classroom : Main Logic for allocation
        //sw=switch pointer
        //col = column pointer
        //row = row pointer
        //student pointer points to the student list and assigns to the student array of the class object.
        int sw = 0;
        //loop from 1 - number of column times
        for (int col = 1; col <= 2 * this.column; col++) {
            if (stuListPointer.left <= totalNumberOfStudents || stuListPointer.right <= totalNumberOfStudents) {
                if (sw == 0) {
                    if (isEven(col)) {
                        for (int row = 1; row <= this.row && stuListPointer.left <= totalNumberOfStudents; row++) {
                            if (!sList[stuListPointer.left].isPlaced) {
                                sList[stuListPointer.left].isPlaced = true;
                                this.seatedStudent[row][col] = sList[stuListPointer.left++];
                            } else {
                                stuListPointer.left++;
                                row--;
                                if (stuListPointer.left >= totalNumberOfStudents)
                                    break;
                            }
                        }
                    } else {
                        for (int row = 1; row <= this.row && stuListPointer.right <= totalNumberOfStudents; row++) {
                            if (seatingCondition(sList[stuListPointer.left], sList[stuListPointer.right]) && !sList[stuListPointer.right].isPlaced) {
                                sList[stuListPointer.right].isPlaced = true;
                                this.seatedStudent[row][col] = sList[stuListPointer.right++];
                            } else {
                                stuListPointer.right++;
                                row--;
                                if (stuListPointer.right >= totalNumberOfStudents)
                                    break;
                            }
                        }
                    }
                    if ((col - 2) % 4 == 0)    //2  6  8 column no. switch
                        sw = 1;
                } else if (sw == 1) {

                    if (isEven(col)) {
                        for (int row = this.row; row >= 1 && stuListPointer.left <= totalNumberOfStudents; row--) {
                            if (!sList[stuListPointer.left].isPlaced) {
                                sList[stuListPointer.left].isPlaced = true;
                                this.seatedStudent[row][col] = sList[stuListPointer.left++];
                            } else {
                                stuListPointer.left++;
                                row++;
                                if (stuListPointer.left >= totalNumberOfStudents)
                                    break;
                            }
                        }
                    } else {
                        for (int row = this.row; row >= 1 && stuListPointer.right <= totalNumberOfStudents; row--) {
                            if (seatingCondition(sList[stuListPointer.left], sList[stuListPointer.right])) {
                                sList[stuListPointer.right].isPlaced = true;
                                this.seatedStudent[row][col] = sList[stuListPointer.right++];
                            } else {
                                stuListPointer.right++;
                                row++;
                                if (stuListPointer.right >= totalNumberOfStudents)
                                    break;
                            }
                        }
                    }
                    if (col % 4 == 0)        //4 8 12 column number switch
                        sw = 0;
                }
            }
        }
        return stuListPointer;
    }


    //Prints the location to the output console.
    void printClassRoomArrangemet() {
        System.out.println("Class Room - " + this.getClass());
        //Loop for table.
        System.out.println("+------------------------------------------------------------------------------------------------+");
        for (int i = 1; i <= this.row; i++) {
            for (int j = 1; j <= 2 * this.column; j++)
                try {
                    System.out.print("|" + this.seatedStudent[i][j].stuUsn + "|\t");
                } catch (java.lang.NullPointerException e) {
                    System.out.print("\tNULL\t");
                }
            System.out.println();
        }
        System.out.println("+------------------------------------------------------------------------------------------------+");
    }

    void printSeated(Student[] list, int total) {
        System.out.println("Class Room - " + this.getClass());
        //Loop for table.

        for (int i = 1; i <= total; i++) {
            try {
                System.out.print(list[i] + "\t");
            } catch (java.lang.NullPointerException e) {
                System.out.print("NULL\t");
            }
            System.out.println();
        }

    }

    boolean seatingCondition(Student left, Student right) {

        if (left.sem == right.sem && left.branch.equals(right.branch) && left.rollNumber == right.rollNumber)
            return false;
        else if (left.sem != right.sem || !left.branch.equals(right.branch))
            return true;
        else
            return false;
    }

    boolean isEven(int x) {
        return x % 2 == 0;
    }
}
