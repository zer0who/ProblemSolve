K = int(input())    # 1, 2, 3, 4  동 서 남 북
sides = []
side_count = [0] * 5
for i in range(6):
    sides.append([*map(int, input().split())])
    side_count[sides[i][0]] += 1

width_dict = {"width" : 0, "index" : 0}
height_dict = {"height" : 0, "index" : 0}
for i in range(len(sides)):
    if sides[i][0] == 1 or sides[i][0] == 2:
        if sides[i][1] > width_dict["width"]:
            width_dict["width"] = sides[i][1]
            width_dict["index"] = i
    else:
        if sides[i][1] > height_dict["height"]:
            height_dict["height"] = sides[i][1]
            height_dict["index"] = i

try:
    small_rect_width = sides[height_dict["index"]+3][1]
except:
    small_rect_width = sides[height_dict["index"]+3-6][1]
try:
    small_rect_height = sides[width_dict["index"]+3][1]
except:
    small_rect_height = sides[width_dict["index"]+3-6][1]

small_rect = small_rect_height * small_rect_width

print(K * (width_dict["width"] * height_dict["height"] - small_rect))