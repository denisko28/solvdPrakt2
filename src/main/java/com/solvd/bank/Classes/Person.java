package com.solvd.bank.Classes;

public class Person {
    private static int maxNameLength = 15;
    private String firstName;
    private String lastName;
    private String patronymic;

    public Person() {}

    public Person(String firstName, String lastName, String patronymic){
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public static int getMaxNameLength(){
        return maxNameLength;
    }

    public static void setMaxNameLength(int maxNameLengthParam){
        maxNameLength = maxNameLengthParam;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
