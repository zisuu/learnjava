package Kap3;

public class Kartennamen {
    public static void main(String[] args) {
        System.out.println(kartenName("Rot", 11));

    }
    public static String kartenName(String farbe, int wert){
        String name = farbe + " ";
        switch(wert){
            case 1:
                name += "As";
                break;
            case 11:
                name += "Bube";
                break;
            case 12:
                name += "Dame";
                break;
            case 13:
            name += "König";
            break;
        default:
            name += wert;
    }
    return name;
}
}
