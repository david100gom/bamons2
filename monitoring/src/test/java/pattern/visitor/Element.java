package pattern.visitor;

/**
 * Created by david100gom on 2017. 12. 3.
 *
 * Github : https://github.com/david100gom
 *
 *
 *
 */
public interface Element {
    public void accept(Visitor visitor);
}
