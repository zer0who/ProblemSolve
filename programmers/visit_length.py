def solution(dirs):
    answer = 0
    axis = [0,0]
    visited = []
    for i in range(len(dirs)):
        before_move = axis.copy()
        if axis[1] < 5 and dirs[i] == "U":
            axis[1] += 1
        elif axis[1] > -5 and dirs[i] == "D":
            axis[1] -= 1
        elif axis[0] > -5 and dirs[i] == "L":
            axis[0] -= 1
        elif axis[0] < 5 and dirs[i] == "R":
            axis[0] += 1
        else:
            continue
        move = [before_move, axis.copy()]

        if move not in visited and list(reversed(move)) not in visited:
            answer += 1
            visited.append(move)
            
    return answer