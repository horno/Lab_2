import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

    @Override
    public int compare(Human h1,Human h2){
        return (Integer.toString(h1.powerLevel)).compareTo(Integer.toString(h2.powerLevel));
    }
}
