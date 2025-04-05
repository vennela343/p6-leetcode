class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        n = len(nums)
        total = 0
        for i in range(1 << n):
            xor_sum = 0
            for j in range(n):
                if i & (1 << j): 
                    xor_sum ^= nums[j]
            total += xor_sum
        return total

        