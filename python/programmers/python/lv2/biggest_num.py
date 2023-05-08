def solution(numbers):
    answer = ""
    stack = [((str(numbers[i])*3), len(str(numbers[i]))) for i in range(len(numbers))]
    temp_stack = []
    stack.sort(key = lambda x: x, reverse = True)
    for i in range(len(stack)):
        answer += stack[i][0][:stack[i][1]]
    if int(answer) == 0:
        answer = "0"

    return answer