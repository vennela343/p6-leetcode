class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
         NUM_ROWS = len(moveTime)
         NUM_COLS = len(moveTime[0])
         cache = [[inf] * NUM_COLS for _ in range(NUM_ROWS)]
         min_heap = []
         heappush(min_heap, (0, 0, 0))
         while len(min_heap) > 0:
            cost, row, col = heappop(min_heap)
            if row == NUM_ROWS-1 and col == NUM_COLS-1:
                continue
            
            for _row, _col in [[-1, 0], [1, 0], [0, 1], [0, -1]]:
                __row = _row + row
                __col = _col + col
                if __row < 0 or __col < 0 or __row == NUM_ROWS or __col == NUM_COLS:
                    continue
                
                new_cost = max(moveTime[__row][__col], cost) + 1
                if new_cost < cache[__row][__col]:
                    cache[__row][__col] = new_cost
                    heappush(min_heap, (new_cost, __row, __col))
         return cache[-1][-1]