import collections

def solution(bridge_length, weight, truck_weights):
    time = 0
    cur_weight = 0
    bridge = collections.deque([])
    truck_weights = collections.deque(truck_weights)

    while(len(truck_weights)):
        if len(bridge) == bridge_length:
            truck = bridge.popleft()
            cur_weight -= truck
        if truck_weights[0] + cur_weight <= weight:
            truck = truck_weights.popleft()
            bridge.append(truck)
            cur_weight += truck
        else :
            bridge.append(0)
        time += 1
    return time + bridge_length