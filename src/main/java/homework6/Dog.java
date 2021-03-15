package homework6;

public class Dog extends Animal {

    private int howCheckDog;

    public Dog() {
        super.setHowCheck(howCheck++);
        setHowCheckDog(howCheckDog++);
    }

    @Override
    public void run(int ranLength) {
        this.ranLength = ranLength;
        if (ranLength < 0) {
            System.out.println("Собаки бегут только вперед!");
        } else if (ranLength <= 500) {
            System.out.println("Пес пробежал " + ranLength + " метров");
        } else {
            System.out.println("Пес не может столько пробежать");
        }
    }

    @Override
    public void swim(int swimLength) {
        if (swimLength < 0) {
            System.out.println("Собаки плывут только вперед!");
        } else if (swimLength <= 10) {
            System.out.println("Пес проплыл " + swimLength + " метров");
        } else {
            System.out.println("Пес не может столько проплыть");
        }
    }

    void setHowCheckDog(int howCheckDog) {
        this.howCheckDog = howCheckDog;
    }

    @Override
    public void checkInfo() {
        System.out.println("Было создано " + howCheckDog + " псов");
    }
}