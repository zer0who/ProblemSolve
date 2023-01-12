def calcDistance(p1x, p1y, p2x, p2y):
    distance = ((p1x-p2x)**2 + (p1y-p2y)**2)**(1/2)
    return distance


T = int(input())
for tc in range(T):
    x1, y1, x2, y2 = map(int, input().split())
    departure = [x1, y1]
    destination = [x2, y2]
    
    n = int(input())
    planets = []
    have_to_pass = {"departure" : [], "destination" : []}
    for _ in range(n):
        planets.append([*map(int, input().split())])
    for p in planets:
        departure_planet_distance = calcDistance(departure[0], departure[1], p[0], p[1])
        destination_planet_distance = calcDistance(destination[0], destination[1], p[0], p[1])
        if departure_planet_distance < p[2]:
            have_to_pass["departure"].append(p)
        if destination_planet_distance < p[2]:
            have_to_pass["destination"].append(p)
    
    same_planet_count = 0
    for dep in have_to_pass["departure"]:
        for des in have_to_pass["destination"]:
            if dep == des:
                same_planet_count += 2
    
    print(len(have_to_pass["departure"]) + len(have_to_pass["destination"]) - same_planet_count)