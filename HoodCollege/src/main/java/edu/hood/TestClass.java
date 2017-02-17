/**
 * 
 */
package edu.hood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import edu.hood.encryption.ReverseShiftCypherAlgorithm;
import edu.hood.encryption.ShiftCypherAlgorithm;

/**
 * @author kisna
 *
 */
public class TestClass {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // fqjcb rwjwj vnjax bnkhj whxcq nawjv nfxdu mbvnu ujbbf nnc
        // oczmz vmzor jocdi bnojv dhvod igdaz admno ojbzo rcvot jprvi oviyv aozmo cvooj ziejt dojig toczr dnzno jahvi fdiyv xcdzq zoczn zxjiy
        // pbegu uymiq icuuf guuyi qguuy qcuiv fiqgu uyqcu qbeme vp
        // jrgdg idxgq anngz gtgtt sitgj ranmn oeddi omnwj rajvk sexjm dxkmn wjrgm ttgdt gognj ajmzg ovgki nlaqg tjamn xmsmj jrgko jtgnw jrgnj rgvat tmgta wamno jjrgw izgtn sgnji babgu

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                Scanner inputScanner = new Scanner(System.in);) {
            System.out.print("Enter the encrypted text:");

            String sentence = inputScanner.nextLine().toLowerCase().trim();

            String[] shiftResult = ShiftCypherAlgorithm.bruteforceDecryption(sentence);
            for (int key = 0; key < 26; key++) {
                System.out.printf("[%1$02d] : ", key);
                System.out.println(shiftResult[key]);
            }

            System.out.println("==============================================================================");
            
            System.out.printf("[%1$02d] : ", 0);
            System.out.println(sentence);
            
            String[] reverseShiftResult = ReverseShiftCypherAlgorithm.bruteforceDecryption(sentence);
            for (int key = 0; key < 26; key++) {
                System.out.printf("[%1$02d] : ", key);
                System.out.println(reverseShiftResult[key]);
            }
            

        }

    }

}
