package vauautomat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class gui extends JFrame {
    // (Other attributes from the open file remain unchanged)
    
    private ArrayList<String> köpHistory = new ArrayList<>(); // A list to store purchase history.
    private final String HISTORY_FILE = "kopHistory.txt";    // File to save purchase history.

    // Add this method to save the köp-history
    public void saveKopHistory(String itemName, double price) {
        // Format the history entry (item, price, timestamp)
        String purchaseEntry = String.format("%s - %.2f SEK - %s", itemName, price, LocalDateTime.now());
        köpHistory.add(purchaseEntry); // Add the entry to the history list

        // Save it to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            writer.write(purchaseEntry);
            writer.newLine(); // Add a new line for the next entry
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save purchase history: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Example method to display the köphistory (optional)
    public void displayKopHistory() {
        StringBuilder historyDisplay = new StringBuilder("Purchase History:\n");
        for (String entry : köpHistory) {
            historyDisplay.append(entry).append("\n");
        }

        JOptionPane.showMessageDialog(this, historyDisplay.toString(), "Köp History",
                                      JOptionPane.INFORMATION_MESSAGE);
    }

    // Attach to köp button's action listener
    private void attachListeners() {
        // Assuming `köp` is the button to make a purchase
        köp.addActionListener(e -> {
            // Example: Call saveKopHistory when a purchase is made
            String selectedItem = "Example Item"; // Replace with actual selected item logic
            double price = 50.0;                 // Replace with actual price logic

            saveKopHistory(selectedItem, price);

            JOptionPane.showMessageDialog(this, "Purchase saved for: " + selectedItem,
                                          "Success", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    // The rest of the gui class remains unchanged...
}