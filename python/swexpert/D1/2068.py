T = int(input())
for t in range(1, T+1):
    numbers = [*map(int, input().split())]
    largest = max(numbers)
    print("#{0} {1}".format(t, largest))