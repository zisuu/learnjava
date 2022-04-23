package Kap4;

public class tabelle {
    public static void main(String[] args) {
        
        int[][] tabelle = new int[8][8];
        for (int x = 0; x < tabelle.length; x++){
            for (int y = 0; y < tabelle[x].length; y++){
                int wert = tabelle[x][y];
                System.out.println("Tabelle-X: " +x);
                System.out.println("Tabelle-Y: " +y);
            }
        }
    }
}
