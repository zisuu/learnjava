package app.Kap12;

/**
 * ID3-Tag, einen kurzen Block von Textdaten, der Titel, Interpret und einige weitere Informationen enthält. 
 * Von diesem Tag gibt es zwei Versionen, von denen Version 1 (ID3v1) immer noch verbreitet und einfacher zu
 *  verarbeiten ist. Wenn ein ID3v1-Tag vorhanden ist, dann steht es in den 128 Byte der Datei und ist 
 * aufgebaut wie in Tabelle 12.2 beschrieben. Alle Felder liegen im Encoding ISO-8859-1 vor und müssen 
 * nicht unbedingt befüllt sein.
 * 
 * Schreiben Sie eine neue Klasse Song, oder erweitern Sie die schon vorhandene Klasse, die alle Felder des 
 * ID3v1-Tags und den absoluten Pfad zur Datei enthält. Schreiben Sie in dieser Klasse eine statische Methode 
 * ausMP3, die einen neuen Song erzeugt, bei dem alle Felder aus dem Tag befüllt sind, sofern es vorhanden ist.
 * 
 * Ändern Sie dann Ihre Playlist aus der vorigen Übung so ab, dass sie eine Liste von Song-Objekten enthält 
 * statt einer Liste von Strings. Beim Schreiben und Lesen der Playlist sollen alle Felder des Songs berücksichtigt
 *  werden. Geben Sie nach wie vor pro Song eine Zeile aus, und trennen Sie die einzelnen Felder durch |-Zeichen.
 * 
 * Ein Hinweis für den Anfang: Auch wenn Sie Textdaten auslesen wollen, handelt es sich doch um eine Binärdatei.
 *  Verwenden Sie also einen InputStream, und lesen Sie Byte-Werte aus. Aus ihnen können Sie mit dem String-Konstruktor
 *  String(byte[] daten, Charset encoding) einen String erzeugen, bei dem das richtige Encoding verwendet wird:
 * new String(buffer, Charset.forName("ISO-8859-1"));
 * 
 * Um die richtige Stelle in der Datei zu finden, müssen Sie nicht die ganze Datei einlesen und dann nur die letzten 
 * 128 Byte verarbeiten. Mit der skip-Methode können Sie eine Anzahl an Bytes überspringen und dadurch gleich an der 
 * richtigen Stelle zu lesen beginnen.
 */
public class ID3Tags {
    
}
