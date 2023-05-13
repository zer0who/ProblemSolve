def main():
    while True:
        a, b, c = map(int, input().split())
        if a == 0:
            return
        points = sorted([a, b, c])
        longest = points.pop(2)
        if longest >= sum(points):
            print("Invalid")
            continue

        if a == b and b == c:
            print("Equilateral")
        elif a != b and b != c and c != a:
            print("Scalene")
        else:
            print("Isosceles")

if __name__ == "__main__":
    main()