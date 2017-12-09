package pattern.visitor;

/**
 * Created by david100gom on 2017. 12. 3.
 *
 * Github : https://github.com/david100gom
 */
public class Shopper implements Visitor {

    @Override
    public void visit(Cart cart) {
        System.out.println("## Shopper Class : Cart ##");
    }

    @Override
    public void visit(Milk milk) {
        System.out.println("## Shopper Class : Milk ##");
    }

    @Override
    public void visit(Fruits fruits) {
        System.out.println("## Shopper Class : Fruits ##");
    }
}
