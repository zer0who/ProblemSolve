def main():
    n = int(input())
    dp_count = 0
    fib = [0] * (n+1)
    fib[1] = 1
    fib[2] = 1
    for i in range(3, n+1):
        fib[i] = fib[i-1] + fib[i-2]
        dp_count += 1
    
    print(fib[n], dp_count)


if __name__ == "__main__":
    main()