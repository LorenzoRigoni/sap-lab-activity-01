package bbom.controllers;

/**
 * This thread increments every second the counter.
 */
public class AutonomousController extends Thread {
    private final Controller controller;

    public AutonomousController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.controller.updateState();
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
