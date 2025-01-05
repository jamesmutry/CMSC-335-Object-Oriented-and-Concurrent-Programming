import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private SimulationManager simulationManager;
    private JLabel clockLabel;
    private JTextArea carInfoArea;

    public InfoPanel(SimulationManager simulationManager) {
        this.simulationManager = simulationManager;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 600));

        // Create components
        clockLabel = new JLabel("Simulation Time: 0 seconds");
        carInfoArea = new JTextArea();
        carInfoArea.setEditable(false);

        // Add components to the panel
        add(clockLabel, BorderLayout.NORTH);
        add(new JScrollPane(carInfoArea), BorderLayout.CENTER);

        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createTitledBorder("Simulation Info"));

        // Start updating the panel dynamically
        new Timer(1000, e -> updateInfo()).start();
    }

    private void updateInfo() {
        // Fetch the current time from the ClockThread
        int currentTime = simulationManager.getClockThread().getCurrentTime();
        clockLabel.setText("Simulation Time: " + currentTime + " seconds");

        // Update car information
        StringBuilder carInfo = new StringBuilder();
        for (CarThread car : simulationManager.getCars()) {
            carInfo.append(car.getCarName())
                    .append(" - Position: ").append(car.getPosition())
                    .append(" m, Speed: ").append(car.getSpeed()).append(" m/s\n");
        }
        carInfoArea.setText(carInfo.toString());
    }
}
