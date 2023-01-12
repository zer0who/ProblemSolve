num_divisor_of_N = int(input())
divisors_of_N = [*map(int, input().split())]
divisors_of_N.sort()
print(divisors_of_N[0] * divisors_of_N[-1])