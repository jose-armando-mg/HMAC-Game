package armando;

import java.security.SecureRandom;

public class CreateKey {
    public String generate() throws Exception {
        SecureRandom generator = SecureRandom.getInstanceStrong();
        byte[] key = new byte[32];

        generator.nextBytes(key);
        String keyHex = bytesToHex(key);

        return keyHex;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
