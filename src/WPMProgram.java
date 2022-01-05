import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WPMProgram {

    static String[] words = {"baby", "steak", "envelope", "biscuit", "hammer", "while", "interesting", "vanish", "lyrical", "pigs", "gullible", "expansion", "superb", "enjoy", "subdued", "vein", "unit", "cat", "minor", "excuse", "wealthy", "zip", "black", "pen", "nebulous", "possible", "dye", "delicate", "bucket", "tiny", "disgusting", "rescue", "dock", "clam", "cub", "approval", "dramatic", "tax", "innocent", "happy", "relax", "tasty", "illegal", "duck", "tangible", "notice", "equal", "cushion", "trip"};

    public static void main(String args[]) throws InterruptedException {
        //Countdown
        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);

        //Create randomly generated line of words & print
        String wordline = "";
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
           wordline += words[rand.nextInt(words.length)] + " ";
        }
        wordline = wordline.trim();
        String[] wordline_ls = wordline.split(" "); //Array of generated line of words
        System.out.println(wordline);
        System.out.println();

        //Stores start time
        double start_time = LocalTime.now().toNanoOfDay();

        Scanner scan = new Scanner(System.in);

        //Takes user's typed words as input
        String typedWords = scan.nextLine();
        String[] typedWords_ls = typedWords.split(" "); //Array of user's typed words

        //Stores end time & calculates elapsed time
        double end_time = LocalTime.now().toNanoOfDay();
        double elapsed = end_time - start_time;
        double seconds = elapsed / 1_000_000_000.0;
        int numChars = typedWords.length();

        //Calculates # of errors
        int errors = 0;
        int size = wordline_ls.length;
        for (int j = 0; j < size; j++) {
            if (!wordline_ls[j].equals(typedWords_ls[j]))
                errors += 1;
        }

        //Calculates Gross WPM
        int wpm = (int) (((((double) numChars / 5) - errors) / seconds) * 60);
        System.out.println("Your wpm is " + wpm + "!");
        System.out.println("You got " + (size - errors) + " out of " + size + " words correct");
        //hi
    }
}






















