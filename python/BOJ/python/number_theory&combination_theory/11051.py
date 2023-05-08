def main():
    N, K = map(int, input().split())
    factorial_N_K = 1
    factorial_K = 1

    if K == 0:
        combination1 = 1
    elif N == K:
        combination1 = 1
    else:
        for _ in range(K):
            factorial_N_K *= N
            N -= 1
            factorial_K *= K
            K -= 1
        combination1 = factorial_N_K / factorial_K
        combination2 = factorial_N_K // factorial_K
    
    print("/: ", combination1)
    print("//: ", combination2)
    print("/ modulo: ", combination1 % 10007)
    print("// modulo: ", combination2 % 10007)


if __name__ == "__main__":
    main()