def solution(skill, skill_trees):
    answer = 0
    len_skill = len(skill)
    
    for skill_tree in skill_trees:
        flag = True
        skill_queue = []    #FIFO
        for i in range(len(skill)):
            skill_queue.append(skill[i])
            
        for i in range(len(skill_tree)):
            if skill_tree[i] in skill_queue and skill_tree[i] != skill_queue[0]:
                flag = False
                break
            elif skill_tree[i] == skill_queue[0]:
                skill_queue.pop(0)
            if len(skill_queue) == 0:
                break
                
        if flag:
            answer += 1
        
        
            
    return answer
def sample():
    sample = ["a", "b", "c", "D", "e"]
    flag = True
    for i in range(len(sample)):
        if sample[i].isupper():
            flag = False
            break

    if flag:
        print("모두 소문자")
    else:
        print("대문자 포함")