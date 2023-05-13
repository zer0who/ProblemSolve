import sys

def main():
    T = int(sys.stdin.readline().rstrip())
    for _ in range(T):
        p = sys.stdin.readline().rstrip()
        n = int(sys.stdin.readline().rstrip())
        numbers = list(sys.stdin.readline().rstrip()[1:-1].split(","))
        answer = ["["]
        reverse_count = 0
        error_flag = False
        for i in range(len(p)):
            if p[i] == "R":
                reverse_count += 1
                continue
            if not numbers or n == 0:
                print("error")
                error_flag = True
                break
            else:
                if reverse_count % 2 == 0:
                    numbers.pop(0)
                    continue
                numbers.pop(-1)
        if error_flag == False:
            if reverse_count % 2 != 0:
                    numbers.reverse()
            for n in numbers:
                answer.append(n)
                answer.append(",")
            if numbers:
                answer.pop(-1)
            answer.append("]")
            print("".join(answer))
            continue


if __name__ == "__main__":
    main()