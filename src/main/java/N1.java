public class N1 {
    public static void main(String[] args) {
        System.out.println(tool(3,10));
    }

    public static long tool(int x, long y) {
        long res = 0, tempY = y;
        long tempAdd = 1, tempAddSum = 1;
        while (tempY>0) {
            boolean mark = false;
            long temp = tempY % 10;
            if (temp >= x) {
                tempAddSum += tempAdd;
                res += tempAddSum;
            }
            tempAdd = 10 * tempAdd;
            tempY /= 10;
        }
        return res + y - 1;
    }
}
