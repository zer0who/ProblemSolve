def main():
    N = int(input())
    ascendings = []
    numbers = list(map(int, input().split()))
    ascendings = [0 for i in range(N)]
    for i in range(len(numbers)):
        ascendings[i] = 1
        for j in range(i):
            if numbers[j] < numbers[i]:
                ascendings[i] = max(ascendings[i], ascendings[j]+1)
    print(max(ascendings))


if __name__ == "__main__":
    main()