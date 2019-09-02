public class Movie extends NamedObject {
    protected static final int CHILDRENS = 0;
    protected static final int NEW_RELEASE = 1;
    protected static final int REGULAR = 2;

    private int priceCategory;
    Registry registry;

    public Movie(String name, int priceCategory) {
        super(name);
        registry = new Registry();
        this.priceCategory = priceCategory;
    }

    public Movie get(String name) {
        return (Movie)registry.get("Movies", name);
    }

    public int getPriceCategory() {
        return priceCategory;
    }

    public void register() {
        registry.add("Movies", this);
    }
}
