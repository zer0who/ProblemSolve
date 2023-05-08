def hanoi(n, count, order, start, final, temp):
    if n == 1:
        count += 1
        order.append((start, final))
        return count, order
    
    count, order = hanoi(n-1, count, order, start, temp, final)
    count += 1
    order.append((start, final))
    count, order = hanoi(n-1, count, order, temp, final, start)

    return count, order



def main():
    K = int(input())
    order = []
    count = 0
    count, order = hanoi(K, count, order, 1, 3, 2)

    print(count)
    for o in order:
        print(o[0], o[1])


if __name__ == "__main__":
    main()