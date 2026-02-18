import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Movie[] movies = {
                new RegularMovie("Interstellar", 169, "Sci-Fi"),
                new PremiumMovie("Avengers Endgame", 180, "Action"),
                new RegularMovie("Parasite", 132, "Thriller"),
                new PremiumMovie("Titanic", 195, "Romance")
        };

        boolean running = true;

        while(running){

            System.out.println("\n=== MENU BIOSKOP ===");
            System.out.println("1. Lihat Film");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();

            switch(pilihan){

                case 1:
                    for(int i = 0; i < movies.length; i++){
                        System.out.println((i+1) + ". ");
                        movies[i].printInfo();
                    }
                    break;

                case 2:

                    for(int i = 0; i < movies.length; i++){
                        System.out.println((i+1) + ". " + movies[i].getTitle());
                    }

                    System.out.print("Pilih film: ");
                    int pilihFilm = input.nextInt();

                    if(pilihFilm < 1 || pilihFilm > movies.length){
                        System.out.println("Film tidak valid!");
                        break;
                    }

                    Movie selectedMovie = movies[pilihFilm - 1];

                    for(Seat s : selectedMovie.getSeats()){
                        System.out.println(
                                s.getNomorKursi() + " - " +
                                (s.isBooked() ? "Terisi" : "Kosong")
                        );
                    }

                    System.out.print("Pilih kursi: ");
                    String pilihKursi = input.next();

                    for(Seat s : selectedMovie.getSeats()){
                        if(s.getNomorKursi().equalsIgnoreCase(pilihKursi)){
                            if(!s.isBooked()){
                                s.bookSeat();
                                Ticket ticket = new Ticket(selectedMovie, s);
                                ticket.printTicket();
                            } else {
                                System.out.println("Kursi sudah terisi!");
                            }
                        }
                    }

                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }
        }

        input.close();
    }
}
