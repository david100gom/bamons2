package pattern.visitor;

/**
 * Created by david100gom on 2017. 12. 3.
 *
 * Github : https://github.com/david100gom
 *
 * 비지터 패턴은 보통 한 클래스내에 존재해야 할 데이터와 메소드를 다른 클래스로 분리하여 서로 간에 호출하도록 함으로써 향후 메소드 추가를 자유롭게 하려는 패턴임
 * 즉 객체는 그대로 둔 채 객체에 대한 연산을 분리함
 *
 * http://techbard.tistory.com/2869
 *
 */
public class VisitorPattenTest {

    public static void main(String[] args) {

        Shopper shopper = new Shopper();

        //Cart cart = new Cart();
        Fruits fruits = new Fruits();
        Milk milk = new Milk();


        //cart.accept(shopper);
        fruits.accept(shopper);
        milk.accept(shopper);

    }
}
