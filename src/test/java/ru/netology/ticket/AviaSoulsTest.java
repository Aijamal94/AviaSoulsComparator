package ru.netology.ticket;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AviaSoulsTest {

    @Test
    public void shouldSortByPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Нью-Йорк", 1000, 6, 12);
        Ticket ticket2 = new Ticket("Москва", "Нью-Йорк", 1200, 7, 13);
        Ticket ticket3 = new Ticket("Москва", "Нью-Йорк", 800, 8, 14);
        Ticket ticket4 = new Ticket("Москва", "Нью-Йорк", 500, 9, 15);
        Ticket ticket5 = new Ticket("Москва", "Нью-Йорк", 600, 10, 16);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket4, ticket5, ticket3, ticket1, ticket2};
        Ticket[] actual = aviaSouls.search("Москва", "Нью-Йорк");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByFlightDuration() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Нью-Йорк", 1000, 6, 12); // 6 часов
        Ticket ticket2 = new Ticket("Москва", "Нью-Йорк", 1200, 7, 13); // 6 часов
        Ticket ticket3 = new Ticket("Москва", "Нью-Йорк", 800, 8, 14); // 6 часов
        Ticket ticket4 = new Ticket("Москва", "Нью-Йорк", 500, 9, 15); // 6 часов
        Ticket ticket5 = new Ticket("Москва", "Нью-Йорк", 600, 10, 16); // 6 часов

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Нью-Йорк", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket = new Ticket("Москва", "Нью-Йорк", 1000, 6, 12);
        aviaSouls.add(ticket);
        Ticket[] expected = {ticket};
        Ticket[] actual = aviaSouls.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByRoute() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Нью-Йорк", 1000, 6, 12);
        Ticket ticket2 = new Ticket("Москва", "Нью-Йорк", 800, 7, 11);
        Ticket ticket3 = new Ticket("Москва", "Лондон", 1200, 8, 13);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = aviaSouls.search("Москва", "Нью-Йорк");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Нью-Йорк", 1000, 6, 12);
        Ticket ticket2 = new Ticket("Москва", "Нью-Йорк", 800, 7, 11);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        aviaSouls.remove(ticket1);
        Ticket[] expected = {ticket2};
        Ticket[] actual = aviaSouls.findAll();
        assertArrayEquals(expected, actual);
    }
}
