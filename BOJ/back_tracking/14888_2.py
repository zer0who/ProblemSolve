def backTracking(n:int, idx: int, numbers: list, num_operators: list, total: int) -> None:
    global greatest, smallest
    
    if idx == n-1:
        greatest = max(greatest, total)
        smallest = min(smallest, total)
        
        return
    
    if num_operators[0] != 0:
        num_operators[0] -= 1
        backTracking(n, idx+1, numbers, num_operators, total+numbers[idx+1])
        num_operators[0] += 1
    if num_operators[1] != 0:
        num_operators[1] -= 1
        backTracking(n, idx+1, numbers, num_operators, total-numbers[idx+1])
        num_operators[1] += 1
    if num_operators[2] != 0:
        num_operators[2] -= 1
        backTracking(n, idx+1, numbers, num_operators, total*numbers[idx+1])
        num_operators[2] += 1
    if num_operators[3] != 0:
        num_operators[3] -= 1
        backTracking(n, idx+1, numbers, num_operators, int(total/numbers[idx+1]))
        num_operators[3] += 1



def main():
    global greatest, smallest
    greatest = -1e9
    smallest = 1e9

    N = int(input())
    idx = 0
    numbers = list(map(int, input().split()))
    num_operators = list(map(int, input().split()))
    total = numbers[0]

    backTracking(N, idx, numbers, num_operators, total)
    print(greatest)
    print(smallest)


if __name__ == "__main__":
    main()