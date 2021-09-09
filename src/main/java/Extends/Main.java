package Extends;

public class Main {
    public static void main(String[] args) {
        Father father = new Father();
        Chlid chlid = new Chlid();
        Father father1 = new Chlid();
        father.test1();
        chlid.test1();
        father1.test1();
    }
}
