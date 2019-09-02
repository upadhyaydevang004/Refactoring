public class BluRay extends NamedObject implements RentalCalulation{
    private String serialNo;
    private Movie movie;

    public BluRay(String serialNo, Movie movie) {
        super(serialNo);
        this.serialNo = serialNo;
        this.setMovie(movie);
    }

    @Override
    public double calculateRentalAmount(Rental rental) {
        double amount = 0.0;
        switch (getMovie().getPriceCategory()) {
            case Movie.CHILDRENS:
                amount += 4;
                if (rental.getDays() > 3) {
                    amount += (rental.getDays() - 3) * 2;
                }
                break;
            case Movie.NEW_RELEASE:
                amount += rental.getDays() * 2.5;
                break;
            case Movie.REGULAR:
                amount += 1;
                if (rental.getDays() > 10) {
                    amount += (rental.getDays() - 10) * 2;
                }
                break;
        }
        return amount;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public double calculateRewardPoints(Rental rental) {
        double rewardPoints = 0.0;
        rewardPoints += 2.5;
        if ((getMovie().getPriceCategory() == Movie.NEW_RELEASE) && rental.getDays() > 1) {
            rewardPoints += 1;
        }
        if ((getMovie().getPriceCategory() == Movie.CHILDRENS) && rental.getDays() > 5) {
            rewardPoints += 2;
        }
        if ((getMovie().getPriceCategory() == Movie.REGULAR) && rental.getDays() > 10) {
            rewardPoints += 2;
        }
        return rewardPoints;
    }

}
