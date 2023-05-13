T = int(input())
for _ in range(T):
    a, b = map(int, input().split())
    greatest_divisor = 0
    for i in range(1, (min(a, b) + 1)):
        if a % i == 0 and b % i == 0:
            if i > greatest_divisor:
                greatest_divisor = i
    
    print(a * b // greatest_divisor)
