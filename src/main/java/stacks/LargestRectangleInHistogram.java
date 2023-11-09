package stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        // previous smaller
        int[] left = new int[n];
        for ( int i=0; i<n; i++ ) {

            while ( !stack.isEmpty() && heights[stack.peek()] >= heights[i] )
                stack.pop();

            if ( stack.isEmpty() )
                left[i] = -1;
            else
                left[i] = stack.peek();

            stack.push(i);
        }
        stack.clear();
        // next smaller
        int[] right = new int[n];
        for (int i=n-1; i>=0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();

            if (stack.isEmpty())
                right[i] = n;
            else
                right[i] = stack.peek();

            stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++)
            max = Math.max(max, (right[i]-left[i]-1)*heights[i]);

        System.out.println("largest area: " + max);
    }
}
