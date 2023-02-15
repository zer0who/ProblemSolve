import math

def calcTime(out_time, in_time):
    hour = int(out_time[0:2]) - int(in_time[0:2])
    minute = int(out_time[3:]) - int(in_time[3:])
    if minute < 0:
        hour -= 1
        minute += 60
    total_minute = hour*60 + minute
    
    return total_minute
            
def calcFee(total_minute, fees):
    total_fee = 0
    if total_minute > fees[0]:
        total_minute -= fees[0]
        total_fee += fees[1]
        total_fee += (math.ceil(total_minute/fees[2])) * fees[3]
    else:
        total_fee += fees[1]
    return total_fee

def solution(fees, records):
    # fees = [기본 시간, 기본 요금, 단위시간, 단위시간당 금액]
    # records = ["시간 번호 입출", ...]
    answer = []
    car_fee = {}
    car_in_time = {}
    car_time_per_day = {}
    for r in records:
        car_num = r[6:10]
        if car_num not in car_in_time:  # 입차되지 않은 차인 경우
            car_in_time[car_num] = r[0:5]
        else:   # 입차된 차인 경우
            out_time = r[0:5]
            total_minute = calcTime(out_time, car_in_time[car_num])
            if car_num not in car_time_per_day:
                car_time_per_day[car_num] = total_minute
            else:
                car_time_per_day[car_num] += total_minute
            del car_in_time[car_num]
                                     
    for car_num in car_in_time.keys():
        out_time = "23:59"
        total_minute = calcTime(out_time, car_in_time[car_num])
        if car_num not in car_time_per_day:
            car_time_per_day[car_num] = total_minute
        else:
            car_time_per_day[car_num] += total_minute
        total_fee = calcFee(car_time_per_day[car_num], fees)
        
    for car_num in car_time_per_day.keys():
        total_fee = calcFee(car_time_per_day[car_num], fees)
        car_fee[car_num] = total_fee
    car_fee = sorted(car_fee.items())
    for car in car_fee:
        answer.append(car[1])
    
    return answer