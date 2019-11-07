package collactions;

/**
 * Created by amit on 20/12/18.
 */
public class CustomMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16
    private int size = 0;

    CustomMap() {
        this(INITIAL_CAPACITY);
    }

    CustomMap(int size) {
        this.buckets = new Entry[size];
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);
        int bucket = entry.hashCode() % INITIAL_CAPACITY;
        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    size++;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
                size++;
            } else {
                existing.next = entry;
            }
        }
    }

    public V get(K key) {
        Entry<K, V> entry = new Entry<>(key, null, null);
        Entry<K, V> bucket = buckets[entry.hashCode() % INITIAL_CAPACITY];
        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (Entry entry : buckets) {
            if (entry != null) {
                stringBuilder.append(entry.toString()).append(", ");
            }
        }
        return stringBuilder.append(" ]").toString();
    }
}

class Entry<K, V> {
    private static final int INITIAL_CAPACITY = 1 << 4; // 16
    final K key;
    V value;

    Entry<K, V> next;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public int hashCode() {
//        if (key instanceof String) {
//            return (int) ((String) key).charAt(0)% INITIAL_CAPACITY;
//        } else if (key instanceof Integer ) {
//            return ((Integer) key) % INITIAL_CAPACITY;
//        } else if (key instanceof Float) {
//            return  Math.round(((Float) key) % INITIAL_CAPACITY);
//        }
//        return INITIAL_CAPACITY -1;
        return key != null ? key.hashCode() : INITIAL_CAPACITY - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        Entry<?, ?> entry = (Entry<?, ?>) o;

        if (!key.equals(entry.key)) return false;
        return value.equals(entry.value);

    }

    @Override
    public String toString() {
        return key + " <=> " + value;
    }
    //    @Override
//    public boolean equals(Entry o) {
//        Entry<?, ?> entry = (Entry) o;
//        if(o == null) {
//            return false;
//        }
//        return this == o || (entry.key == this.key && entry.value == this.value);
//    }
}
