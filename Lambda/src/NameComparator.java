import java.util.Comparator;

public class NameComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer sor1, Beer sor2){
        return sor1.getName().toLowerCase().compareTo(sor2.getName().toLowerCase());
    }
}
