public class BinaryToDecimal {
    public static int binToDeci(int num) {
        int idx = 0;
        int decimalNumber = 0;
        while (num > 0) {
            decimalNumber += (num % 10) * Math.pow(2, idx++);
            num/=10;
        }
        return decimalNumber;
    }
    public static void main(String[] args) {
        int example = 100;
        System.out.println(binToDeci(example));
    }
}
