package nature;

public class FoodRepository {

    private double supply;


    public FoodRepository(double supply) {
        this.supply = supply;
    }

    /**
     * @return true if food was consumed false otherwise
     */
    public boolean consume(double amount) {

        if (supply > amount) {
            supply -= amount;
            return true;
        } else return false;
    }

    public double getState() {
        return supply;
    }
}
