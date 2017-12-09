package pattern.visitor;

/**
 * Created by david100gom on 2017. 12. 3.
 *
 * Github : https://github.com/david100gom
 */
public class Milk implements Element{

    @Override
    public void accept(Visitor visitor) {
        System.out.println("## Milk Class ##");
        visitor.visit(this);
    }
}
