package hu.resanbt.visualparadigm.scripting.common.reflection;

import org.apache.commons.beanutils.BeanUtils;

public class Bean {

    private final Object obj;

    public static Bean of(Object obj) {
        return new Bean(obj);
    }

    private Bean(Object obj) {
        this.obj = obj;
    }

    public Object property(String key) {
        try {
            return BeanUtils.getProperty(obj, key);
        } catch (Exception e) {
            return null;
        }
    }

    public Object propertyOrEmptyString(String key) {
        Object retValue = property(key);
        return retValue == null ? "" : retValue;
    }

    public String propertyAsString(String key) {
        return propertyOrEmptyString(key).toString();
    }

}
