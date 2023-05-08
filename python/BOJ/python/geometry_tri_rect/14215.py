def main():
    sides = sorted(list(map(int, input().split())))
    if sides[2] >= sides[0] + sides[1]:
        print(2*(sides[0] + sides[1]) - 1)
        return
    print(sum(sides))


if __name__ == "__main__":
    main()