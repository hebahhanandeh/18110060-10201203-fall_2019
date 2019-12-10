public class Triangle {
    void printPattern(int n) {
        int a,curr_star = 0;
        for (a = 1; a <= n; ) {
            if (curr_star < a) {
                System.out.print("*");
                curr_star++;
                continue;
            }
            if (curr_star == a) {
                System.out.println();
                a++;
                curr_star = 0;
            }
        }
    }

    public static void main(String[] args) {
    	Triangle a = new Triangle();
        a.printPattern(5);
    }
}