package 高频题;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * <p></p>
 * <p> 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月16日 9:39 上午
 * @since 1.0
 */
public class 字母异位词分组 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 字符串排序
        // hashmap存储对应字符  key --> 排序后的字符串   value  --> list<string>
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            // 对字符串进行排序
            Arrays.sort(chars);
            // 排序之后与key进行比较
            String str1 = new String(chars);
            List<String> r = map.getOrDefault(str1, new ArrayList<>());
            r.add(str);
            map.put(str1, r);
        }
        List<List<String>> result = new ArrayList<>();
        map.forEach((key, value) -> {
            result.add(value);
        });
        return result;
    }

    public static void main(String[] args) {
        String[] str1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> l = groupAnagrams(str1);
        System.out.println(l);
    }
}