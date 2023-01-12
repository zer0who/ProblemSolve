def getGCD(num1: int, num2: int) -> int:
    b = num2
    a = num1
    r = b % a
    while r != 0:
        b = a
        a = r
        r = b % a
    
    return a


def main():
    N = int(input())
    numbers = []
    for _ in range(N):
        numbers.append(int(input()))
    numbers.sort()
    sub_of_nums = []
    for i in range(0, len(numbers)-1):
        sub_of_nums.append(numbers[i+1] - numbers[i])
    num_gcd = sub_of_nums[0]
    for i in range(1, len(sub_of_nums)):
        num_gcd = getGCD(num_gcd, sub_of_nums[i])

    M = set()
    for i in range(2, int(num_gcd**(1/2))+1):
        if num_gcd % i == 0:
            M.add(i)
            M.add(num_gcd // i)
    M.add(num_gcd)
        
    M = list(M)
    M.sort()
    for m in M:
        print(m, end=" ")


if __name__ == "__main__":
    main()