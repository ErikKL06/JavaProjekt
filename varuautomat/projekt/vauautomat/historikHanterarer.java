package vauautomat;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class historikHanterarer {
    private Map<Utrymme, Integer> purchaseMap;          // Map to track Utrymme objects and quantities
    private final String HISTORY_FILE = "kopHistory.txt"; // File to store purchase history

    // Constructor
    public historikHanterarer() {
        this.purchaseMap = new HashMap<>();
    }

    // Add a Utrymme object to the current purchase
    public void addItem(AbsVaror item) {
        purchaseMap.put(item, purchaseMap.getOrDefault(item, 0) + 1); // Increment quantity for the item
    }

    // Save the current purchase to a history file
    public void savePurchaseHistory() {
        if (purchaseMap.isEmpty()) {
            System.out.println("No items to save!"); // Alternatively, throw an exception
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            for (Map.Entry<Utrymme, Integer> entry : purchaseMap.entrySet()) {
                // Write each item's info in format: ItemName - Quantity - Timestamp
                String line = String.format("%s - %d - %s",
                        entry.getKey().toString(), // Use Utrymme's toString() for a readable name
                        entry.getValue(),
                        LocalDateTime.now());
                writer.write(line);
                writer.newLine();
            }

            // Optional feedback on successful save
            System.out.println("Purchase history successfully saved!");

            // Clear the current purchase after saving
            purchaseMap.clear();
        } catch (IOException e) {
            System.err.println("Error saving purchase history: " + e.getMessage());
            // Optionally, throw a runtime exception to handle this at a higher level
        }
    }

    // Get the current purchase details as a string for displaying in the GUI
    public String getCurrentPurchaseDetails() {
        if (purchaseMap.isEmpty()) {
            return "No items in the current purchase.";
        }
        StringBuilder details = new StringBuilder("Current Purchase:\n");
        for (Map.Entry<Utrymme, Integer> entry : purchaseMap.entrySet()) {
            details.append(entry.getKey().toString()) // Ensure Utrymme's 'toString()' returns meaningful info
                    .append(" - ")
                    .append(entry.getValue())
                    .append(" pcs\n");
        }
        return details.toString();
    }

    // Utility method to clear the purchase map without saving (optional)
    public void clearCurrentPurchase() {
        purchaseMap.clear();
    }
}