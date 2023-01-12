def factorial(num):
    if num <= 1:
        return 1
    else:
        return num * factorial(num-1)


def main():
    N = int(input())
    factorial_N = str(factorial(N))
    count_0 = 0
    for i in reversed(range(len(factorial_N))):
        if factorial_N[i] != "0":
            break
        count_0 += 1
    print(count_0)


if __name__ == "__main__":
    main()