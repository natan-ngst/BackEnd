public class Ticket {

    private Movie movie;
    private Seat seat;
    private double harga;

    public Ticket(Movie movie, Seat seat, double harga){
        this.movie = movie;
        this.seat = seat;
        this.harga = harga;
    }

    public void printTicket(){
        System.out.println("=== TIKET BIOSKOP ===");
        System.out.println("Film : " + movie.getJudul());
        System.out.println("Kursi: " + seat.getNomorKursi());
        System.out.println("Harga: Rp " + harga);
    }
}
