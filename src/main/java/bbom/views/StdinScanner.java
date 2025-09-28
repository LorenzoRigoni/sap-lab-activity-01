package bbom.views;

import bbom.controllers.Controller;

import java.util.Scanner;

/**
 * This thread checks if the user write something in the stdin.
 */
public class StdinScanner extends Thread {
    private final Controller controller;

    public StdinScanner(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            final String input = scanner.nextLine();
            this.controller.printStdinInput(input);
        }
    }
}
