def main():
    N = int(input())
    num_calc = [None] * (1000001)
    num_calc[1] = 0
    num_calc[2] = 1
    num_calc[3] = 1
    num_calc[4] = 2
    num_calc[5] = 3
    num_calc[6] = 2
    num_calc[7] = 3
    num_calc[8] = 3
    num_calc[9] = 2
    num_calc[10] = 3

    for i in range(11, N+1):
        if i%3 == 0 and i%2 == 0:
            num_calc[i] = min(num_calc[i//3], num_calc[i//2], num_calc[i-1]) + 1
        elif i%3 == 0:
            num_calc[i] = min(num_calc[i//3], num_calc[i-1]) + 1
        elif i%2 == 0:
            num_calc[i] = min(num_calc[i//2], num_calc[i-1]) + 1
        elif i%3 !=0 and i%2 != 0:
            num_calc[i] = num_calc[i-1] + 1
    
    print(num_calc[N])

if __name__ == "__main__":
    main()