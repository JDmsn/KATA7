package kata7.view;

import kata7.model.Attribute;
import java.util.List;
import kata7.model.Histogram;

public class HistogramBuilder<T> {
    private final List<T> array;

    public HistogramBuilder(List<T> array) {
        this.array = array;
    }

    public <A> Histogram<A> build(Attribute<T, A> attribute) {
        Histogram<A> hm = new Histogram<>();
        for (T item : array) {
            hm.increment(attribute.get(item));
        }
        return hm;
    }
}
