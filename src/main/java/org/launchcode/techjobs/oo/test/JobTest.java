package org.launchcode.techjobs.oo.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertTrue;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobTest = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobTest.getEmployer() instanceof Employer);
        assertTrue(jobTest.getLocation() instanceof Location);
        assertTrue(jobTest.getPositionType() instanceof PositionType);
        assertTrue(jobTest.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(jobTest.getName() instanceof String);
        assertEquals("ACME", jobTest.getEmployer().toString());
        assertEquals("Desert", jobTest.getLocation().toString());
        assertEquals("Quality control", jobTest.getPositionType().toString());
        assertEquals("Persistence", jobTest.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        Job jobOne = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobOne.equals(jobTwo));
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
        assertTrue(jobOne.toString().contains("Name: Product tester"));
        assertTrue(jobOne.toString().contains("Employer: ACME"));
        assertTrue(jobOne.toString().contains("Location: Desert"));
        assertTrue(jobOne.toString().contains("Position Type: Quality control"));
        assertTrue(jobOne.toString().contains("Core Competency: Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(jobOne.toString().contains("Location: Data not Available"));
        assertTrue(jobTwo.toString()=="OOPS! This job does not seem to exist.");
    }

}
