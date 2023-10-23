import java.util.Comparator;

public class StyleComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer sor1, Beer sor2){
        return sor1.getStyle().compareTo(sor2.getStyle());
    }
}
