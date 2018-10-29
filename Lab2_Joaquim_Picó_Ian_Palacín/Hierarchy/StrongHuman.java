public class StrongHuman extends Human{

    private String weapon = "Axe";

    public StrongHuman(String name){
        super(name);
        powerLevel = 10;          //Now the human is a strong human, so the power level increase to 10
    }
    public String getWeapon(){
        return weapon;
    }

}
