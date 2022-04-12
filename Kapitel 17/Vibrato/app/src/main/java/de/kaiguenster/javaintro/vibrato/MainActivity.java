package de.kaiguenster.javaintro.vibrato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final Long DOT = 200l;
    public static final Long DASH = 3 * DOT;
    public static final Long SIGNAL_GAP = DOT;
    public static final Long CHARACTER_GAP = 3 * DOT;
    public static final Long WORD_GAP = 7 * DOT;

    public static final Map<Character, long[]> MORSE_ALPHABET;
    static {
        Map<Character, long[]> tmp = new HashMap<>();
        tmp.put('A', new long[]{DOT, DASH});
        tmp.put('B', new long[]{DASH, DOT, DOT, DOT});
        tmp.put('C', new long[]{DASH, DOT, DASH, DOT});
        tmp.put('D', new long[]{DASH, DOT, DOT});
        tmp.put('E', new long[]{DOT});
        tmp.put('F', new long[]{DOT, DOT, DASH, DOT});
        tmp.put('G', new long[]{DASH, DASH, DOT});
        tmp.put('H', new long[]{DOT, DOT, DOT, DOT});
        tmp.put('I', new long[]{DOT, DOT});
        tmp.put('J', new long[]{DOT, DASH, DASH, DASH});
        tmp.put('K', new long[]{DASH, DOT, DASH});
        tmp.put('L', new long[]{DOT, DASH, DOT, DOT});
        tmp.put('M', new long[]{DASH, DASH});
        tmp.put('N', new long[]{DASH, DOT});
        tmp.put('O', new long[]{DASH, DASH, DASH});
        tmp.put('P', new long[]{DOT, DASH, DASH, DOT});
        tmp.put('Q', new long[]{DASH, DASH, DOT, DASH});
        tmp.put('R', new long[]{DOT, DASH, DOT});
        tmp.put('S', new long[]{DOT, DOT, DOT});
        tmp.put('T', new long[]{DASH});
        tmp.put('U', new long[]{DOT, DOT, DASH});
        tmp.put('V', new long[]{DOT, DOT, DOT, DASH});
        tmp.put('W', new long[]{DOT, DASH, DASH});
        tmp.put('X', new long[]{DASH, DOT, DOT, DASH});
        tmp.put('Y', new long[]{DASH, DOT, DASH, DASH});
        tmp.put('Z', new long[]{DASH, DASH, DOT, DOT});
        tmp.put('1', new long[]{DOT, DASH, DASH, DASH, DASH});
        tmp.put('2', new long[]{DOT, DOT, DASH, DASH, DASH});
        tmp.put('3', new long[]{DOT, DOT, DOT, DASH, DASH});
        tmp.put('4', new long[]{DOT, DOT, DOT, DOT, DASH});
        tmp.put('5', new long[]{DOT, DOT, DOT, DOT, DOT});
        tmp.put('6', new long[]{DASH, DOT, DOT, DOT, DOT});
        tmp.put('7', new long[]{DASH, DASH, DOT, DOT, DOT});
        tmp.put('8', new long[]{DASH, DASH, DASH, DOT, DOT});
        tmp.put('9', new long[]{DASH, DASH, DASH, DASH, DOT});
        tmp.put('0', new long[]{DASH, DASH, DASH, DASH, DASH});
        MORSE_ALPHABET = Collections.unmodifiableMap(tmp);
    }

    private static long[] stringToMorse(String in){
        String[] words = in.toUpperCase().split(" ");
        List<Long> collector = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            appendMorseWord(words[i], collector);
            if (i != words.length - 1){
                collector.add(WORD_GAP);
            }
        }
        return listToLongArray(collector);
    }

    private static long[] listToLongArray(List<Long> collector) {
        long[] out = new long[collector.size() + 1];
        int idx = 0;
        out[idx++] = 0;
        for (Long l : collector){
            out[idx++] = l;
        }
        return out;
    }

    private static void appendMorseWord(String word, List<Long> collector) {
        char[] characters = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            long[] morse = MORSE_ALPHABET.get(characters[i]);
            if (morse == null){
                throw new IllegalArgumentException("Not a morse character: " + characters[i]);
            }
            appendMorseCharacter(collector, morse);
            if(i != word.length() - 1){
                collector.add(CHARACTER_GAP);
            }
        }
    }

    private static void appendMorseCharacter(List<Long> collector, long[] morse) {
        for (int j = 0; j < morse.length; j++) {
            long tap = morse[j];
            collector.add(tap);
            if (j != morse.length - 1){
                collector.add(SIGNAL_GAP);
            }
        }
    }


    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void morse(View view){
        EditText textField = findViewById(R.id.inputText);
        String text = textField.getText().toString();
        MainActivity.this.runOnUiThread(new Morser(vibrator, text));
    }


    private static final class Morser implements Runnable{

        private android.os.Vibrator vibrator;
        private String text;

        public Morser(Vibrator vibrator, String text) {
            this.vibrator = vibrator;
            this.text = text;
        }

        @Override
        public void run() {
            try {
                long[] morse = MainActivity.stringToMorse(text);
                vibrator.vibrate(morse, -1);
            } catch (Exception e) {
                vibrator.vibrate(2000);
            }
        }
    }
}
