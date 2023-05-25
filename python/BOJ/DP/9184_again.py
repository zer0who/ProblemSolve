def w(a, b, c):
    if a<=0 or b<=0 or c<=0:
        return 1
    if a>20 or b>20 or c>20:
        return w(20, 20, 20)
    if w_list[a][b][c] != 0:
        return w_list[a][b][c]
    
    if a<b and b<c:
        w_list[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    else:
        w_list[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    
    return w_list[a][b][c]


def main():
    global w_list
    w_list = [[[0 for _ in range(51)] for _ in range(51)] for _ in range(51)]
    # w_list = list([[[0]*51]*51]*51) # -> 복사임. 그래서 이렇게하면 안됨.

    while True:
        a, b, c = map(int, input().split())
        if a == -1 and b == -1 and c == -1:
            return
        print(f"w({a}, {b}, {c}) =", w(a, b, c))

        
if __name__ == "__main__":
    main()