package ar.edu.utn.frba.dds.group5.students.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashingUtils {
    public static String sha256Of(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            // Contraseña vacía, sin caracteres (es base 64)
            return "47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU";
        }
    }
}
