def main():
    N = int(input())
    count_arr = [0] * 1000001
    count_arr[1] = 0
    count_arr[2] = 1
    count_arr[3] = 1
      
    for i in range(4, N+1):
        if i%3 == 0 and i%2 == 0:
            count_arr[i] = min(count_arr[i//3], count_arr[i//2], count_arr[i-1]) + 1
        elif i%3 == 0:
            count_arr[i] = min(count_arr[i//3], count_arr[i-1]) + 1
        elif i%2 == 0:
            count_arr[i] = min(count_arr[i//2], count_arr[i-1]) + 1
        elif i%3 != 0 and i%2 != 0:
            count_arr[i] = count_arr[i-1] + 1
    
    print(count_arr[N])


if __name__ == "__main__":
    main()