package com.example.demo.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

// 簡易な動作確認用ログ
public class LoggerUtility {
    private static final Logger logger = Logger.getLogger(LoggerUtility.class.getName());

    public static void logInfo(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        logger.info("[" + now.format(formatter) + "] " + message);
    }
}
