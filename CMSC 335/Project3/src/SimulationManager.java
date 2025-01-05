import java.util.ArrayList;
import java.util.List;

public class SimulationManager {
    private ClockThread clockThread;
    private List<TrafficLightThread> trafficLights;
    private List<CarThread> cars;
    private boolean running;

    public ClockThread getClockThread() {
        return clockThread;
    }
    public SimulationManager() {
        clockThread = new ClockThread();
        trafficLights = new ArrayList<>();
        cars = new ArrayList<>();
        running = false;

        // Initialize three traffic lights
        for (int i = 0; i < 3; i++) {
            trafficLights.add(new TrafficLightThread("Intersection " + (i + 1)));
        }
    }

    public void startSimulation() {
        if (!running) {
            running = true;
            clockThread.start();
            trafficLights.forEach(Thread::start);
            cars.forEach(Thread::start);
        }
    }

    public void pauseSimulation() {
        running = false;
        clockThread.pause();
        trafficLights.forEach(TrafficLightThread::pause);
        cars.forEach(CarThread::pause);
    }

    public void stopSimulation() {
        running = false;
        clockThread.stopThread();
        trafficLights.forEach(TrafficLightThread::stopThread);
        cars.forEach(CarThread::stopThread);
    }

    public void addCar() {
        int trafficLightIndex = cars.size() % trafficLights.size(); // Cycle through traffic lights
        TrafficLightThread assignedLight = trafficLights.get(trafficLightIndex);
        CarThread car = new CarThread("Car " + (cars.size() + 1), assignedLight);
        cars.add(car);
        if (running) {
            car.start();
        }
    }

    public List<CarThread> getCars() {
        return cars;
    }

    public List<TrafficLightThread> getTrafficLights() {
        return trafficLights;
    }
}
