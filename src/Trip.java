import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Trip {
    private String kotaDestinasi;
    private Integer hargaTrip;
    private Date tanggalKeberangkatan;
    private Integer qty;
    private TripType jenisTrip;

    public String getKotaDestinasi() {
        return kotaDestinasi;
    }
    public Integer getHargaTrip() {
        return hargaTrip;
    }
    public Date getTanggalKeberangkatan() {
        return tanggalKeberangkatan;
    }
    public Integer getQty(){
        return qty;
    }
    public TripType getJenisTrip(){
        return jenisTrip;
    }
    public void setQty(Integer qty){
        this.qty = qty;
    }

    public Trip(String kotaDestinasi, Integer hargaTrip, String tanggalKeberangkatan, TripType jenisTrip, Integer qty){

        SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Date tanggal;
        try {
            tanggal = formatTanggal.parse(tanggalKeberangkatan);
        } catch (Exception e) {
            tanggal = new Date();
        }

        this.kotaDestinasi = kotaDestinasi;
        this.hargaTrip = hargaTrip;
        this.tanggalKeberangkatan = tanggal;
        this.jenisTrip = jenisTrip;
        this.qty = qty;
    }

}
