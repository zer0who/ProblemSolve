def main():
    n = int(input())
    triangle = []
    for _ in range(n):
        triangle.append(list(map(int, input().split())))
    
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if j == 0:  # 행의 첫 번째 수일 경우
                triangle[i][j] = triangle[i][j]+triangle[i-1][j]
            elif j == len(triangle[i])-1:   # 행의 마지막 수일 경우
                triangle[i][j] = triangle[i][j]+triangle[i-1][j-1]
            else:   # 나머지일 경우
                triangle[i][j] = max(triangle[i][j]+triangle[i-1][j-1], triangle[i][j]+triangle[i-1][j])
    
    print(max(triangle[n-1]))


if __name__ == "__main__":
    main()