import java.util.Arrays;

class Person{
    private String firstname;
    private String lastname;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String ssn;
    private int numberOfSiblings = 0;
    private Person[] siblings = new Person[0];

    public Person(String firstname, String lastname, int birthDay, int birthMonth, int birthYear, String ssn) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.ssn = ssn;

    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname0) {
        this.firstname = firstname0;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname0) {
        this.lastname = lastname0;
    }

    public String getBirthday() {
        return birthDay + "/" + birthMonth + "/" + this.birthYear;
    }

    public void addSibling(Person sibling) {
        Person[] newSiblings = Arrays.copyOf(this.siblings, this.siblings.length + 1);
        newSiblings[this.siblings.length] = sibling;
        this.siblings = newSiblings;
    }

    public Person[] getSiblings() {
        return this.siblings;
    }
}