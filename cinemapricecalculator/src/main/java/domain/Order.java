package domain;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Order
{
    private int orderNr;
    private boolean isStudentOrder;

    private ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder)
    {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;

        tickets = new ArrayList<MovieTicket>();
    }

    public int getOrderNr()
    {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket)
    {
        tickets.add(ticket);
    }

    public Boolean IsDayInWeekend(DayOfWeek dayOfWeek)
    {
        ArrayList<DayOfWeek> weekendDays = new ArrayList<>();
        weekendDays.add(DayOfWeek.FRIDAY);
        weekendDays.add(DayOfWeek.SATURDAY);
        weekendDays.add(DayOfWeek.SUNDAY);

        return weekendDays.contains(dayOfWeek);
    }


    public double calculatePrice()
    {
        MovieTicket firstTicket = tickets.get(0);
        MovieScreening firstScreeningOfTicket = firstTicket.getMovieScreening();
        DayOfWeek day = firstScreeningOfTicket.getDateAndTime().getDayOfWeek();

        if (!IsDayInWeekend(day) || IsDayInWeekend(day) && isStudentOrder ){
            if (tickets.size() % 2 == 0){
                for (MovieTicket ticket : tickets){
                    double totalPriceOfOrder =+ ticket.getPrice();
                    return totalPriceOfOrder / 2;
                }
            } else {
                for (MovieTicket ticket : tickets){
                    double totalPriceOfOrder =+ ticket.getPrice();
                    return (totalPriceOfOrder / 2) + firstTicket.getPrice();
                }
            }
        }

             else {
                if (tickets.size() > 6) {
                    for (MovieTicket ticket : tickets) {
                        double totalPriceOfOrder = +ticket.getPrice();
                        return totalPriceOfOrder * 0.90;
                    }
                } else {
                    for (MovieTicket ticket : tickets) {
                        double totalPriceOfOrder = +ticket.getPrice();
                        return totalPriceOfOrder;
                    }
                }

            }

        return 0;
    }

    public void export(TicketExportFormat exportFormat)
    {
        // Bases on the string respresentations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json
    }
}
