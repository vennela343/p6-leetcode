class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        from typing import List
        operations = 0
        while len(nums) > 0:
            if len(set(nums)) == len(nums):
                break  
            nums = nums[3:]
            operations += 1
        
        return operations
