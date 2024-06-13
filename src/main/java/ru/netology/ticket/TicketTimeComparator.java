package ru.netology.ticket;

import java.util.Comparator;



public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        int t1Duration = t1.getTimeTo() - t1.getTimeFrom();
        int t2Duration = t2.getTimeTo() - t2.getTimeFrom();

        if (t1Duration == t2Duration) {
            return Integer.compare(t1.getTimeFrom(), t2.getTimeFrom());
        } else {
            return Integer.compare(t1Duration, t2Duration);
        }
    }
}
