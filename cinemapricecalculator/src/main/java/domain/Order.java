package domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;

    private ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;

        tickets = new ArrayList<MovieTicket>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public Boolean IsDayInWeekend(DayOfWeek dayOfWeek) {
        ArrayList<DayOfWeek> weekendDays = new ArrayList<>();
        weekendDays.add(DayOfWeek.FRIDAY);
        weekendDays.add(DayOfWeek.SATURDAY);
        weekendDays.add(DayOfWeek.SUNDAY);

        return weekendDays.contains(dayOfWeek);
    }


    public double calculatePrice() {
        MovieTicket firstTicket = tickets.get(0);
        MovieScreening firstScreeningOfTicket = firstTicket.getMovieScreening();
        DayOfWeek day = firstScreeningOfTicket.getDateAndTime().getDayOfWeek();
        double totalPriceOfOrder = 0;

        if (!IsDayInWeekend(day) || IsDayInWeekend(day) && isStudentOrder) {
            if (tickets.size() % 2 == 0) {
                for (MovieTicket ticket : tickets) {
                    totalPriceOfOrder += ticket.getPrice();
                }
                return totalPriceOfOrder / 2;
            } else {
                for (MovieTicket ticket : tickets) {
                    totalPriceOfOrder += ticket.getPrice();
                }
                return (totalPriceOfOrder / 2) + (firstTicket.getPrice() / 2);
            }
        } else {
            if (tickets.size() > 6) {
                for (MovieTicket ticket : tickets) {
                    totalPriceOfOrder += ticket.getPrice();
                }
                return totalPriceOfOrder * 0.90;
            } else {
                for (MovieTicket ticket : tickets) {
                    totalPriceOfOrder += ticket.getPrice();
                }
                return totalPriceOfOrder;
            }

        }
    }

    public void export(TicketExportFormat exportFormat) {


        switch (exportFormat) {
            case JSON:
                //something
                ObjectMapper mapper = new ObjectMapper();
                Order order = new Order(orderNr, isStudentOrder);
                try {
                    mapper.writeValue(new File("c:\\order.json"), order);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            case PLAINTEXT:
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("order.txt", "UTF-8");
                } catch (FileNotFoundException | UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                writer.println("orderNr: " + orderNr);
                writer.println("isStudentOrder" + isStudentOrder);
                for (MovieTicket t : tickets) {
                    writer.println("Movie-Time" + t.getMovieScreening().getDateAndTime().toString());
                }
                writer.close();
        }
    }
}
