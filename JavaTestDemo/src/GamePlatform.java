public class GamePlatform {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
        double speed = initialSpeed;
        int i= 1;

        // Iterate through each inclination and adjust the speed
        for (int inclination : inclinations) {

            System.out.println("----> loop number: " + i);
            speed -= inclination;
            System.out.println("speed: " + speed + ", inclination: " + inclination);
            i++;

            // Check if speed falls to 0 or below
            if (speed <= 0) {
                System.out.println("speed zero");
                return 0; // Return 0 if speed is zero or negative (character loses a life)
            }
        }

        // Return the final speed after all adjustments
        return speed;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        System.out.println(calculateFinalSpeed(60.0, new int[]{0, 30, 0, -45, 0}));
    }
}
