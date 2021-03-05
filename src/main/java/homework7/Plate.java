package homework7;

public class Plate {


    private int food;

    public Plate(int food) {
        if (food > 0) {
            this.food = food;
        } else {
            this.food = 0;
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
    public void putFood(int howPut){
        this.food += howPut;
    }
}

