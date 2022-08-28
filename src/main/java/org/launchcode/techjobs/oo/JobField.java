package org.launchcode.techjobs.oo;

import java.util.Objects;
public abstract class JobField {
    public String value;
    public static int id;


    public JobField(String value) {
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        if(this.value.length() > 0) {
            return this.getValue();
        } else{
            return "Data not available";
        }
    }
//    @Override
//    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
//        if (this == o) return true;
//        if (!(o instanceof JobField)) return false;
//        JobField jobField = (JobField) o;
//        return ((JobField) o).getId() == jobField.getId();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return ((JobField)o).getId()==jobField.getId();
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getValue());
    }



    public String getValue() {
        return this.value;
    }



    public void setValue(String value){
        this.value = value;
    }



}
