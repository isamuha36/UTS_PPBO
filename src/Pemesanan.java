import java.util.UUID;

public class Pemesanan {
    String idBooking;
    Customer dataCustomer;
    Trip tripYangDipesan;
    static Integer number = 0;
    public Pemesanan(Customer customer, Trip trip){
        number += 1;
        this.dataCustomer = customer;
        this.tripYangDipesan = trip;
        this.idBooking = "00" + trip.getKotaDestinasi() + "00" + trip.getJenisTrip() + number;
    }
}
