public class Seat {

    private String nomorKursi;
    private boolean booked;

    public Seat(String nomorKursi){
        this.nomorKursi = nomorKursi;
        this.booked = false;
    }

    public String getNomorKursi(){
        return nomorKursi;
    }

    public boolean isBooked(){
        return booked;
    }

    public void bookSeat(){
        booked = true;
    }
}
