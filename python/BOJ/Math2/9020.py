p_arr = [0, 0] + [i for i in range(2, 10001)]
for i in range(2, 10001):
    if p_arr[i] != 0:
        for j in range(i+i, 10001, i):
            p_arr[j] = 0    #10000까지 소수만 있는 리스트 생성 완료

for i in range(int(input())):
    N = int(input())
    for j in range(N//2, 0, -1):
        if p_arr[j] != 0:
            if p_arr[N-j] != 0:
                print(j, N-j)
                break