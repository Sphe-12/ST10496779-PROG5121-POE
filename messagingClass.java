import javax.swing.JOptionPane;

public class messagingClass {
    public static void main(String[] args) {
        login();
        mainMenu();
    }

    private static void login() {
        while (true) {
            String username = JOptionPane.showInputDialog("Enter Username:");
            String password = JOptionPane.showInputDialog("Enter Password:");

            if (isValidInput(username) && isValidInput(password)) {
                JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter both username and password.");
            }
        }
    }

    private static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    private static void mainMenu() {
        String[] options = {"Send Messages", "Show Recently Sent Messages", "Quit"};
        boolean run = true;
        while (run) {
            int choice = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "QuickChat Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );

            switch (choice) {
                case 0 -> sendMessages();
                case 1 -> JOptionPane.showMessageDialog(null, "Coming Soon.");
                case 2, JOptionPane.CLOSED_OPTION -> run = false;
                default -> { }
            }
        }
    }

    private static void sendMessages() {
        while (true) {
            String messageCountStr = JOptionPane.showInputDialog("How many messages do you want to send?");
            if (messageCountStr == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.");
                return;
            }
            messageCountStr = messageCountStr.trim();
            if (messageCountStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
                continue;
            }
            try {
                int messageCount = Integer.parseInt(messageCountStr);
                if (messageCount <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive number.");
                    continue;
                }
                for (int i = 0; i < messageCount; i++) {
                    String message;
                    do {
                        message = JOptionPane.showInputDialog("Enter message " + (i + 1) + ":");
                        if (message == null) {
                            JOptionPane.showMessageDialog(null, "Message entry cancelled.");
                            return;
                        }
                        message = message.trim();
                        if (message.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Message cannot be empty.");
                        }
                    } while (message.isEmpty());
                    JOptionPane.showMessageDialog(null, "Message sent: " + message);
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }
}