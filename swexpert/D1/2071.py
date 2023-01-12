T = int(input())
for t in range(1, T+1):
    numbers = [*map(int, input().split())]
    avg = round(sum(numbers) / 10)
    print("#{0} {1}".format(t, avg))