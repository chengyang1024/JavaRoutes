package chengy.designMode.factoryMode.abstractFactory;

import chengy.designMode.factoryMode.abstractFactory.AbstractFactory;
import org.junit.Test;

public class AbstractFactoryTest {



    @Test
    public void Test1(){
        AbstractFactory abstractFactory = new AbstractFactory();
        food food = abstractFactory.ClientCode("FactoryForB");
        food.show();
    }

}
