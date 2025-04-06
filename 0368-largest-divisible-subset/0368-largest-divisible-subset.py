class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        from typing import List
        if not nums:
            return []
        nums.sort()
        n = len(nums)
        dp = [1] * n  
        previous = [-1] * n  
        
        max_size = 1 
        max_index = 0 

        for i in range(1, n):
            for j in range(i):
                if nums[i] % nums[j] == 0:  
                    if dp[i] < dp[j] + 1:
                        dp[i] = dp[j] + 1
                        previous[i] = j

            if dp[i] > max_size:
                max_size = dp[i]
                max_index = i
        result = []
        while max_index != -1:
            result.append(nums[max_index])
            max_index = previous[max_index]
        return result[::-1]


        