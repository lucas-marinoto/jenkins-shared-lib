import logging
import sys

# Configuração básica do logger
logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')

def main():
    logging.info("Starting the Python script...")

    logging.info("This is an info message.")
    logging.warning("This is a warning message.")
    logging.error("This is an error message.")

    # Simulating an error with a custom message
    try:
        raise ValueError("This is a simulated error!")
    except ValueError as e:
        logging.error(f"An error occurred: {e}")
        sys.exit(1)  # Exit with an error code

if __name__ == "__main__":
    main()
