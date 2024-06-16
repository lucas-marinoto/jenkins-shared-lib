package org.jenkins.utils

class LogUtils {
    static void info(script, String message) {
        script.echo "INFO: 💡 -  ${message}"
    }

    static void warning(script, String message) {
        script.echo "WARNING: ⚠️ -  ${message}"
    }

    static void error(script, String message) {
        script.echo "ERROR: ❌ -  ${message}"
    }

    static void success(script, String message) {
        script.echo "SUCCESS: ✅ - ${message}"
    }
}