package javaee.jvm;

//内存模型，虚拟机结构
//强弱软虚引用
//内存泄漏：本质上是长期存活引用指向短期存活对象，导致短期存活对象占用的内存无法回收。

/**堆中对象结构：头部 mark word：偏向线程ID，存活时间，hashcode
               class word
               数组长度（可选）
                对象属性1
                对象属性2
                ...
                对齐字节
 */
/**
 * 无锁
 * 偏向锁
 * 轻量级锁CAS 自旋
 * 重量级锁    唤醒
* */
public class jvmTest {

}
