package se2526;

public class HRCalculator {
    public static int calculateMaxHR(int age){
        if(age>120 || age<0){
            throw new IllegalArgumentException(
                    "Age out of bounds"
            );
        }
        return 220 - age;
    }
    public static String getWorkoutZone(int age, int bpm) {
        int maxHR = calculateMaxHR(age);
        double percentage = (double) bpm / maxHR * 100;

        if (percentage < 60) {
            return "Resting";
        } else if (percentage < 70) {
            return "Warm-up";
        } else if (percentage < 80) {
            return "Fat Burn";
        } else if (percentage < 90) {
            return "Aerobic";
        } else if (percentage <= 100) {
            return "Anaerobic";
        } else {
            return "Maximum";
        }
    }
}

