class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
    
    # Initialize the arrays for max_left, min_left, and max_right
        max_left = [0] * n
        min_left = [0] * n
        max_right = [0] * n
    
    # Compute max_left and min_left
        max_left[0] = nums[0]
        min_left[0] = nums[0]
        for i in range(1, n):
            max_left[i] = max(max_left[i - 1], nums[i])
            min_left[i] = min(min_left[i - 1], nums[i])
    
    # Compute max_right
        max_right[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            max_right[i] = max(max_right[i + 1], nums[i])
    
    # Now iterate over j (1 <= j <= n-2) to compute the triplet values
        max_value = 0
        for j in range(1, n - 1):
            left_max = max_left[j - 1]
            left_min = min_left[j - 1]
            right_max = max_right[j + 1]
        
        # Compute the two possible triplet values
            value1 = (left_max - nums[j]) * right_max
            value2 = (left_min - nums[j]) * right_max
        
        # Update the maximum value
            max_value = max(max_value, value1, value2)
    
        return max_value if max_value > 0 else 0
