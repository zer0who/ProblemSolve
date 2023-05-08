def main():
    N = int(input())
    pole = {}
    for _ in range(N):
        a, b = map(int, input().split())
        pole[a] = b
    pole = sorted(pole.items())
    pole_a = [pole[i][0] for i in range(len(pole))]
    pole_b = [pole[i][1] for i in range(len(pole))]
    ascending_in_b = [0 for _ in range(N)]
    for i in range(N):
        ascending_in_b[i] = 1
        for j in range(i):
            if pole_b[j] < pole_b[i]:
                ascending_in_b[i] = max(ascending_in_b[i], ascending_in_b[j] + 1)

    print(N - max(ascending_in_b))
            

if __name__ == "__main__":
    main()