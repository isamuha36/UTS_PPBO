import java.text.SimpleDateFormat;
import java.util.*;

public class TravelAgent {
    ArrayList<Trip> daftarTrip = new ArrayList<Trip>();
    ArrayList<Pemesanan> daftarPesanan = new ArrayList<Pemesanan>();
    public void addTrip(Trip trip) {
        daftarTrip.add(trip);
    }

    public void showAvailableTrip(){
        Integer n = 0;
        for (Trip trip : daftarTrip){
            if (trip.getQty() > 0){
                n += 1;
            }
        }
        System.out.println("Terdapat " + n + " trip yang masih tersedia:");
        for (Trip trip : daftarTrip){
            if (trip.getQty() > 0){
                System.out.println("Destination: " + trip.getKotaDestinasi() + " -- Keberangkatan : " + trip.getTanggalKeberangkatan() + " -- Harga : " + trip.getHargaTrip() + " -- Qty : " + trip.getQty() + " -- Jenis : " + trip.getJenisTrip());
            }
        }
    }

    public void bookTrip(Customer nama, Trip tujuan){
        Boolean cek = false;
        for (Pemesanan daftar : daftarPesanan){
            if(daftar.dataCustomer == nama && daftar.tripYangDipesan == tujuan){
                System.out.println("Pemesanan gagal, pengguna telah memiliki pesanan pada trip yang sama dengan id "+ daftar.idBooking);
                cek = true;
            }
        }
        if (!cek) {
            if (tujuan.getQty() == 0){
                System.out.println("Pemesanan gagal, perjalanan ke " + tujuan.getKotaDestinasi() + " Habis terjual.");
            } else {
                Pemesanan newPesanan = new Pemesanan(nama, tujuan);
                System.out.println("Pemesanan berhasil dilakukan dengan booking id "+ newPesanan.idBooking);
                daftarPesanan.add(newPesanan);
                tujuan.setQty(tujuan.getQty() - 1);
            }
        }
    }

    public void cancelBooking(String email, Trip trip){
        Boolean cek = false;
        for (Pemesanan pesanan : daftarPesanan){
            if(pesanan.dataCustomer.getEmail() == email && pesanan.tripYangDipesan == trip){
                pesanan.tripYangDipesan.setQty(trip.getQty() + 1);
                daftarPesanan.remove(pesanan);
                cek = true;
                System.out.println("Pesanan dengan id booking "+ pesanan.idBooking + " berhasil dibatalkan");
                break;
            }
        }
        if (!cek){
            System.out.println("Pesanan tidak ditemukan");
        }
    }

    public void getBookingsByCustomerEmail(String email){
        Boolean cek = false;
        for (Pemesanan pesanan : daftarPesanan){
            if (pesanan.dataCustomer.getEmail() == email){
                cek = true;
                System.out.println("Pesanan dengan email " + pesanan.dataCustomer.getEmail());
                System.out.println("Booking ID: " + pesanan.idBooking + ", Destinasi: "+pesanan.tripYangDipesan.getKotaDestinasi());
                break;
            }
        }
        if (!cek){
            System.out.println("Tidak ditemukan pesanan untuk email " + email);
        }
    }

    public void getAvailableTripsByType(TripType tipe){
        Integer n = 0;
        Boolean cek = false;
        for (Trip trip : daftarTrip){
            if (trip.getJenisTrip() == tipe){
                n += 1;
                cek = true;
            }
        }
        if (cek){
            System.out.println("Ditemukan " + n + " trip untuk jenis " + tipe);
            for (Trip trip : daftarTrip){
                if (trip.getJenisTrip() == tipe){
                    System.out.println("Destination: " + trip.getKotaDestinasi() + " -- Keberangkatan : " + trip.getTanggalKeberangkatan() + " -- Harga : " + trip.getHargaTrip() + " -- Qty : " + trip.getQty() + " -- Jenis : " + trip.getJenisTrip());
                }
            }
        } else {
            System.out.println("Tidak ditemukan trip untuk jenis " + tipe);
        }
    }

    public void showAvailableTripsByDate(String tanggal){
        SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date newTanggal;
        try {
            newTanggal = formatTanggal.parse(tanggal);
        } catch (Exception e){
            newTanggal = new Date();
        }
        Integer n = 0;
        Boolean cek = false;
        for (Trip trip : daftarTrip){
            if (trip.getTanggalKeberangkatan().equals(newTanggal)){
                n += 1;
                cek = true;
            }
        }
        if (cek) {
            System.out.println("Ditemukan " + n + " trip untuk keberangkatan pada ");
            for (Trip trip : daftarTrip){
                if (trip.getTanggalKeberangkatan().equals(newTanggal)){
                    System.out.println("Destination: " + trip.getKotaDestinasi() + " -- Keberangkatan : " + trip.getTanggalKeberangkatan() + " -- Harga : " + trip.getHargaTrip() + " -- Qty : " + trip.getQty() + " -- Jenis : " + trip.getJenisTrip());
                }
            }
        } else {
            System.out.println("Tidak ditemukan data trip dengan jadwal keberangkatan pada " + tanggal);
        }
    }
}
