import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class DeliverableTest {
    private Deliverable deliverable;
    private Calendar cal;

    @Before
    public void setUp() {
        cal = Calendar.getInstance();
        deliverable = new Deliverable("Deliverable1", "Details1", 2.2, 55, 2.5, cal);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Deliverable(null, "details", 1.5, 1, 1.0, Calendar.getInstance());
            fail("Deliverable.Deliverable() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            new Deliverable("name", null, 1.5, 1, 1.0, Calendar.getInstance());
            fail("Deliverable.Deliverable() should throw a NullPointerException if the details argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            new Deliverable("name", "details", 1.5, 1, 1.0, null);
            fail("Deliverable.Deliverable() should throw a NullPointerException if the date argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Deliverable("", "details", 1.5, 1, 1.0, Calendar.getInstance());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new Deliverable("name", "", 1.5, 1, 1.0, Calendar.getInstance());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new Deliverable("name", "details", -1.5, 1, 1.0, Calendar.getInstance());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the rate argument is negative!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new Deliverable("name", "details", 1.5, -1, 1.0, Calendar.getInstance());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the materialCost argument is negative!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new Deliverable("name", "details", 1.5, 1, -Double.MIN_VALUE, Calendar.getInstance());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the productionTime argument is non-positive!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new Deliverable("name", "details", 1.5, 1, 0.0, Calendar.getInstance());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the productionTime argument is non-positive!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetCostEstimate() {
        assertEquals("Deliverable.getCostEstimate() should return the correct value!", 61,
                deliverable.getCostEstimate(), 0.0001);
    }

    @Test
    public void testGetMaterialCost() {
        assertEquals("Deliverable.getMaterialCost() should return the correct value!", 55,
                deliverable.getMaterialCost());
    }

    @Test
    public void testGetTimeRequired() {
        assertEquals("Deliverable.getTimeRequired() should return the correct value!", 2.5,
                deliverable.getTimeRequired(), 0.0001);
    }

    @Test
    public void testGetDate() throws InterruptedException {
        assertEquals("Deliverable.getDate() should return the correct object!", cal, deliverable.getDate());
    }
}
