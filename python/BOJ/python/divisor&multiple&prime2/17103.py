def main():
    T = int(input())
    numbers = [int(input()) for _ in range(T)]
    eratosthenes = [False, False] + [True] * (max(numbers)-1)
    for i in range(2, len(eratosthenes)):
        if eratosthenes[i]:
            for j in range(i*2, max(numbers)+1, i):
                eratosthenes[j] = False
    
    for n in numbers:
        ans = 0
        for i in range(2, int(n/2)+1):
            if eratosthenes[i] == True and eratosthenes[n-i] == True:
                ans += 1
        print(ans)
    


if __name__ == "__main__":
    main()