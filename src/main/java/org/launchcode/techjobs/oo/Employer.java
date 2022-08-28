package org.launchcode.techjobs.oo;

public class Employer extends JobField {

    private int id;
//    private static int nextId = 1;
//    private String value;

//    public Employer() {
//        id = nextId;
//        nextId++;
//    }

    public Employer(String value) {
        super(value);
        this.id = getId();
    }

    // Custom toString, equals, and hashCode methods:

//    @Override
//    public String toString() {
//        if(value.length() > 0) {
//            return value;
//        } else{
//            return "Data not available";
//        }
//    }

//    @Override
//    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
//        if (this == o) return true;
//        if (!(o instanceof Employer)) return false;
//        Employer employer = (Employer) o;
//        return ((Employer) o).getId() == employer.getId();
//    }

//    public void setValue(String value) {
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
//
//    // Getters and Setters:
//
//    public int getId() {
//        return id;
//    }
//

//        this.value = value;
//    }

}
