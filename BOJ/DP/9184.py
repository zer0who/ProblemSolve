def w(a: int, b: int, c: int) -> int:
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    elif a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)
        
    if w_list[a][b][c] != 0:
        return w_list[a][b][c]

    if a < b and b < c:
        w_list[a][b][c] =  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    else:
        w_list[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    
    return w_list[a][b][c]


def main():
    global w_list

    w_list = [[[0 for _ in range(51)] for _ in range(51)] for _ in range(51)]
    while True:
        n1, n2, n3 = map(int, input().split())
        result = 0
        if n1 == -1 and n2 == -1 and n3 == -1:
            break
        result = w(n1, n2, n3)
        print("w({}, {}, {}) = {}".format(n1, n2, n3, result))

if __name__ == "__main__":
    main()