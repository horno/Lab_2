public class Human implements Comparable<Human>{
    public String name;
    protected int powerLevel;

    public Human(String name){
        this.name = name;
        this.powerLevel = 5;        //Humans have a basic powerLevel of 5
    }

    @Override
    public int compareTo(Human h) {
        return (Integer.toString(this.powerLevel)).compareTo(Integer.toString(h.powerLevel));
    }
    @Override
    public String toString(){
        return name+" power level " + powerLevel;
    }
    @Override
    public boolean equals(Object obj){
        return this.powerLevel == ((Human) obj).powerLevel;
    }

}
