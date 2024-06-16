package org.jenkins.utils

class LogUtils {
    static void info(String message) {
        echo "INFO: ${message}"
    }

    static void warning(String message) {
        echo "WARNING: ${message}"
    }

    static void error(String message) {
        echo "ERROR: ${message}"
    }

    static void success(String message) {
        echo "SUCCESS: ${message}"
    }
}
