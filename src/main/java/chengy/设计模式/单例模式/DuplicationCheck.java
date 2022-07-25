package chengy.设计模式.单例模式;

/**
 * 双重检查
 */
public class DuplicationCheck {
    /**
     * volatile的作用：将对象申明为volatile，不然会因为指令重排序导致在第一个判空时将未初始化的对象返回
     * 指令重排优化，可能会导致初始化单利对象和将该对象地址赋值给instance字段的顺序与Java代码中书写的顺序不同。
     * 例如：线程A在创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象设置为默认值。此时线程A就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有完成初始化操作。
     * 线程B来调用newInstance()方法，得到的就是未初始化完全的单例对象，这就会导致系统出现异常行为。
     * 为了解决上述的问题，可以使用volatile关键字进行修饰instance字段。
     * volatile关键字在这里的含义就是禁止指令的重排序优化（另一个作用是提供内存可见性），从而保证instance字段被初始化时，单例对象已经被完全初始化。
     */
    private static volatile DuplicationCheck instance;

    private DuplicationCheck() {
    }

    public static DuplicationCheck getInstance() {
        if (instance == null) {
            synchronized (DuplicationCheck.class) {
                if (instance == null) {
                    instance = new DuplicationCheck();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(DuplicationCheck.getInstance().hashCode());
            }).start();
        }
    }
}
