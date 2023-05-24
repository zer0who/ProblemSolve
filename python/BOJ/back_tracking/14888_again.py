def calc(numbers, idx, num):
    global greatest, smallest

    if sum(calculator) == 0:
        smallest = min(smallest, num)
        greatest = max(greatest, num)
    
    if calculator[0] != 0:
        calculator[0] -= 1
        calc(numbers, idx+1, num + numbers[idx+1])
        calculator[0] += 1
    if calculator[1] != 0:
        calculator[1] -= 1
        calc(numbers, idx+1, num - numbers[idx+1])
        calculator[1] += 1
    if calculator[2] != 0:
        calculator[2] -= 1
        calc(numbers, idx+1, num * numbers[idx+1])
        calculator[2] += 1
    if calculator[3] != 0:
        calculator[3] -= 1
        calc(numbers, idx+1, int(num / numbers[idx+1]))
        calculator[3] += 1


def main():
    global smallest, greatest, calculator
    smallest = 1000000000
    greatest = -1000000000

    N = int(input())
    numbers = list(map(int, input().split()))
    calculator = list(map(int, input().split()))
    calc(numbers, 0, numbers[0])
    
    print(greatest)
    print(smallest)


if __name__ == "__main__":
    main()