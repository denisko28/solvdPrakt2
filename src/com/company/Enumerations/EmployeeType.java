package com.company.Enumerations;

public enum EmployeeType {
    CEO ("Гендиректор", "загальне управління банком"),
    BranchHead ("Директор відділеня", "управління відділенням"),
    SimpleEmployee ("Звичайний працівник", "відкриття рахунків, оформлення нових клієнтів");

    private final String position;
    private final String responsibility;


    EmployeeType(String position, String responsibility) {
        this.position = position;
        this.responsibility = responsibility;
    }

    public String getPosition() { return position; }

    public String getResponsibility() { return responsibility; }

    @Override
    public String toString() {
        return "EmployeeType{" +
                "position='" + position + '\'' +
                ", responsibility='" + responsibility + '\'' +
                '}';
    }
}
