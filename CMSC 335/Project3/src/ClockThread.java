public class ClockThread extends Thread {
    private int currentTime;  // Tracks the simulation time in seconds
    private boolean running;
    private boolean paused;

    public ClockThread() {
        this.currentTime = 0; // Start at 0 seconds
        this.running = true;
        this.paused = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (!paused) {
                    System.out.println("Simulation Time: " + currentTime + " seconds");
                    currentTime++; // Increment time by 1 second
                    Thread.sleep(1000); // 1-second interval
                } else {
                    Thread.sleep(100); // Shorter sleep while paused
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void pause() {
        paused = true;
    }

    public void resumeClock() {
        paused = false;
    }

    public void stopThread() {
        running = false;
    }
}