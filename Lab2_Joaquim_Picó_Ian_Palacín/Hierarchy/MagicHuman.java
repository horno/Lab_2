public class MagicHuman  extends Human{

    private String weapon = "Wand";

    public MagicHuman(String name){
        super(name);
        powerLevel = 15;            //Now the human is a magic human, so the power level increases to 15
    }
    public String getWeapon(){
        return weapon;
    }

}
