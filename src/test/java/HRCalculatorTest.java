import org.junit.jupiter.api.Test;
import se2526.HRCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HRCalculatorTest {
    @Test
    public void testValidMaxHR(){
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }
    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }
    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testWorkoutZone_Resting() {
        var result = HRCalculator.getWorkoutZone(40, 100);
        assertEquals("Resting", result);
    }

    @Test
    public void testWorkoutZone_WarmUp() {
        var result = HRCalculator.getWorkoutZone(40, 120);
        assertEquals("Warm-up", result);
    }

    @Test
    public void testWorkoutZone_FatBurn() {
        var result = HRCalculator.getWorkoutZone(40, 135);
        assertEquals("Fat Burn", result);
    }

    @Test
    public void testWorkoutZone_Aerobic() {
        var result = HRCalculator.getWorkoutZone(40, 153);
        assertEquals("Aerobic", result);
    }

    @Test
    public void testWorkoutZone_Anaerobic() {
        var result = HRCalculator.getWorkoutZone(40, 170);
        assertEquals("Anaerobic", result);
    }

    @Test
    public void testWorkoutZone_Maximum() {
        var result = HRCalculator.getWorkoutZone(40, 185);
        assertEquals("Maximum", result);
    }

    @Test
    public void testWorkoutZone_BoundaryAt60Percent() {
        var result = HRCalculator.getWorkoutZone(40, 108);
        assertEquals("Warm-up", result);
    }

}

