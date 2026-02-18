public class Ticket implements Payable {

    private Movie movie;
    private Seat seat;

    public Ticket(Movie movie, Seat seat){
        this.movie = movie;
        this.seat = seat;
    }

    @Override
    public int calculatePrice(){
        return movie.calculatePrice(); // polymorphism terjadi di sini
    }

    public void printTicket(){
        System.out.println("\n===== TIKET =====");
        System.out.println("Film  : " + movie.getTitle());
        System.out.println("Kursi : " + seat.getNomorKursi());
        System.out.println("Harga : Rp " + calculatePrice());
        System.out.println("=================");
    }
}
