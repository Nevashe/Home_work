package homework7;

import java.util.Random;

public class Cat {

    private String name;

    private boolean isSatiety;
    Random random = new Random();

    public Cat() {

    }

    public void eat(Plate plate){

        int levelHungry = random.nextInt(6);
        boolean enoughFood = plate.getFood() > 15 + levelHungry;
        if (!isSatiety) {
            if (enoughFood) {
                plate.setFood(plate.getFood() - 15 - levelHungry);
                isSatiety = true;
            } else {
                System.out.println("В миске мало еды");
            }
        } else{
            System.out.println("Кот не голоден");
        }

    }
    public void checkSatiety(){
        if (isSatiety) {
            System.out.println("Кот сытый");
        }else{
            System.out.println("Кот голоден");
        }
    }
    public boolean getIsSatiety() {
        return isSatiety;
    }
}
