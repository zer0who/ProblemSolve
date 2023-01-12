a, b = map(int, input().split())
divisor_of_a = set()
divisor_of_b = set()
n = 1

while True:
    if a % n == 0:
        divisor_of_a.add(n)
    if b % n == 0:
        divisor_of_b.add(n)

    n += 1
    if n > max(a, b):
        break

greatest_divisor = max(divisor_of_a.intersection(divisor_of_b))
print(greatest_divisor)
print(a * b // greatest_divisor)