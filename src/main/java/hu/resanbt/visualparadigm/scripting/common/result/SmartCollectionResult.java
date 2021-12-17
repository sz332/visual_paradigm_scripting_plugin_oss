package hu.resanbt.visualparadigm.scripting.common.result;

import com.vp.plugin.model.IModelElement;

import java.util.Arrays;
import java.util.Collection;

public class SmartCollectionResult {

    private final Collection<IModelElement> collection;

    public SmartCollectionResult(Collection<IModelElement> collection) {
        this.collection = collection;
    }

    public SmartCollectionResult(IModelElement[] array) {
        this.collection = Arrays.asList(array);
    }

    public Collection<IModelElement> getCollection() {
        return collection;
    }
}
