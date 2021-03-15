package homework6;

public class Cat extends Animal{
protected int howCheckCat;

    public Cat(){
        super.howCheck = super.howCheck + 1;
        setHowCheckCat(howCheckCat++);
    }

    @Override
    public void run(int ranLength) {
        this.ranLength = ranLength;
        if (ranLength < 0){
            System.out.println("Коты бегут только вперед!");
          }else if(ranLength <= 200 ) {
            System.out.println("Кот пробежал " + ranLength + " метров");
        } else {
            System.out.println("Кот не может столько пробежать");
        }
    }
    @Override
    public void swim(int swimLength){
            System.out.println("Кот не может столько проплыть");
        }

    private void setHowCheckCat(int howCheckCat) {
        this.howCheckCat = howCheckCat;
    }
    @Override
    public void checkInfo(){
        System.out.println("Было создано " + howCheckCat + " котов");
    }
}

