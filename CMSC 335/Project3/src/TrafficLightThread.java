public class TrafficLightThread extends Thread {
    private String intersection;
    private String state; // Current state: "Red", "Yellow", or "Green"
    private boolean running;
    private boolean paused;

    public TrafficLightThread(String intersection) {
        this.intersection = intersection;
        this.state = "Red"; // Default state
        this.running = true;
        this.paused = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (!paused) {
                    switch (state) {
                        case "Red":
                            state = "Green";
                            break;
                        case "Green":
                            state = "Yellow";
                            break;
                        case "Yellow":
                            state = "Red";
                            break;
                    }
                    System.out.println(intersection + " Light: " + state);

                    // Wait for 5 seconds before changing the state
                    Thread.sleep(5000);
                } else {
                    Thread.sleep(100); // Shorter sleep while paused
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Renamed to avoid conflict with Thread.getState()
    public String getLightState() {
        return state;
    }

    public void pause() {
        paused = true;
    }

    public void resumeLight() {
        paused = false;
    }

    public void stopThread() {
        running = false;
    }
}