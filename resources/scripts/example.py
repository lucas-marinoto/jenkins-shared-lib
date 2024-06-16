# import logging
# import sys

# # Configuração básica do logger
# logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')

# def main():
#     logging.info("Starting the Python script...")

#     logging.info("This is an info message.")
#     logging.warning("This is a warning message.")
#     logging.error("This is an error message.")

#     # Simulating an error with a custom message
#     try:
#         raise Exception("This is a simulated error!")
#         # raise ValueError("This is a simulated error!")
#     except ValueError as e:
#         logging.error(f"An error occurred: {e}")
#         sys.exit(1)  # Exit with an error code

# if __name__ == "__main__":
#     main()

import log_utils
import sys

logger = log_utils.setup_logger()

def main():
    logger.info("Starting the Python script...")

    logger.info("This is an info message.")
    logger.warning("This is a warning message.")
    logger.error("This is an error message.")

    # Simulating an error with a custom message
    log_utils.log_error_and_exit("This is a simulated error!")

if __name__ == "__main__":
    main()
