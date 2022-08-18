package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertTrue;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job jobTwo = new Job("testtest",new Employer("testEmp"),new Location ("testLoc"),new PositionType("testPos"),new CoreCompetency("testCC"));
        Job jobOne = new Job("testtest",new Employer("testEmp"),new Location ("testLoc"),new PositionType("testPos"),new CoreCompetency("testCC"));
        assertNotEquals(true,jobOne==jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob.getEmployer().value, "ACME");
        assertEquals(testJob.getLocation().value,"Desert");
        assertEquals(testJob.getPositionType().value,"Quality control");
        assertEquals(testJob.getCoreCompetency().value, "Persistence");
        assertEquals(testJob.getName(), "Product tester");
        assertTrue((testJob.getEmployer().getClass()).equals(Employer.class));
        assertTrue((testJob.getLocation().getClass()).equals(Location.class));
        assertTrue((testJob.getPositionType().getClass()).equals(PositionType.class));
        assertTrue((testJob.getCoreCompetency().getClass()).equals(CoreCompetency.class));
        assertTrue(testJob.getName().equals("Product tester"));
    }

    @Test
    public void testJobsForEquality(){
        Job jobThree =new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobFour = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobThree==jobFour);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobFive = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', (jobFive.toString()).charAt(jobFive.toString().length()-1));
        assertEquals('\n', (jobFive.toString()).charAt(0));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobSix = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(jobSix.toString(), "\nID: 5\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobSeven = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobEight = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(jobEight.toString(),"OOPS! This job does not seem to exist.");
        assertEquals(jobSeven.toString(), "\nID: "+jobSeven.getId()+"\nName: Product tester\nEmployer: ACME\nLocation: Data not available\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

}
