package pattern.visitor;

/**
 * Created by david100gom on 2017. 12. 3.
 *
 * Github : https://github.com/david100gom
 */
public interface Visitor {

    public void visit(Cart cart);
    public void visit(Milk milk);
    public void visit(Fruits fruits);

}