package Kap3;

// Für alle folgenden Codefragmente gilt, dass i, j und k int-Variablen mit den Werten i = 0, j = 7 und k = 13 sind.
// Welchen Wert haben die drei Variablen, nachdem die Fragmente ausgeführt wurden?

public class Booleanex {
    public static void main(String[] args) {
    int i = 0, j = 7, k = 13;

    //Fragment 1
    if (i > 0 || j > 5){
        k = 10;
    } // i=0,j=7,k=10

    //Fragment 2
    if (i > 0 && j > 5){
        k = 10;
    } // schlaufe wird nicht ausgeführt, da i nicht grösser als 0, i=0,j=7,k=13

    //Fragment 3
    if ((i > 0 && j > 5) || k < 15){
        k = 10;
    } // i=0,j=7,k=10

    //Fragment 4
    if ((i > 0 || j > 5) && k > 15){
        k = 10;
    } // schlaufe wird nicht ausgeführt, da zweite Klammer = false, i=0,j=7,k=13

    //Fragment 5
    if (i == 0 & j++ < 5){
        k = 10;
    } // schlaufe wird nicht ausgeführt, da zweite Bedinung = false, da kein Kurzschlussop. wird j erhöht: i=0,j=8,k=13

    //Fragment 6
    if (i == 0 && j++ < 5){
        k = 10;
    } // schlaufe wird nicht ausgeführt, da zweite Bedinung = false, da Kurzschlussop. und erste Bedingung = true wird j erhöht: i=0,j=8,k=13

    //Fragment 7
    if (i != 0 && j++ < 5){
        k = 10;
    } // schlaufe wird nicht ausgeführt, da erste Bedinung = false, da Kurzschlussop. wird j nicht erhöht: i=0,j=7,k=13

    //Fragment 8
    if (i != 0 & j++ < 5){
        k = 10;
    } // schlaufe wird nicht ausgeführt, da zweite Bedinung = false, da kein Kurzschlussop. wird j erhöht: i=0,j=8,k=13


    }
}
