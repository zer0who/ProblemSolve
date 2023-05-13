def factorial(n: int) -> int:
    if n == 0 or n == 1:
        return 1
    return n * factorial(n-1)

def main():
    N = int(input())
    print(factorial(N))

if __name__ == "__main__":
    main()