def solution(cacheSize, cities):
    answer = 0
    if cacheSize == 0:
        return len(cities) * 5
    cache_list = ["" for _ in range(cacheSize)]
    cache_index = [i for i in range(cacheSize)]
    for i in range(len(cities)):
        if cities[i].lower() not in cache_list:
            cache_list[cache_index[0]] = cities[i].lower()
            answer += 5
            idx = cache_index.pop(0)
            cache_index.append(idx)
        else:
            answer += 1
            idx = cache_list.index(cities[i].lower())
            cache_index.remove(idx)
            cache_index.append(idx)
    
    return answer