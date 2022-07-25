package chengy.designMode.factoryMode.abstractFactory;

interface food {
    void show();
}

class A implements food {
    public A() {
        System.out.println("A被new出来");
    }


    public void show() {
        System.out.println("A类的show");
    }
}

class B implements food {
    public B() {
        System.out.println("B被new出来");
    }

    public void show() {
        System.out.println("B类的show");
    }
}

interface produce {
    food get();
}

class FactoryForA implements produce {
    @Override
    public food get() {
        return new A();
    }
}

class FactoryForB implements produce {
    @Override
    public food get() {
        return new B();
    }
}

public class AbstractFactory {
    public food ClientCode(String name) {
        food x;
        if (name.equals("FactoryForA")) {
            x = new FactoryForA().get();
        } else if (name.equals("FactoryForB")) {
            x = new FactoryForB().get();
        } else {
            System.out.println("类名错误");
            return null;
        }
        return x;
    }
}
