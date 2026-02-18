public class RegularMovie extends Movie {

    public RegularMovie(String title, int duration, String genre){
        super(title, duration, genre);
    }

    @Override
    public int calculatePrice(){
        return 50000;
    }
}
