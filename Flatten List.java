/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        List<Integer> rst = new ArrayList<Integer>();
        if (nestedList == null || nestedList.size() == 0) {
            return rst;
        }
        for (int i = nestedList.size() - 1; i >= 0; --i) {
            stack.push(nestedList.get(i));
        }
        while (!stack.isEmpty()) {
            NestedInteger top = stack.pop();
            if (top.isInteger()) {
                rst.add(top.getInteger());
            } else {
                List<NestedInteger> list = top.getList();
                for (int i = list.size() - 1; i >= 0; --i) {
                    stack.push(list.get(i));
                }
            }
        }
        return rst;
    }
}