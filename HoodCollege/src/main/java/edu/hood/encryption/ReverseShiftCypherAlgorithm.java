package edu.hood.encryption;

import java.util.Scanner;

public class ReverseShiftCypherAlgorithm implements EncryptionAlgorithm {

    private int key;

    public ReverseShiftCypherAlgorithm(int key) {
        this.key = key;
    }

    @Override
    public String decrypt(String encryptedText) {
        ReverseShiftCypherAlgorithm algorithm = new ReverseShiftCypherAlgorithm(-key);
        return algorithm.encrypt(encryptedText);
    }

    @Override
    public String encrypt(String plainText) {
        StringBuffer stringBuffer = new StringBuffer();
        plainText = plainText.toLowerCase();
        for (Scanner wordScanner = new Scanner(plainText); wordScanner.hasNext();) {
            String word = wordScanner.next();
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                int encryptedCharacter = 'a' + 'z' + key - ((wordArray[i]));
                while (encryptedCharacter > 'z') {
                    encryptedCharacter -= 26;
                }
                while (encryptedCharacter < 'a') {
                    encryptedCharacter += 26;
                }
                wordArray[i] = (char) encryptedCharacter;
            }
            stringBuffer.append(new String(wordArray) + " ");
        }
        return stringBuffer.toString();
    }

    public static String[] bruteforceDecryption(String encryptedText) {
        String[] result = new String[26];
        for (int key = 0; key < 26; key++) {
            ReverseShiftCypherAlgorithm algorithm = new ReverseShiftCypherAlgorithm(key);
            result[key] = algorithm.decrypt(encryptedText);
        }
        return result;
    }

}
