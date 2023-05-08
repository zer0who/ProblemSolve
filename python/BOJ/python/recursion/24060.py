global c, res
c = 0
res = -1
def merge_sort(Array, p, r, K):
    if (p < r):
        q = (p + r) // 2
        merge_sort(Array, p, q, K)
        merge_sort(Array, q+1, r, K)
        merge(Array, p, q, r, K)
        
def merge(Array, p, q, r, K):
    global c, res
    tmp = []
    i = p
    j = q + 1
    t = 0
    while(i<=q and j<=r):
        if (Array[i] <= Array[j]):
            tmp.insert(t, Array[i])
            t += 1
            i += 1
        else:
            tmp.insert(t, Array[j])
            t += 1
            j += 1
    while(i <= q):
        tmp.insert(t, Array[i])
        t += 1
        i += 1
    while(j <= r):
        tmp.insert(t, Array[j])
        t += 1
        j += 1
    i = p
    t = 0
    while (i <= r):
        Array[i] = tmp[t]
        c += 1
        if c == K :
            res = Array[i]
        i += 1
        t += 1


def main():
    A_size, K = map(int, input().split())
    A = [*map(int, input().split())]
    merge_sort(A, 0, A_size-1, K)
    print(res)


main()