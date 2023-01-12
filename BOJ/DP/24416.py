import sys

def fibRecursion(num: int) -> tuple:
    global count_recursion

    if num == 1 or num == 2:
        count_recursion += 1
        return 1
    else:
        return fibRecursion(num-1) + fibRecursion(num-2)

def fibDP(fib_list: list, num: int) -> tuple:
    count = 0
    fib_list[1] = 1
    fib_list[2] = 1
    for i in range(3, num+1):
        fib_list[i] = fib_list[i-1] + fib_list[i-2]
        count += 1

    return fib_list[num], count


def main():
    global count_recursion

    n = int(sys.stdin.readline())
    fib_list = [0]*(n+1)
    count_recursion = 0

    fibRecursion(n)
    _, count_dp = fibDP(fib_list, n)
    print(count_recursion, count_dp)


if __name__ == "__main__":
    main()