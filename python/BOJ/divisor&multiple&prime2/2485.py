def calcGCD(A, B):
    while B:
        A, B = B, A%B
    return A

def main():
    N = int(input())
    trees = []
    diff = []
    gcd = 1000000001
    answer = 0
    for i in range(N):
        trees.append(int(input()))
        if i != 0:
            diff.append(trees[i] - trees[i-1])
    for i in range(1, len(diff)):
        temp_gcd = calcGCD(diff[i], diff[i-1])
        if temp_gcd < gcd:
            gcd = temp_gcd
    for d in diff:
        answer += (int(d/gcd) - 1)

    print(answer)
    

if __name__ == "__main__":
    main()