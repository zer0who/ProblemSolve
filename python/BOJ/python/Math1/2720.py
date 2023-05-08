from decimal import Decimal

def main():
    wallet = ["0.25", "0.10", "0.05", "0.01"]
    T = int(input())
    for _ in range(T):
        answer = []
        cent = str(round(int(input()) / 100, 2))
        for i in range(len(wallet)):
            num = int(Decimal(cent) / Decimal(wallet[i]))
            answer.append(str(num))
            cent = str(Decimal(cent) - num * Decimal(wallet[i]))
        print(" ".join(answer))

if __name__ == "__main__":
    main()