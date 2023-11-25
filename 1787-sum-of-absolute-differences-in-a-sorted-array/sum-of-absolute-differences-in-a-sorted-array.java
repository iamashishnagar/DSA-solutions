class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        // Initialize the total sum of all elements
        int totalSum = Arrays.stream(nums).sum();

        // Initialize the sum of elements to the left
        int leftSum = 0;

        // Initialize the sum of elements to the right
        int rightSum = totalSum;

        // Create an array to store the sum of absolute differences for each element
        int[] absoluteDifferences = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            // Get the current element
            int currentElement = nums[i];

            // Update the sum of elements to the right
            rightSum -= currentElement;

            // Calculate the sum of absolute differences for the current element
            absoluteDifferences[i] = (currentElement * i - leftSum) + rightSum - (currentElement * (nums.length - i - 1));

            // Update the sum of elements to the left
            leftSum += currentElement;
        }

        return absoluteDifferences;
    }
}
