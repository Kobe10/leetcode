package sharding;

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
 * @date Created in 2021年01月17日 13:39
 * @since 1.0
 */
public class ShardingHash {
    /**
     * 字符串 hashCode 方法
     */
    public static void generalHash() {
        System.out.println("付志强".hashCode());
        System.out.println("付志强".hashCode() % 16);
        System.out.println("张三".hashCode());
        System.out.println("张三".hashCode() % 16);
        System.out.println("李四".hashCode());
        System.out.println("李四".hashCode() % 16);
        System.out.println("王五".hashCode());
        System.out.println("王五".hashCode() % 16);
    }


    /**
     * 《不可以修改》
     * 计算Hash值, 使用FNV1_32_HASH算法
     *
     * @param str
     * @return
     */
    public static int fnv1_32_hash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args) {
        generalHash();

        // fnv1_32_hash
        System.out.println(fnv1_32_hash("付志强") % 16);
        System.out.println(fnv1_32_hash("张三") % 16);
        System.out.println(fnv1_32_hash("李四") % 16);
        System.out.println(fnv1_32_hash("王五") % 16);
    }
}