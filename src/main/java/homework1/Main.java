package homework1;

public class Main {

    public static void main(String[] args) {

    }
    public static void second(){
        byte a = 10;
        short b = 15;
        int c = 20;
        long d = 25L;
        float e = 5.2f;
        double f = 44.82;
        char g = 'g';
        boolean h = true;
        String i = "Вечер добрый";
    }
    public static float third(float a,float b,float c,float d){

        return (a * (b + (c / d)));
    }

    public static boolean fourth(int a, int b){
        int c;
        c = a + b;
        boolean otvet = false;
        byte min = 10;
        byte max = 20;
        if( min <= c && c <= max) {
            otvet = true;
        }
        return otvet;
    }

    public static void fifth(int chislo) {
        if (chislo < 0) {
            System.out.println("Отрицательное");
        } else {
            System.out.println("Положительное");
        }
    }
    public static boolean sixth(int drugoe_chislo) {

        if (drugoe_chislo < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void seventh(String name) {
        System.out.println("Привет " + name);
    }
    public static void visokosniy(int god){
        int na4 = god % 4;
        int na100 = god % 100;
        int na400 = god % 400;
        if (na400 == 0){
            System.out.println(god + " високосный");
        }else if(na100 == 0){
            System.out.println(god + " не високосный");
        }else if(na4 == 0){
            System.out.println(god + " високосный");
        }else {
            System.out.println(god + " не високосный");
        }
    }
// Вношу изменения
}
