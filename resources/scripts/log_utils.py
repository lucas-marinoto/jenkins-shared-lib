import logging
import sys

def setup_logger():
    # Configuração básica do logger
    logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')
    return logging.getLogger()

def log_info(message):
    logger = logging.getLogger()
    logger.info("[INFO] " + message)

def log_warning(message):
    logger = logging.getLogger()
    logger.warning("[WARNING] " + message)

def log_error(message):
    logger = logging.getLogger()
    logger.error("[ERROR] " + message)

def log_error_and_exit(message):
    log_error(message)
    sys.exit(1)
