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

}
