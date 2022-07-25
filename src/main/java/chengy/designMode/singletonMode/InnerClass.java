package chengy.designMode.singletonMode;

/**
 * 内部类方式
 */
public class InnerClass {
    private static class SingletonHolder {
        private static final InnerClass INSTANCE = new InnerClass();
    }

    private InnerClass() {
    }

    public static InnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(InnerClass.getInstance().hashCode());
            }).start();
        }
    }
}

