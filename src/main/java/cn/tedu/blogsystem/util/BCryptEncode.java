package cn.tedu.blogsystem.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 利用BCrypt解码的工具类
 */
public class BCryptEncode {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encryptionPassword(String rawPassword){
        String encode = passwordEncoder.encode(rawPassword);
        return encode;
    }
}
