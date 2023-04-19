def main():
    while True:
        num = int(input())
        if num == -1:
            break
        divisor = []
        for i in range(1, num):
            if num % i == 0:
                divisor.append(i)
        if sum(divisor) == num:
            print(num, "= ", end = "")
            for i in range(len(divisor)):
                if i == len(divisor)-1:
                    print(divisor[i])
                    break
                print(divisor[i], "+ ", end = "")
        else:
            print(num, "is NOT perfect.")

if __name__ == "__main__":
    main()