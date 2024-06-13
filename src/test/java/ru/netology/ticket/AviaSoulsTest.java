package ru.netology.ticket;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import org.junit.jupiter.api.Assertions;


public class AviaSoulsTest {

    @Test
    public void testSearchMultipleTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бишкек", 100, 6, 10);
        Ticket ticket2 = new Ticket("Москва", "Бишкек", 300, 16, 20);
        Ticket ticket3 = new Ticket("Москва", "Бишкек", 200, 18, 22);
        Ticket ticket4 = new Ticket("Москва", "Бишкек", 500, 15, 19);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);

        Ticket[] expected = {ticket1, ticket3, ticket2, ticket4};
        Ticket[] actual = aviaSouls.search("Москва", "Бишкек");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchSingleTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бишкек", 100, 6, 10);

        aviaSouls.add(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = aviaSouls.search("Москва", "Бишкек");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoTickets() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Москва", "Бишкек");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByTime() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бишкек", 100, 6, 10);
        Ticket ticket2 = new Ticket("Москва", "Бишкек", 300, 16, 20);
        Ticket ticket3 = new Ticket("Москва", "Бишкек", 200, 18, 22);
        Ticket ticket4 = new Ticket("Москва", "Бишкек", 500, 15, 19);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket4, ticket2, ticket3}; // Сортировка по времени полета и времени отправления
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Бишкек", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testSearchByRoute() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бишкек", 100, 6, 10);
        Ticket ticket2 = new Ticket("Москва", "Бишкек", 300, 16, 20);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = aviaSouls.search("Москва", "Бишкек");

        Assertions.assertArrayEquals(expected, actual);
    }
}
