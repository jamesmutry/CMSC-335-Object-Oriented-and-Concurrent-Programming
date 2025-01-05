import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TrafficPanel extends JPanel {
    private SimulationManager simulationManager;

    public TrafficPanel(SimulationManager simulationManager) {
        this.simulationManager = simulationManager;
        setPreferredSize(new Dimension(1000, 600)); // Ensure panel is large enough
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw traffic lights
        List<TrafficLightThread> trafficLights = simulationManager.getTrafficLights();
        for (int i = 0; i < trafficLights.size(); i++) {
            String lightState = trafficLights.get(i).getLightState(); // Fetch light state
            int x = 50 + i * 300; // Space intersections evenly
            int y = 50;

            // Draw intersection block
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 50, 150);
            g.drawString("Intersection " + (i + 1), x - 10, y - 10);

            // Draw light state as a colored circle
            switch (lightState) {
                case "Red":
                    g.setColor(Color.RED);
                    break;
                case "Yellow":
                    g.setColor(Color.YELLOW);
                    break;
                case "Green":
                    g.setColor(Color.GREEN);
                    break;
            }
            g.fillOval(x + 10, y + 10, 30, 30); // Circle representing the light
        }

        // Draw cars
        List<CarThread> cars = simulationManager.getCars();
        for (int i = 0; i < cars.size(); i++) {
            int carPosition = cars.get(i).getPosition();
            int x = carPosition % getWidth(); // Wrap around the panel width
            int y = 300 + i * 50; // Space cars vertically

            // Ensure car stays within bounds
            if (carPosition >= 0) {
                // Draw car
                g.setColor(Color.BLUE);
                g.fillRect(x, y, 50, 20);
                g.setColor(Color.BLACK);
                g.drawString(cars.get(i).getCarName(), x, y - 5);
            }
        }
    }

    // Repaint periodically to reflect simulation updates
    public void refresh() {
        repaint();
    }
}