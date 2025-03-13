package vauautomat;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Utrymme utrymmet = new Utrymme();
        Utrymme historik = new Utrymme();
        new gui(utrymmet, historik);
    }

}
