def makeKantoer(kantoer: str, N: int) -> str:
    if N == 0:
        return kantoer
    kantoer = makeKantoer(kantoer[:3**N//3], N-1) + " " * (3**N//3) + makeKantoer(kantoer[2*((3**N)//3):], N-1)

    return kantoer

def main():
    while True:
        try:
            N = int(input())
            kantoer = "-"*(3**N)
            kantoer = makeKantoer(kantoer, N)
            print(kantoer)
        except Exception as e:
            return

if __name__ == "__main__":
    main()