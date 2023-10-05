package org.example;

public class Main {
    public static void main(String[] args) {

        University universityOne = new University("American1", "Massachusetts Institute of Technology", "MIT",
                1861, StudyProfile.Economics);
        University universityTwo = new University("Swiss1", "Swiss Federal Institute of Technology Zürich",
                "ETH Zürich", 1855, StudyProfile.PhysicsScience);

        Student studentOne = new Student("Ben Bernanke", "Mit1", 1, 89.99f);
        Student studentTwo = new Student("Albert Einstein", "Eth1", 1, 88.99f);

        System.out.println(universityOne);
        System.out.println(universityTwo);
        System.out.println(studentOne);
        System.out.println(studentTwo);
    }
}