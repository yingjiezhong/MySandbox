package bst;

import java.util.*;
import java.util.stream.IntStream;

public class CountOfSmallerNumbers {

    /**
     * in binary searching tree, make each node return the number of nodes on left child tree,
     *
     * the position in the tree means something
     *
     *
     *
     * @param node
     * @param L
     * @param R
     * @return
     */
    public static List<Integer> solution(int[] nums) {
        List<Integer> ret = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();
        int[] sub = nums;

        while (sub != null) {
            System.out.println("sub: " + Arrays.toString(sub));
            TreeNode root = BSTUtils.buildTree(sub);
//            BSTUtils.print(root);
            count(root, map);
            sub = findSubArray(sub);
        }

        for (int i : nums) {
            ret.add(map.get(i));
        }

        return ret;
    }

    private static int[] findSubArray(int[] nums) {
        int root = nums[0];
        int start = 0;
        int[] subArray = null;

        for (int i = 1; i<nums.length; i++) {
            if (nums[i] > root) {
                start = i;
                break;
            }
        }

        if (start > 0) {
           subArray = IntStream.range(start, nums.length)
                   .map(i -> nums[i])
                   .toArray();
        }
        return subArray;
    }

    private static int count(TreeNode node, Map<Integer, Integer> map) {

        int count = 0;

        if (null == node || node.val == -1) {
            return 0;
        }

        count = count(node.left, map);

        map.put(node.val, count);
        count++;

        count += count(node.right, map);

        return count;

    }


    public static void main(String[] argv) {

        int[] t = {5,2,6,1};
        System.out.println("result: " + solution(t));

        t = new int[] {5,2,6,1,4,9,7,3,8};
        System.out.println("result: " + solution(t));

    }

}
