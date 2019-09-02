public class Rental extends NamedObject {
    private Dvd dvd;
    private BluRay bluRay;
    private int days;

    public Rental(Dvd dvd, int days) {
        super(dvd.name);
        this.setDvd(dvd);
        this.setDays(days);
    }

    public Rental(BluRay bluRay, int days) {
        super(bluRay.name);
        this.setBluRay(bluRay);
        this.setDays(days);
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public BluRay getBluRay() {
        return bluRay;
    }

    public void setBluRay(BluRay bluRay) {
        this.bluRay = bluRay;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
