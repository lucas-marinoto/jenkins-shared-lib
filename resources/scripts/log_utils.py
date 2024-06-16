import logging
import sys

def setup_logger():
    # Configuração básica do logger
    logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')
    return logging.getLogger()

def log_info(message):
    logger = logging.getLogger()
    logger.info("\U0001F4A1 " + message)

def log_warning(message):
    logger = logging.getLogger()
    logger.warning("\u26A0\ufe0f " + message)

def log_error(message):
    logger = logging.getLogger()
    logger.error("\u274C " + message)

def log_error_and_exit(message):
    log_error("\u274C " + message)
    sys.exit(1)

