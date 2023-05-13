def main():
    N = int(input())
    # answer = 4
    # for _ in range(N):
    #     sqrt_answer = int(answer**0.5)
    #     answer = sqrt_answer**2 + 2*(sqrt_answer*(sqrt_answer-1)) + (sqrt_answer-1)**2
    # print(answer)
    first = 2
    for i in range(N):
        first += 2**i
    print(first**2)

if __name__ == "__main__":
    main()