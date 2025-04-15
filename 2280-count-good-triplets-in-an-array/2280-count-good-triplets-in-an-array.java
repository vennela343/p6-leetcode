class Solution {
    class BIT {
        long[] tree;

        BIT(int size) {
            tree = new long[size + 2];
        }

        void update(int index, int value) {
            index += 1;  // 1-based index
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long query(int index) {
            index += 1;
            long result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Step 1: Map value to index in nums2
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        // Step 2: Transform nums1 to positions in nums2
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = pos2[nums1[i]];
        }

        // Step 3: Compute leftSmaller
        long[] leftSmaller = new long[n];
        BIT bit = new BIT(n);
        for (int i = 0; i < n; i++) {
            leftSmaller[i] = bit.query(transformed[i] - 1);
            bit.update(transformed[i], 1);
        }

        // Step 4: Compute rightGreater
        long[] rightGreater = new long[n];
        bit = new BIT(n);
        for (int i = n - 1; i >= 0; i--) {
            rightGreater[i] = bit.query(n - 1) - bit.query(transformed[i]);
            bit.update(transformed[i], 1);
        }

        // Step 5: Calculate total good triplets
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += leftSmaller[i] * rightGreater[i];
        }

        return count;
    }
}

  