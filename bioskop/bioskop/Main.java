import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Movie movie = new Movie("Avengers Endgame", 180, "Action");

        // buat beberapa kursi
        Seat[] seats = {
                new Seat("A1"),
                new Seat("A2"),
                new Seat("A3"),
                new Seat("B1"),
                new Seat("B2")
        };

        boolean running = true;

        while(running){

            System.out.println("\n=== MENU BIOSKOP ===");
            System.out.println("1. Lihat Film");
            System.out.println("2. Lihat Kursi");
            System.out.println("3. Pesan Tiket");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();

            switch(pilihan){

                case 1:
                    movie.printInfo();
                    break;

                case 2:
                    System.out.println("Daftar Kursi:");
                    for(int i = 0; i < seats.length; i++){
                        System.out.println(
                                seats[i].getNomorKursi() +
                                " - " +
                                (seats[i].isBooked() ? "Terisi" : "Kosong")
                        );
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor kursi: ");
                    String pilihKursi = input.next();

                    boolean ditemukan = false;

                    for(Seat s : seats){
                        if(s.getNomorKursi().equalsIgnoreCase(pilihKursi)){
                            ditemukan = true;

                            if(!s.isBooked()){
                                s.bookSeat();
                                Ticket ticket = new Ticket(movie, s, 50000);
                                ticket.printTicket();
                            } else {
                                System.out.println("Kursi sudah terisi!");
                            }
                        }
                    }

                    if(!ditemukan){
                        System.out.println("Kursi tidak ditemukan!");
                    }

                    break;

                case 4:
                    running = false;
                    System.out.println("Terima kasih.");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }
        }

        input.close();
    }
}
