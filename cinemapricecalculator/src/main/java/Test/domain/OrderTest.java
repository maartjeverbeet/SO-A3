package Test.domain;

import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDateTime;


public class OrderTest {

@Test
public void testCalculatePriceOddWeekStudents() throws Exception {
    Movie avatar = new Movie("avatar");
    LocalDateTime date = LocalDateTime.of(2019, 1, 29, 8, 23);
    MovieScreening show = new MovieScreening(avatar, date, 6);
    MovieTicket ticket1 = new MovieTicket(show, false, 10, 8);
    MovieTicket ticket2 = new MovieTicket(show, false, 10, 9);
    MovieTicket ticket3 = new MovieTicket(show, false, 10, 10);
    Order order = new Order(100, true);
    order.addSeatReservation(ticket1);
    order.addSeatReservation(ticket2);
    order.addSeatReservation(ticket3);

    double price = order.calculatePrice();

    Assert.assertEquals(12, price, 1);
}

@Test
public void testCalculatePriceEvenWeekStudents() throws Exception {
    Movie stepUp = new Movie("StepUp");
    LocalDateTime date = LocalDateTime.of(2019, 1, 28, 8, 23);
    MovieScreening show = new MovieScreening(stepUp, date, 6);
    MovieTicket ticket1 = new MovieTicket(show, true, 10, 8);
    MovieTicket ticket2 = new MovieTicket(show, false, 10, 9);
    Order order = new Order(100, true);
    order.addSeatReservation(ticket1);
    order.addSeatReservation(ticket2);

    double price = order.calculatePrice();

    Assert.assertEquals(6, price, 1);
}

@Test
public void testCalculatePriceMoreThenSixWeekend() throws Exception {
    Movie junglebook = new Movie("Junglebook");
    LocalDateTime date = LocalDateTime.of(2019, 2, 2, 5, 22);
    MovieScreening show = new MovieScreening(junglebook, date, 6);
    MovieTicket ticket1 = new MovieTicket(show, false, 10, 1);
    MovieTicket ticket2 = new MovieTicket(show, false, 10, 2);
    MovieTicket ticket3 = new MovieTicket(show, false, 10, 3);
    MovieTicket ticket4 = new MovieTicket(show, false, 10, 4);
    MovieTicket ticket5 = new MovieTicket(show, false, 10, 5);
    MovieTicket ticket6 = new MovieTicket(show, false, 10, 6);
    MovieTicket ticket7 = new MovieTicket(show, false, 10, 7);
    Order order = new Order(101, false);
    order.addSeatReservation(ticket1);
    order.addSeatReservation(ticket2);
    order.addSeatReservation(ticket3);
    order.addSeatReservation(ticket4);
    order.addSeatReservation(ticket5);
    order.addSeatReservation(ticket6);
    order.addSeatReservation(ticket7);

    double price = order.calculatePrice();

    Assert.assertEquals(37.8, price, 1);
}

    @Test
    public void testCalculatePriceMoreLessThenSixWeekend() throws Exception {
        Movie lionKing = new Movie("LionKing");
        LocalDateTime date = LocalDateTime.of(2019, 2, 2, 5, 22);
        MovieScreening show = new MovieScreening(lionKing, date, 6);
        MovieTicket ticket1 = new MovieTicket(show, false, 10, 1);
        MovieTicket ticket2 = new MovieTicket(show, false, 10, 2);
        Order order = new Order(101, false);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        double price = order.calculatePrice();

        Assert.assertEquals(12, price, 1);
    }

    @Test
    public void testCalculatePriceOddWeekNormal() throws Exception {
        Movie avatar = new Movie("avatar");
        LocalDateTime date = LocalDateTime.of(2019, 1, 29, 8, 23);
        MovieScreening show = new MovieScreening(avatar, date, 6);
        MovieTicket ticket1 = new MovieTicket(show, false, 10, 8);
        MovieTicket ticket2 = new MovieTicket(show, false, 10, 9);
        MovieTicket ticket3 = new MovieTicket(show, false, 10, 10);
        Order order = new Order(100, false);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);

        double price = order.calculatePrice();

        Assert.assertEquals(12, price, 1);
    }

    @Test
    public void testCalculatePriceEvenWeekNormal() throws Exception {
        Movie stepUp = new Movie("StepUp");
        LocalDateTime date = LocalDateTime.of(2019, 1, 28, 8, 23);
        MovieScreening show = new MovieScreening(stepUp, date, 6);
        MovieTicket ticket1 = new MovieTicket(show, true, 10, 8);
        MovieTicket ticket2 = new MovieTicket(show, false, 10, 9);
        Order order = new Order(100, false);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        double price = order.calculatePrice();

        Assert.assertEquals(6, price, 1);
    }

    @Test
    public void testCalculatePriceOddWeekendStudents() throws Exception {
        Movie avatar = new Movie("avatar");
        LocalDateTime date = LocalDateTime.of(2019, 2, 2, 8, 23);
        MovieScreening show = new MovieScreening(avatar, date, 6);
        MovieTicket ticket1 = new MovieTicket(show, false, 10, 8);
        MovieTicket ticket2 = new MovieTicket(show, false, 10, 9);
        MovieTicket ticket3 = new MovieTicket(show, false, 10, 10);
        Order order = new Order(100, true);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);

        double price = order.calculatePrice();

        Assert.assertEquals(12, price, 1);
    }

    @Test
    public void testCalculatePriceEvenWeekendStudents() throws Exception {
        Movie stepUp = new Movie("StepUp");
        LocalDateTime date = LocalDateTime.of(2019, 2, 2, 8, 23);
        MovieScreening show = new MovieScreening(stepUp, date, 6);
        MovieTicket ticket1 = new MovieTicket(show, true, 10, 8);
        MovieTicket ticket2 = new MovieTicket(show, false, 10, 9);
        Order order = new Order(100, true);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        double price = order.calculatePrice();

        Assert.assertEquals(6, price, 1);
    }


} 
