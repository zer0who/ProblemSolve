def counter(num, num_for_count):
    count = 0
    while num != 0:
        num = num // num_for_count
        count += num
    
    return count


def main():
    n, m = map(int, input().split())
    zeroes = min(counter(n, 5) - (counter(n-m, 5) + counter(m, 5)), counter(n, 2) - (counter(n-m, 2) + counter(m, 2)))
    print(zeroes)


if __name__ == "__main__":
    main()
