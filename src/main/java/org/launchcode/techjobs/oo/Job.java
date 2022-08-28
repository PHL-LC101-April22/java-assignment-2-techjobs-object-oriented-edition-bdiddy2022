package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    public int id;
    private static int nextId = 1;


    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }
    public Job(String name,Employer employer,Location location,PositionType positionType,CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location= location;
        this.positionType= positionType;
        this.coreCompetency= coreCompetency;

        setId();


    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

//    @Override
//    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
//        if (this == o) return true;
//        if (!(o instanceof Job)) return false;
//        Job job = (Job) o;
//        return ((Job)o).getId() == job.getId();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId() && Objects.equals(getName(), job.getName()) && Objects.equals(getEmployer(), job.getEmployer()) && Objects.equals(getLocation(), job.getLocation()) && Objects.equals(getPositionType(), job.getPositionType()) && Objects.equals(getCoreCompetency(), job.getCoreCompetency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer){
        this.employer.value = employer.value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location.value = location.value;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType.value = positionType.value;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency.value = coreCompetency.value;
    }

    public int getId() {
        return this.id;
    }

    public void setId(){
        JobField.id = this.id;
    }


    @Override
    public String toString() {

        String returnStatement = "\nID: "+this.getId()+"\nName: " + this.name +
                "\nEmployer: " + this.getEmployer() +
                "\nLocation: " + this.getLocation()+
                "\nPosition Type: " + this.getPositionType()+
                "\nCore Competency: " + this.getCoreCompetency()+
                "\n";
        String defaultAnswer = "Data not available";

        if(this.id==getId()&&name.length()==0&&employer.getValue().length()==0&&location.getValue().length()==0&&positionType.getValue().length()==0&&coreCompetency.getValue().length()==0){
            return "OOPS! This job does not seem to exist.";
        } else {
            return returnStatement;
        }
    }
}
