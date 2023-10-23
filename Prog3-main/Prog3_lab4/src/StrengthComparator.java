import java.util.Comparator;
public class StrengthComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer sor1, Beer sor2) {
        return Double.compare(sor1.getStrength(), sor2.getStrength());
    }
}
