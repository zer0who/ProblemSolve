def isPrime(num: int) -> bool:
    if num == 0 or num == 1:
        return False
    for i in range(2, int(num**(1/2))+1):
        if num % i == 0:
            return False
        
    return True

def main():
    n = int(input())
    for _ in range(n):
        num = int(input())
        while True:
            if (isPrime(num)):
                print(num)
                break
            num += 1


if __name__ == "__main__":
    main()