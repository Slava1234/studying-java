package patterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

public class DynamicProxy {
    public static void run() {
        InvocationHandler handler = new MyProxy(new Integer(5));

        Class[] interfaces = new Class[]{Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null, interfaces, handler);
        //proxy.getClass();

        // При вызове compareTo() мы попадаем в invoke()
        ((Comparable)proxy).compareTo(3);

    }

    static class MyProxy implements InvocationHandler {
        Object targer;

        public MyProxy(Object targer) {
            this.targer = targer;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(args.toString());
            // original method compareTo()
            return method.invoke(targer, args);
        }
    }
}
