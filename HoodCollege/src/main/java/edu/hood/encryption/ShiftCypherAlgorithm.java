package edu.hood.encryption;

import java.util.Scanner;

public class ShiftCypherAlgorithm implements EncryptionAlgorithm {

    private int key;

    public ShiftCypherAlgorithm(int key) {
        this.key = key;
    }

    @Override
    public String decrypt(String encryptedText) {
        ShiftCypherAlgorithm algorithm = new ShiftCypherAlgorithm(-key);
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
                int encryptedCharacter = (wordArray[i]) + key;
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
            ShiftCypherAlgorithm algorithm = new ShiftCypherAlgorithm(-key);
            result[key] = algorithm.encrypt(encryptedText);
        }
        return result;
    }

}
