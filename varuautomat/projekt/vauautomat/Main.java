package vauautomat;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Utrymme utrymmet = new Utrymme();
        historikHanterarer historik = new historikHanterarer();
        new gui(utrymmet, historik);
    }

}
