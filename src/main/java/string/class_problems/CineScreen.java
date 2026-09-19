package string.class_problems;

public class CineScreen {

    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {

        if (seatsTotal <= 0) {
            throw new IllegalArgumentException("Invalid seat count");
        }

        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {

        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {

        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static void main(String[] args) {

        CineScreen screen = new CineScreen(2);

        screen.bookSeat();
        screen.bookSeat();
        screen.bookSeat();

        System.out.println(
                "After bookings: " + screen.getSeatsAvailable()
        );

        screen.cancelBooking();
        screen.cancelBooking();
        screen.cancelBooking();

        System.out.println(
                "After cancellations: " + screen.getSeatsAvailable()
        );

        try {
            new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Construction rejected");
        }
    }
}