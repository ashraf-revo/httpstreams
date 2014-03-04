package com.thunisoft.mediax.core.amf;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

class DynamicObject extends ArrayList<Entry> {

    /**   */
    private static final long serialVersionUID = 1L;

    public DynamicObject() {
        super();
    }

    public DynamicObject(int initialCapacity) {
        super(initialCapacity);
    }


    public DynamicObject(Map<String, Object> v) {
        for (java.util.Map.Entry<String, Object> e : v.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    public void put(String name, Object value) {
        add(new Entry(name, value));
    }

    public boolean getBoolean(String key) {
        return (Boolean) get(key, false);
    }

    public <T> T get(String key) {
        return get(key, null);
    }

    public <T> T get(String key, T defaultValue) {
        for (Entry entry : this) {
            String name = entry.getName();
            if (null != name && name.equals(key)) {
                return (T) entry.getValue();
            }
        }
    
        return defaultValue;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
    
        b.append("AMFArray {");
    
        int entryIndex = 0;
        for (Entry entry : this) {
            if (entryIndex > 0) {
                b.append(", ");
            }
    
            b.append(entry.getName());
            b.append(":");
    
            Object value = entry.getValue();
            if (null == value) {
                b.append("null");
            } else if (value instanceof String) {
                b.append("\"").append(value).append("\"");
            } else if (value instanceof Object[]) {
                b.append(Arrays.toString((Object[]) value));
            } else {
                b.append(value);
            }
    
            entryIndex += 1;
        }
        b.append("}");
    
        return b.toString();
    }

    public long getLong(String key) {
        return getNumber(key).longValue();
    }

    private Number getNumber(String key) {
        return (Number) get(key, 0L);
    }

    public double getDouble(String key) {
        return getNumber(key).doubleValue();
    }

    public int getInt(String key) {
        return getNumber(key).intValue();
    }

    public Timestamp getTimestamp(String key) {
        return get(key);
    }

    public String getString(String key) {
        return get(key);
    }

    public AMFObject getAMFObject(String key) {
        return get(key);
    }

    public AMFArray getAMFArray(String key) {
        return get(key);
    }

    public Object[] getArray(String key) {
        return get(key, new Object[0]);
    }

}
