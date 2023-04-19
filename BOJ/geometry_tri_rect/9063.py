def main():
    n = int(input())
    x_arr = []
    y_arr = []
    for _ in range(n):
        x, y = map(int, input().split())
        x_arr.append(x)
        y_arr.append(y)
    min_x = min(x_arr)
    max_x = max(x_arr)
    min_y = min(y_arr)
    max_y = max(y_arr)
    print((max_x-min_x) * (max_y-min_y))

if __name__ == "__main__":
    main()