def main():
    N, K = map(int, input().split())
    divisor = []
    for i in range(1, N+1):
        if N % i == 0:
            divisor.append(i)
    
    try:
        print(divisor[K-1])
    except IndexError:
        print(0)

if __name__ == "__main__":
    main()