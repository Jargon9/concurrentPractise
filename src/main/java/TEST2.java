import java.util.Scanner;

public class TEST2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int t = in.nextInt();
        int c = in.nextInt();
        in.nextLine();
        int[] cs = new int[num];
        for (int i=0; i<num; i++) {
            cs[i] = in.nextInt();
        }
        System.out.println(findTime(cs, t, c));
    }


    public static int findTime(int[] cs, int t, int c) {
        if (c > cs.length) return 0;
        int res = 0, count = 0;
        for (int i=0; i<cs.length; i++) {
            if (cs[i] <= t) {
                count++;
            } else {
                count=0;
            }
            if (count >= c) {
                res++;
            }
        }
        return res;
    }
}
