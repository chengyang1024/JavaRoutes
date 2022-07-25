package chengy.designMode.factoryMode.simpleFactory;

public class SimpleFactpryTest {

    public static void main(String[] args) {
        //1。普通模式
        //new OrderPizza();

        //2。使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("~~退出程序~~");

        //3。
        new OrderPizza2();
    }
}
