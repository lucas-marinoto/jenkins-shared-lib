import logging

def setup_logger():
    # Configuração básica do logger
    logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')
    return logging.getLogger()

def log_error_and_exit(message):
    logger = logging.getLogger()
    logger.error(message)
    sys.exit(1)
