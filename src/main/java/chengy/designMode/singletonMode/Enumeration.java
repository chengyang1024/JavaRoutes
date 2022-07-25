package chengy.designMode.singletonMode;

/**
 * 枚举类实现
 */
public enum Enumeration {

    INSTANCE;


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Enumeration.INSTANCE.hashCode());
            }).start();
        }
    }
}
