public class Car extends Thread {
    private String name;
    private int speed; // m/s
    private int position;
    private boolean running;
    private boolean paused;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.position = 0;
        running = true;
        paused = false;
    }

    public void run() {
        while (running) {
            if (!paused) {
                position += speed; // Update position
                System.out.println(name + " Position: " + position + " meters");
                try {
                    Thread.sleep(1000); // 1-second interval
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void pause() {
        paused = true;
    }

    public void stopThread() {
        running = false;
    }
}
