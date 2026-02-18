public class Movie {

    private String judul;
    private int durasi;
    private String genre;

    public Movie(String judul, int durasi, String genre){
        this.judul = judul;
        this.durasi = durasi;
        this.genre = genre;
    }

    public void printInfo(){
        System.out.println("Judul: " + judul);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("Genre: " + genre);
    }

    public String getJudul() {
        return judul;
    }
}
