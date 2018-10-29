import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class TaskTest {

    private ArrayList<Human> humanExpectedList;
    private ArrayList<Human> humanListToTest;
    private ArrayList integerExpectedList;
    private ArrayList integerListToTest;
    private List result;
    private final int min = 4;
    private final int max = 80;
    private int testIndicator = 1;

    @Before
    public void initLists(){
            integerListToTest = new ArrayList();
            integerExpectedList = new ArrayList();
            humanListToTest = new ArrayList();
            humanExpectedList =new ArrayList();
            result = new ArrayList();
    }

    @After
    public void printResults(){
        if(testIndicator==1){
            print(integerListToTest,integerExpectedList,result);
        }else{
            print(humanListToTest,humanExpectedList,result);
        }
    }

    //Task 1 tests
    @Test
    public void withinRangeRandomIntegers() {
        testIndicator = 1;
        fillLists();
        result = Task.withinRange(integerListToTest,min,max);
        assertEquals(integerExpectedList,result);
    }
    @Test
    public void withinRangeEmpty(){
        testIndicator = 1;
        result = Task.withinRange(integerListToTest,min,max);
        assertEquals(integerExpectedList,result);
    }
    @Test
    public void withinRangeWithNull(){
        testIndicator = 1;
        fillLists();
        integerListToTest.add(null);
        result = Task.withinRange(integerListToTest,min,max);
        assertEquals(integerExpectedList,result);

    }
    //Task 2 tests
    @Test
    public void withinRangeComparableFilledList(){
        testIndicator = 2;
        fillLists();
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximilian");                  //Just to compare
        result = Task.withinRange(humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void withinRangeComparableEmptyList() {
        testIndicator = 2;
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximilian");                  //Just to compare
        result = Task.withinRange(humanListToTest,min,max);
        assertEquals(humanExpectedList,result);

    }
    @Test
    public void withinRangeComparableWithNull(){
        testIndicator = 2;
        fillLists();
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximilian");                  //Just to compare
        humanListToTest.add(null);
        result = Task.withinRange(humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void withinRangeComparator(){
        testIndicator = 2;
        fillLists();
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximilian");                  //Just to compare
        HumanComparator comp = new HumanComparator();
        result = Task.withinRange(comp,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void withinRangeComparatorEmptyList(){
        testIndicator = 2;
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximilian");                  //Just to compare
        HumanComparator comp = new HumanComparator();
        result = Task.withinRange(comp,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void withinRangeComparatorWithNull(){
        testIndicator = 2;
        fillLists();
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximilian");                  //Just to compare
        humanListToTest.add(null);
        HumanComparator comp = new HumanComparator();
        result = Task.withinRange(comp,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    //Task 3 tests
    @Test
    public void copyWithRangeComparable(){
        testIndicator = 3;
        fillLists();
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximiliano");                  //Just to compare
        Task.copyWithRange(result,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void copyWithRangeComparableEmptyList(){
        testIndicator = 3;
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximiliano");                  //Just to compare
        Task.copyWithRange(result,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void copyWithRangeComparableWithNul(){
        testIndicator = 3;
        fillLists();
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximiliano");                  //Just to compare
        humanListToTest.add(null);
        Task.copyWithRange(result,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void copyWithRangeComparator(){
        testIndicator = 3;
        fillLists();
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximiliano");                  //Just to compare
        HumanComparator comp = new HumanComparator();
        Task.copyWithRange(comp,result,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void copyWithRangeComparatorEmptyList(){
        testIndicator = 3;
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximiliano");                  //Just to compare
        HumanComparator comp = new HumanComparator();
        Task.copyWithRange(comp,result,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }
    @Test
    public void copyWithRangeComparatorWithNull(){
        testIndicator = 3;
        fillLists();
        StrongHuman min = new StrongHuman("Minerva");       //Just to compare
        Mage max = new Mage("Maximiliano");                  //Just to compare
        HumanComparator comp = new HumanComparator();
        humanListToTest.add(null);
        Task.copyWithRange(comp,result,humanListToTest,min,max);
        assertEquals(humanExpectedList,result);
    }

    // Auxiliary functions

    private void fillLists(){
        if(testIndicator==1) {
            Random rng = new Random();
            int random;
            for(int i=0;i<100;i++) {
                random = rng.nextInt(100);
                integerListToTest.add(random);
                if (min <= random && random < max) {
                    integerExpectedList.add(random);
                }
            }
        }else if(testIndicator==2){
            fillListsHierarchy();
        }else{
            MagicHuman sh = new MagicHuman("Spok");
            result.add(sh);
            humanExpectedList.add(sh);
            fillListsHierarchy();
        }
    }

    private void fillListsHierarchy(){
        StrongHuman sh1 = new StrongHuman("Aragorn");
        StrongHuman sh2 = new StrongHuman("Ragnar Lodbrok");
        MagicHuman mh1 = new MagicHuman("Harry Potter");
        Warrior w1 = new Warrior("Leonidas");
        Warrior w2 = new Warrior("The Mountain");
        Mage m1 = new Mage("Gandalf");
        Human h1 = new Human("Carmen de Mairena");

        humanListToTest.add(sh1);
        humanListToTest.add(sh2);
        humanListToTest.add(mh1);
        humanListToTest.add(w1);
        humanListToTest.add(w2);
        humanListToTest.add(m1);
        humanListToTest.add(h1);

        humanExpectedList.add(sh1);
        humanExpectedList.add(sh2);
        humanExpectedList.add(mh1);
        humanExpectedList.add(w1);
        humanExpectedList.add(w2);
    }

    private void print(ArrayList listToTest, ArrayList expected, List result){
        System.out.println("-- Filled list --\n"+listToTest.toString());
        System.out.println("-- Expected list --\n"+expected.toString());
        System.out.println("-- Result list --\n"+result.toString());
    }
}
