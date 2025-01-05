public class CarThread extends Thread {
    private String carName;
    private int speed;         // Current speed in meters/second
    private int position;      // Current position in meters
    private TrafficLightThread trafficLight; // Associated traffic light
    private boolean running;
    private boolean paused;

    public CarThread(String carName, TrafficLightThread trafficLight) {
        this.carName = carName;
        this.speed = 10; // Default speed
        this.position = 0;
        this.trafficLight = trafficLight;
        this.running = true;
        this.paused = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (!paused) {
                    // Adjust speed based on traffic light state
                    String lightState = trafficLight.getLightState(); // Fetch the light state
                    switch (lightState) {
                        case "Green":
                            speed = 20; // Speed up
                            break;
                        case "Yellow":
                            speed = 5; // Slow down
                            break;
                        case "Red":
                            speed = 0; // Stop completely
                            break;
                    }

                    // Update position only if speed > 0
                    if (speed > 0) {
                        position += speed;
                        System.out.println(carName + " is at position " + position + " meters, speed: " + speed + " m/s");
                    } else {
                        System.out.println(carName + " is stopped at position " + position + " meters due to red light.");
                    }

                    // Simulate one-second intervals
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(100); // Shorter sleep while paused
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public String getCarName() {
        return carName;
    }

    public void pause() {
        this.paused = true;
    }

    public void resumeCar() {
        this.paused = false;
    }

    public void stopThread() {
        this.running = false;
    }
}