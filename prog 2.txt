public class Square {
    void printPattern(int n) {
        int a,curr_star = 0;
        for (a = 1; a <= n; ) {
            if (curr_star < n) {
                System.out.print("*");
                curr_star++;
                continue;
            }
            if (curr_star == n) {
                System.out.println();
                a++;
                curr_star = 0;
            }
        }
    }

    public static void main(String[] args) {
    	Square a = new Square();
        a.printPattern(5);
    }
}