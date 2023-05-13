def solution(record):
    answer = []
    user_nickname = {}
    user_mode = []
    for r in record:
        if r[:5] == "Leave":
            mode, user_id = r.split()
            user_mode.append((user_id, mode))
            
        else:
            mode, user_id, nickname = r.split()
            user_mode.append((user_id, mode))
            user_nickname[user_id] = nickname
        
    for i in range(len(user_mode)):
        if user_mode[i][1] == "Enter":
            answer.append(user_nickname[user_mode[i][0]] + "님이 들어왔습니다.")
        elif user_mode[i][1] == "Leave":
            answer.append(user_nickname[user_mode[i][0]] + "님이 나갔습니다.")
    
    return answer