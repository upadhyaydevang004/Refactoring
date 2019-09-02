import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Customer extends NamedObject {
    private Vector<Rental> rentals = new Vector<Rental>();
    private Registry registry;
    private double balance = 0.0;
    private int rewardPoints = 0;
    private HashMap<String, Double> movieRentMap;

    public Customer(String name) {
        super(name);
        registry = new Registry();
    }

    public Vector<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Vector<Rental> rentals) {
        this.rentals = rentals;
    }

    public Customer get(String name) {
        return (Customer)registry.get("Customers", name);
    }

    public void register() {
        registry.add("Customers", this);
    }

    public void addRental(Rental rental) {
        getRentals().add(rental);
    }

    public String getStatement() {
        calculateCustomerRentDetails();
        StringBuilder sb = new StringBuilder();
        sb.append("Rental statement for ").append(name).append("\n");
        for (Map.Entry<String, Double> rentDetails: movieRentMap.entrySet()) {
            sb.append(rentDetails.getKey()).append("\t").append(rentDetails.getValue()).append("\n");
        }
        sb.append("Balance is ").append(balance).append("\n");
        sb.append("You earned ").append(rewardPoints).append(" reward points");
        return sb.toString();
    }

    public String getHTMLEncodedStatement() {
        calculateCustomerRentDetails();
        StringBuilder sb = new StringBuilder();
        sb.append("<HTML><BODY>");
        sb.append("Rental statement for ").append(name).append("<br>");
        for (Map.Entry<String, Double> rentDetails: movieRentMap.entrySet()) {
            sb.append(rentDetails.getKey()).append("<pre>").append(rentDetails.getValue()).append("</pre><br>");
        }
        sb.append("Balance is ").append(balance).append("<br>");
        sb.append("You earned ").append(rewardPoints).append(" reward points");
        sb.append("</BODY></HTML>");
        return sb.toString();
    }
    
    private void calculateCustomerRentDetails(){
        balance = 0.0;
        rewardPoints = 0;
        movieRentMap = new HashMap<>();
        for (Rental rental : getRentals()) {
            if (rental.getDvd() != null) {
                double rentalAmount = rental.getDvd().calculateRentalAmount(rental);
                balance += rentalAmount;
                rewardPoints += rental.getDvd().calculateRewardPoints(rental);
                movieRentMap.put(rental.getDvd().getMovie().name, rentalAmount);
            } else if (rental.getBluRay() != null){
                double rentalAmount = rental.getBluRay() .calculateRentalAmount(rental);
                balance += rentalAmount;
                rewardPoints += rental.getBluRay() .calculateRewardPoints(rental);
                movieRentMap.put(rental.getBluRay() .getMovie().name, rentalAmount);
            }
        }
    }
}
