class Matrix {
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},
                        {5,6,7,8},
                        { 9, 10, 11, 12 },
                        {13,14,15,16} };
        System.out.println(staircaseSearch(matrix, 10));
    }
    
    public static void spiralMatrix(int matrix[][]) {
        int sr = 0;
        int sc = 0;
        int er = matrix.length - 1;
        int ec = matrix[0].length - 1;

        while (sr <= er && sc < ec) {

            //top
            for (int i = sc; i <= ec; i++) {
                System.out.print(matrix[sr][i] + " ");
            }

            //right
            for (int i = sr + 1; i <= er; i++) {
                System.out.print(matrix[i][ec] + " ");
            }

            //bottom 
            for (int i = ec - 1; i >= sc; i--) {
                if (sr == er) {
                    break;
                }
                System.out.print(matrix[er][i] + " ");
            }

            //left
            for (int i = er - 1; i > sr; i--) {
                if (sc == ec) {
                    break;
                }
                System.out.print(matrix[i][sc] + " ");
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
    }
    
    public static void sumOfDiagonal(int matrix[][]) {
        //n*n
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (2 * i != (matrix.length - 1)) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        System.out.println(sum);
    }
    
    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                return true;
            } else if (matrix[row][col] > key) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    
    public static boolean isPalindron(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}