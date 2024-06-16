package org.jenkins.utils

class LogUtils {
    static void info(String message) {
        echoMessage("INFO", message)
    }

    static void warning(String message) {
        echoMessage("WARNING", message)
    }

    static void error(String message) {
        echoMessage("ERROR", message)
    }

    static void success(String message) {
        echoMessage("SUCCESS", message)
    }

    private static void echoMessage(String level, String message) {
        // Utiliza o método echo no contexto do pipeline
        def script = new groovy.lang.GroovyShell().evaluate("script")
        script.echo "${level}: ${message}"
    }
}
