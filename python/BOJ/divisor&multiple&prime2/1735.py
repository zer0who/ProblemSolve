def calcGCD(A, B):
    while B:
        A, B = B, A%B
    return A

def calcLCM(A, B):
    return (A * B) // calcGCD(A,B)

def main():
    A1, A2 = map(int, input().split())
    B1, B2 = map(int, input().split())
    lcm = calcLCM(A2, B2)
    son = A1*(lcm//A2) + B1*(lcm//B2)
    gcd = calcGCD(lcm, son)
    print((son//gcd), (lcm//gcd))


if __name__ == "__main__":
    main()