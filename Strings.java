class Abc {
    public static void main(String[] args) {
        String path = "NSEEE";
        System.out.println(minPath(path));
    }
    
    public static float minPath(String path) {
        int x = 0, y = 0;

        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);

            if (dir == 'N') {
                y++;
            }
            if (dir == 'S') {
                y--;
            }
            if (dir == 'W') {
                x--;
            }
            if (dir == 'E') {
                x++;
            }
        }

        return (float) Math.sqrt((x * x) + (y * y));
    }

}
