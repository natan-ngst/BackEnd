public abstract class Movie {

    private String title;
    private int duration;
    private String genre;
    protected Seat[] seats;

    public Movie(String title, int duration, String genre){
        this.title = title;
        this.duration = duration;
        this.genre = genre;

        this.seats = new Seat[]{
                new Seat("A1"),
                new Seat("A2"),
                new Seat("A3"),
                new Seat("B1"),
                new Seat("B2")
        };
    }

    public String getTitle(){
        return title;
    }

    public Seat[] getSeats(){
        return seats;
    }

    public void printInfo(){
        System.out.println("Judul  : " + title);
        System.out.println("Durasi : " + duration + " menit");
        System.out.println("Genre  : " + genre);
        System.out.println("Tipe   : " + getClass().getSimpleName());
        System.out.println("----------------------------");
    }

    // Abstraction
    public abstract int calculatePrice();
}
