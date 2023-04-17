import sys

def main():
    while True:
        try:
            print(input())
        except EOFError:
            return

if __name__ == "__main__":
    main()