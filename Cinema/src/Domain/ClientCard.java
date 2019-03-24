package Domain;

public class ClientCard extends Entity{
    private int id, points;
    private String CNP, firstName, lastName, DOB, regDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public ClientCard(int id, String CNP, int points, String firstName, String lastName, String DOB, String regDate) {
        this.id = id;
        this.CNP = CNP;
        this.points = points;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.regDate = regDate;
    }

    @Override
    public String toString(){
        return "Client{" +
                "id='" + getId() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", dateOfBirth='" + DOB + '\'' +
                ", dateOfRegistration='" + regDate + '\'' +
                '}';
    }
}
