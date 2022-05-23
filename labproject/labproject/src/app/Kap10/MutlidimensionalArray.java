package app.Kap10;

public class MutlidimensionalArray {
    public static void main(String[] args) {

        // create a 2d array
        int[][] a = {
                { 1, 2, 3 },
                { 4, 5, 6, 9 },
                { 7 },
        };

        // calculate the length of each row
        System.out.println("Length a of row 1: " + a[0].length);
        System.out.println("Length a of row 2: " + a[1].length);
        System.out.println("Length a of row 3: " + a[2].length);
        
        for (int i = 0; i < a.length; ++i) {
            for(int j = 0; j < a[i].length; ++j) {
                System.out.println(a[i][j]);
            }
        }

        int[][] b = new int [3][];
        b[0] = new int[]{5};
        b[1] = new int[]{5,4,3};
        b[2] = new int[]{5,4};
        System.out.println("Length b of row 1: " + b[0].length);
        System.out.println("Length b of row 2: " + b[1].length);
        System.out.println("Length b of row 3: " + b[2].length);

        for (int i = 0; i < b.length; ++i) {
            for(int j = 0; j < b[i].length; ++j) {
                System.out.println(b[i][j]);
            }
        }

    }

}
