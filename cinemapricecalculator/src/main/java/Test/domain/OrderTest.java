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
public void testCalculatePriceOdd() throws Exception {
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

    Assert.assertEquals(9, price, 1);
}

@Test
public void testCalculatePriceEven() throws Exception {
    Movie avatar = new Movie("avatar");
    LocalDateTime date = LocalDateTime.of(2019, 1, 29, 8, 23);
    MovieScreening show = new MovieScreening(avatar, date, 6);
    MovieTicket ticket1 = new MovieTicket(show, false, 10, 8);
    MovieTicket ticket2 = new MovieTicket(show, false, 10, 9);
    Order order = new Order(100, true);
    order.addSeatReservation(ticket1);
    order.addSeatReservation(ticket2);

    double price = order.calculatePrice();

    Assert.assertEquals(3, price, 1);
}

} 
