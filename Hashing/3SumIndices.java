/*
Prob.: Find All Triplets with Zero Sum
Difficulty: MediumAccuracy: 50.36%Submissions: 44K+Points: 4
Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
Returned triplet should also be internally sorted i.e. i<j<k.
*/

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        
        Set<List<Integer>> result = new HashSet<>();
        int n = arr.length;
        Map<Integer, List<int[]>> sumMap = new HashMap<>();

        // Store all pairs with their indices in the HashMap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        // Iterate through the array to find triplets
        for (int i = 0; i < n; i++) {
            int target = -arr[i]; // Remaining value to make the sum zero
            if (sumMap.containsKey(target)) {
                List<int[]> pairs = sumMap.get(target);
                for (int[] pair : pairs) {
                    // Ensure the indices are distinct
                    if (pair[0] != i && pair[1] != i) {
                        // Add triplet to result set (to avoid duplicates)
                        List<Integer> triplet = Arrays.asList(i,pair[0],pair[1]);
                        Collections.sort(triplet); // Sort for deduplication
                        result.add(triplet);
                    }
                }
            }
        }
        // Convert the set of triplets to a list and return
        return new ArrayList<>(result);
    }
