def main():
    n = int(input())
    steps = []
    for _ in range(n):
        steps.append(int(input()))
    result = [None] * n

    if n == 1:
        print(steps[0])
        return
    elif n == 2:
        print(steps[0] + steps[1])
        return
    elif n == 3:
        print(max(steps[0]+steps[1], steps[0]+steps[2], steps[1]+steps[2]))
    else:
        result[0] = steps[0]
        result[1] = result[0] + steps[1]
        result[2] = max(steps[0]+steps[2], steps[1] + steps[2])
        for i in range(3, n):
            result[i] = max(steps[i]+result[i-2], steps[i]+steps[i-1]+result[i-3])

        print(result[-1])

if __name__ == "__main__":
    main()