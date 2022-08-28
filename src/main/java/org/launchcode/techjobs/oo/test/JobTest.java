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
        Job jobOne = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobOne==jobTwo);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobOne = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', (jobOne.toString()).charAt(jobOne.toString().length()-1));
        assertEquals('\n', (jobOne.toString()).charAt(0));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobOne = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(jobOne.toString(), "\nID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(jobTwo.toString(),"OOPS! This job does not seem to exist.");
        assertEquals(jobOne.toString(), "\nID: "+jobOne.getId()+"\nName: Product tester\nEmployer: ACME\nLocation: Data not available\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

}
