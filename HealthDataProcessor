
public class HealthDataProcessor {

    public static double calculateBMI(double weight, double height) {
        // BMI = weight (kg) / (height (m) ^ 2)
        return weight / Math.pow(height / 100, 2); // height in cm, converted to meters
    }

    public static String determineHealthRisk(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        double weight = 70; // kg
        double height = 175; // cm
        
        double bmi = calculateBMI(weight, height);
        String healthRisk = determineHealthRisk(bmi);

        System.out.println("BMI: " + bmi);
        System.out.println("Health Risk: " + healthRisk);
    }
}

