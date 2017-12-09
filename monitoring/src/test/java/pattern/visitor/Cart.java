package pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david100gom on 2017. 12. 3.
 *
 * Github : https://github.com/david100gom
 */
public class Cart implements Element {

    List<Element> cart = new ArrayList<Element>();

    public Cart() {
        cart.add(new Fruits());
        cart.add(new Milk());
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("## Cart Clas ##");
        visitor.visit(this);

        for(Element element: cart) {
            element.accept(visitor);
        }
    }
}
