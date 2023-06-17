def main():
    n = int(input())
    numbers = list(map(int, input().split()))
    reverse_numbers = numbers[::-1]
    asc = [1 for _ in range(n)]
    desc = [1 for _ in range(n)]
    for i in range(n):
        for j in range(i):
            if numbers[i] > numbers[j]:
                asc[i] = max(asc[i], asc[j]+1)
            if reverse_numbers[i] > reverse_numbers[j]:
                desc[i] = max(desc[i], desc[j]+1)
    ans = [asc[i] + desc[::-1][i] for i in range(n)]
    print(max(ans)-1)


if __name__ == "__main__":
    main()