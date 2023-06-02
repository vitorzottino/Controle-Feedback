package br.com.fiap.lists;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.com.fiap.model.Feedback;

public class ListFb {

    public DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:ms");

    private class Node {
        Feedback fb;
        Node next;
    }

    private Node head, end;
    private String dataNovo, dataHead;

    public boolean isEmpty() {
        if (head == null && end == null)
            return true;

        else
            return false;

    }

    public void add(Feedback fb) {
        Node n = new Node();
        n.fb = fb;

        if (head == null) {
            n.next = null;
            head = n;
        }

        else {
            dataNovo = dateFormat.format(n.fb.getDataEntrada());
            dataHead = dateFormat.format(head.fb.getDataEntrada());
            System.out.println(dataHead);
            if (dataNovo.compareTo(dataHead) < 0) {
                n = head;
                head = n.next;
            } else {
                Node aux = head;
                
                
                boolean found = false;
                while (aux.next != null && !found) {
                    if (aux.next.fb.getDataEntrada().compareTo(n.fb.getDataEntrada()) < 0) {
                        aux = aux.next;

                    } else
                        found = true;

                }
                n.next = aux.next;
                aux.next = n;

            }

        }
    }

    public void show() {
        Node aux = head;
        while (aux != null) {
            System.out.println(aux.fb.toString());
            aux = aux.next;
        }
    }
}
