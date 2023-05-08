def main():
    N = int(input())
    step_numbers = [[None for _ in range(10)] for _ in range(101)]
    step_numbers[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    if N == 1:
        print(sum(step_numbers[1]))
        return
    
    for i in range(2, N+1):
        for j in range(10):
            if j == 0:
                step_numbers[i][j] = step_numbers[i-1][j+1]
            elif j == 9:
                step_numbers[i][j] = step_numbers[i-1][j-1]
            else:
                step_numbers[i][j] = step_numbers[i-1][j-1] + step_numbers[i-1][j+1]


    print(sum(step_numbers[N]) % 1000000000)

if __name__ == "__main__":
    main()