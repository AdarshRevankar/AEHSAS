package com.adrino.aehsas;

class Student {
    //Attributes
    String stuName, stuUsn, branch;
    int sem, rollNumber;
    char sex;

    //Constructor
    Student(String stuName, String stuUsn, String stuESN, char sex) {
        this.stuName = stuName;
        this.stuUsn = stuUsn;
        if (stuESN.length() <= 6) {
            this.sem = Integer.parseInt(String.valueOf(stuESN.charAt(0)));
            this.branch = stuESN.substring(1, 2);
            this.rollNumber = Integer.parseInt(stuESN.substring(3, stuESN.length()));
        } else
            System.err.println("Error : 1 - ESN is not proper");
        this.sex = sex;
    }
}