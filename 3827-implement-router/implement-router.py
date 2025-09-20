from collections import defaultdict
import bisect

class Router:

    def __init__(self, memoryLimit: int):
        self.memory = memoryLimit
        self.router = deque()
        self.packets = set()
        self.dest_map = defaultdict(list)  # destination -> sorted list of timestamps
    
    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        if (source, destination, timestamp) not in self.packets:
            if len(self.router) == self.memory:
                old = self.router.popleft()
                self.packets.remove(old)
                # also remove from dest_map
                _, old_dest, old_time = old
                idx = bisect.bisect_left(self.dest_map[old_dest], old_time)
                if idx < len(self.dest_map[old_dest]) and self.dest_map[old_dest][idx] == old_time:
                    self.dest_map[old_dest].pop(idx)

            self.router.append((source, destination, timestamp))
            self.packets.add((source, destination, timestamp))
            bisect.insort(self.dest_map[destination], timestamp)  # keep sorted
            return True
        return False
    
    def forwardPacket(self) -> List[int]:
        if len(self.router) > 0:
            packet = self.router.popleft()
            self.packets.remove(packet)
            _, dest, timestamp = packet
            idx = bisect.bisect_left(self.dest_map[dest], timestamp)
            if idx < len(self.dest_map[dest]) and self.dest_map[dest][idx] == timestamp:
                self.dest_map[dest].pop(idx)
            return list(packet)
        else:
            return []

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        arr = self.dest_map[destination]
        left = bisect.bisect_left(arr, startTime)
        right = bisect.bisect_right(arr, endTime)
        return right - left


## BRUTE FORCE --> PASSES 742/751 test cases ##
# class Router:

#     def __init__(self, memoryLimit: int):
#         self.memory = memoryLimit
#         self.router = deque()
#         self.packets = set()

#     def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
#         if (source, destination, timestamp) not in self.packets:
#             if len(self.router) == self.memory:
#                 self.router.popleft()
#             self.router.append((source, destination, timestamp))
#             self.packets.add((source, destination, timestamp))
#             return True
#         return False

#     def forwardPacket(self) -> List[int]:
#         if len(self.router) > 0:
#             packet = self.router.popleft()
#             self.packets.remove(packet)
#             return list(packet)
#         else:
#             return []

#     def getCount(self, destination: int, startTime: int, endTime: int) -> int:
#         count_packets_in_range = 0
#         for i in range(len(self.router)):
#             _, dest, timestamp = self.router[i]
#             if startTime <= timestamp <= endTime and dest == destination:
#                  count_packets_in_range += 1
#         return count_packets_in_range


# Your Router object will be instantiated and called as such:
# obj = Router(memoryLimit)
# param_1 = obj.addPacket(source,destination,timestamp)
# param_2 = obj.forwardPacket()
# param_3 = obj.getCount(destination,startTime,endTime)