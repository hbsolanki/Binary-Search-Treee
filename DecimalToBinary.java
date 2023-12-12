public class DecimalToBinary {
    public static int deciToBin(int decimalNumber) {
        int binaryNumber = 0;
        int idx = 0;
        while (decimalNumber > 0) {
            int red = decimalNumber % 2;
            binaryNumber += (int) red * Math.pow(10, idx++);
            decimalNumber /= 2;
        }
        return binaryNumber;
    }
    
    public static void main(String[] args) {
        int example = 5;
        System.out.println(deciToBin(example));
    }
}
