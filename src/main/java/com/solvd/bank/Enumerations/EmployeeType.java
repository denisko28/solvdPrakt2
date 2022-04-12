package com.solvd.bank.Enumerations;

public enum EmployeeType {
    CEO("CEO", "general bank management"),
    BRANCH_HEAD("Branch head", "branch management"),
    SIMPLE_EMPLOYEE("Simple employee", "accounts opening, new clients registration");

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
