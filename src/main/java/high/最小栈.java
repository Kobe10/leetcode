package high;

import java.util.Stack;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @Desc
 * @date Created in 2021年03月29日 16:34
 * @since 1.0
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 */
public class 最小栈 {
    Stack<Integer> normal = null;
    Stack<Integer> min = null;
    /** initialize your data structure here. */
    public 最小栈() {
        normal = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        // 比较当前元素
        normal.push(val);
        if (min.isEmpty()) {
            min.push(val);
        } else {
            min.push(Math.min(val, min.peek()));
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
