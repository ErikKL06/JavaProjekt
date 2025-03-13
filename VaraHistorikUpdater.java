// Attach an ActionListener to each button in your buttons ArrayList
for (JButton button : buttons) {
    button.addActionListener(e -> {
        // Identify the associated variable (vara) from the button
        int index = buttons.indexOf(button); // Assuming button's index matches vara's index
        Vara clickedVara = utrymmet.getVara(index); // Get the vara from your Utrymme object

        // Check if the vara is already in the historik list
        boolean found = false;
        for (Vara v : historik.getVaror()) { // Assuming historik has a method getVaror() returning the list
            if (v.equals(clickedVara)) { // Assuming proper equals method in Vara
                v.ökaAntal(); // Increment existing vara's antal
                found = true;
                break;
            }
        }

        // If not found, add this vara to historik
        if (!found) {
            Vara newVara = new Vara(clickedVara.getNamn(), clickedVara.getPris()); // Copy vara details
            newVara.ökaAntal(); // Start with antal = 1
            historik.addVara(newVara); // Assuming a method addVara() to add to historik
        }

        // Update the GUI to reflect the changes
        uppdateraGui();
    });
}