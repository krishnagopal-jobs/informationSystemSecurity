package edu.hood.encryption;

public interface EncryptionAlgorithm {
    
    String decrypt(String plainText);
    
    String encrypt(String encryptedText);
    
}
