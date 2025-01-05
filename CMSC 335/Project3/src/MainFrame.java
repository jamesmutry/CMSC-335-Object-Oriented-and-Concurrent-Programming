import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton startButton, pauseButton, stopButton, addCarButton;
    private TrafficPanel trafficPanel; // Make sure it's declared as TrafficPanel
    private JPanel controlPanel;
    private InfoPanel infoPanel;
    private SimulationManager simulationManager;

    public MainFrame() {
        setTitle("Traffic Simulation");
        setSize(1200, 800); // Increased window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        simulationManager = new SimulationManager();
        trafficPanel = new TrafficPanel(simulationManager); // This is TrafficPanel
        controlPanel = new JPanel();
        infoPanel = new InfoPanel(simulationManager);

        // Create buttons
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
        addCarButton = new JButton("Add Car");

        // Add button functionality
        startButton.addActionListener(e -> simulationManager.startSimulation());
        pauseButton.addActionListener(e -> simulationManager.pauseSimulation());
        stopButton.addActionListener(e -> simulationManager.stopSimulation());
        addCarButton.addActionListener(e -> simulationManager.addCar());

        // Organize layout
        controlPanel.add(startButton);
        controlPanel.add(pauseButton);
        controlPanel.add(stopButton);
        controlPanel.add(addCarButton);

        setLayout(new BorderLayout());
        add(trafficPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(infoPanel, BorderLayout.EAST);

        // Periodic refresh for the TrafficPanel
        Timer timer = new Timer(100, e -> trafficPanel.refresh()); // Call refresh on TrafficPanel
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}