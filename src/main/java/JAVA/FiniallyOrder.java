package JAVA;

public class FiniallyOrder {
    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(f2());
    }
    public static int f() {
        int b = 20;
        try {
            return ++b;
        } finally {
            return b ;
        }
    }

    public static int f2() {
        int b = 20;
        try {
            return b + 1;
        } finally {
            return b;
        }
    }
}
