package homework7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Plate plate = new Plate(30);
        cat.eat(plate);
        System.out.println(plate.getFood());
        cat.checkSatiety();
        plate.putFood(30);
        System.out.println(plate.getFood());
        cat.eat(plate);


        System.out.println();
        System.out.println();


        Cat[] cat1 = new Cat[4];

        Plate plate1 = new Plate(80);
        int howEatCat = 0;
        for (int i = 0; i < cat1.length; i++) {
            Cat tmp = new Cat();
            tmp.eat(plate1);
            if (tmp.getIsSatiety()) {
                howEatCat++;
            }
        }
        System.out.println("Было накормлено " + howEatCat + " котов");
    }
}
