package app;

import java.util.Scanner;

import lists.ListFb;
import model.Feedback;

public class TesteLista {
    public static void main(String[] args) {

        for (int i = 0; i < 50000; i++) {
            if ((i == 1) || (i == 49999)) {
                ListFb lista = new ListFb();
                Feedback teste = new Feedback();
                lista.add(teste);
                lista.show();
            }
        }

    }
}
