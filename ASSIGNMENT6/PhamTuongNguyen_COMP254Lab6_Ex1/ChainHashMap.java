import java.util.ArrayList;
import java.util.Random;

/*
 * Map implementation using hash table with separate chaining.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ChainHashMap<K,V> extends AbstractHashMap<K,V> {
  // a fixed capacity array of UnsortedTableMap that serve as buckets
  private UnsortedTableMap<K,V>[] table;   // initialized within createTable

  // provide same constructors as base class
  /** Creates a hash table with capacity 11 and prime factor 109345121. */
  public ChainHashMap() { super(); }

  /** Creates a hash table with given capacity and prime factor 109345121. */
  public ChainHashMap(int cap) { super(cap); }

  /** Creates a hash table with the given capacity and prime factor. */
  public ChainHashMap(int cap, int p) { super(cap, p); }

  public ChainHashMap(int cap, int p, float maxLoadFactor) { super(cap, p, maxLoadFactor); }

  /** Creates an empty table having length equal to current capacity. */
  @Override
  @SuppressWarnings({"unchecked"})
  protected void createTable() {
    table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
  }

  /**
   * Returns value associated with key k in bucket with hash value h.
   * If no such entry exists, returns null.
   * @param h  the hash value of the relevant bucket
   * @param k  the key of interest
   * @return   associate value (or null, if no such entry)
   */
  @Override
  protected V bucketGet(int h, K k) {
    UnsortedTableMap<K,V> bucket = table[h];
    if (bucket == null) return null;
    return bucket.get(k);
  }

  /**
   * Associates key k with value v in bucket with hash value h, returning
   * the previously associated value, if any.
   * @param h  the hash value of the relevant bucket
   * @param k  the key of interest
   * @param v  the value to be associated
   * @return   previous value associated with k (or null, if no such entry)
   */
  @Override
  protected V bucketPut(int h, K k, V v) {
    UnsortedTableMap<K,V> bucket = table[h];
    if (bucket == null)
      bucket = table[h] = new UnsortedTableMap<>();
    int oldSize = bucket.size();
    V answer = bucket.put(k,v);
    n += (bucket.size() - oldSize);   // size may have increased
    return answer;
  }

  /**
   * Removes entry having key k from bucket with hash value h, returning
   * the previously associated value, if found.
   * @param h  the hash value of the relevant bucket
   * @param k  the key of interest
   * @return   previous value associated with k (or null, if no such entry)
   */
  @Override
  protected V bucketRemove(int h, K k) {
    UnsortedTableMap<K,V> bucket = table[h];
    if (bucket == null) return null;
    int oldSize = bucket.size();
    V answer = bucket.remove(k);
    n -= (oldSize - bucket.size());   // size may have decreased
    return answer;
  }

  /**
   * Returns an iterable collection of all key-value entries of the map.
   *
   * @return iterable collection of the map's entries
   */
  @Override
  public Iterable<Entry<K,V>> entrySet() {
    ArrayList<Entry<K,V>> buffer = new ArrayList<>();
    for (int h=0; h < capacity; h++)
      if (table[h] != null)
        for (Entry<K,V> entry : table[h].entrySet())
          buffer.add(entry);
    return buffer;
  }
  
  public static void main(String[] args) {
        Random random = new Random();

        int capacity = 1000;
        int prime = 7; 
        float[] loadFactors = {0f, 0.25f, 0.5f, 0.75f, 1f, 2f};

        // Perform tests for each load factor
        for (float loadFactor : loadFactors) {
            ChainHashMap<Integer, Integer> map = new ChainHashMap<>(capacity, prime, loadFactor);

            long startTime = System.nanoTime();
            for (int i = 0; i < capacity * loadFactor; i++) {
                map.put(random.nextInt(capacity), i);
            }
            long insertionTime = System.nanoTime() - startTime;


            startTime = System.nanoTime();
            for (int i = 0; i < capacity * loadFactor; i++) {
                map.get(random.nextInt(capacity));
            }
            long searchTime = System.nanoTime() - startTime;


            startTime = System.nanoTime();
            for (int i = 0; i < capacity * loadFactor; i++) {
                map.remove(random.nextInt(capacity));
            }
            long removalTime = System.nanoTime() - startTime;


            System.out.println("Load Factor: " + loadFactor);
            System.out.println("Insertion Time: " + insertionTime + " ns");
            System.out.println("Search Time: " + searchTime + " ns");
            System.out.println("Removal Time: " + removalTime + " ns");
            System.out.println();
        }
    }
}