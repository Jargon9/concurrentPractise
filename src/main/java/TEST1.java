import java.util.Scanner;

public class TEST1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println(Math.pow(2,0.5));
        int num = in.nextInt();
        in.nextLine();
        for (int i=0; i<num; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int len = in.nextInt();
            System.out.println(findTime1(x, y, len));
            in.nextLine();
        }
    }


    public static int findTime(int x, int y, int len) {
        double lenFromZero = Math.pow((Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2)), 0.5);
        int xLen = Math.abs(x), yLen = Math.abs(y);
        if (lenFromZero == len) {
            if (xLen == 0 && yLen == 0) {
                return 0;
            } else if (xLen == 0 || yLen == 0) {
                return 2;
            } else {
                return 3;
            }
        } else if (lenFromZero > len){
            if (xLen > len && yLen > len) {
                return 0;
            } else if (xLen > len || yLen > len || (yLen == len && xLen == len)) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return 4;
        }
    }


    public static int findTime1(int x, int y, int len) {
        double lenFromZero = Math.pow((Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2)), 0.5);
        int xLen = Math.abs(x), yLen = Math.abs(y);
        int max = 0, equal = 0;
        if (xLen < len) {
            max++;
        } else if (xLen == len) {
            equal++;
        }

        if (yLen < len) {
            max++;
        } else if (yLen == len) {
            equal++;
        }
        if (max == 2) {
            if (lenFromZero == len) {
                return 3;
            }
        }
        if (max == 1 && equal == 1 && (xLen == 0 || yLen == 0)) {
            return 2;
        }
        return max * 2 + equal * 1;
    }
}
