T = int(input())
for t in range(1, T+1):
    N = int(input())
    numbers = [*map(int, input().split())]
    max_sum = numbers[0]
    for i in range(N - 1):
        if numbers[i] > 0 and numbers[i] + numbers[i+1] > 0:
            numbers[i+1] += numbers[i]
        if max_sum < numbers[i+1]:
            max_sum = numbers[i+1]

    print("#{} {}".format(t, max_sum))
