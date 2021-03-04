package homework6;

public abstract class Animal {
public int ranLength;
public int swimLength;
    protected int howCheck;

    public Animal(){
        this.setHowCheck(howCheck++);
    }
    abstract public void run(int ranLength);
    abstract public void swim(int swimLength);
    public int getHowCheck() {
        return howCheck;
    }
    void setHowCheck(int howCheck) {
        this.howCheck = howCheck;
    }
    public  void checkInfo(){
        System.out.println("Было создано " + howCheck + " животных");
    }
}
