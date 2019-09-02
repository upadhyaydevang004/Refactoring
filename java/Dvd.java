public class Dvd extends NamedObject implements RentalCalulation{
    private String serialNo;
    private Movie movie;

    public Dvd(String serialNo, Movie movie) {
        super(serialNo);
        this.setSerialNo(serialNo);
        this.setMovie(movie);
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public double calculateRentalAmount(Rental rental) {
        double amount = 0.0;
        switch (getMovie().getPriceCategory()) {
            case Movie.CHILDRENS:
                amount += 2;
                if (rental.getDays() > 2) {
                    amount += (rental.getDays() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                amount += rental.getDays() * 3;
                break;
            case Movie.REGULAR:
                amount += 1.5;
                if (rental.getDays() > 3) {
                    amount += (rental.getDays() - 3) * 1.5;
                }
                break;
        }
        return amount;
    }

    @Override
    public double calculateRewardPoints(Rental rental) {
        double rewardPoints = 0.0;
        rewardPoints += 1;
        if ((rental.getDvd().getMovie().getPriceCategory() == Movie.NEW_RELEASE) && rental.getDays() > 1) {
            rewardPoints += 1;
        }
        return rewardPoints;
    }

}
