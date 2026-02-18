public class PremiumMovie extends Movie {

    public PremiumMovie(String title, int duration, String genre){
        super(title, duration, genre);
    }

    @Override
    public int calculatePrice(){
        return 80000;
    }
}
