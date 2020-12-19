# Find keys by value in the Map

Lets you find keys by value in collections with a HashMap, TreeMap, or LinkedHashMap structure

You can find: 
- one first key
- a specified number of keys
- all keys by value 

### Methods

##### K getFirstKeyByValue(V value)
##### K getFirstKeyByValue(V value, ReturnType returnType)

Returns a single K type key that matches the value

If the key is not found, by default the method returns null 

To throw an exception, specify ReturnType.EXCEPTION as the second parameter

<br/>

##### List<K> getKeysByValue(V value, int maxKeysCount)
##### List<K> getKeysByValue(V value, int maxKeysCount, ReturnType returnType)

Returns a list of <K> type keys that match the value

The number of keys is limited by the second parameter of the method

If no keys are found, by default the method returns an empty list

If you need to throw an exception, specify ReturnType.EXCEPTION as the third parameter

<br/>

##### List<K> getAllKeysByValue(V value)
##### List<K> getAllKeysByValue(V value, ReturnType returnType)

Returns a list of all the <K> type keys that match the value

If no keys are found, by default the method returns an empty list

If you need to throw an exception, specify ReturnType.EXCEPTION as the second parameter

### Example

Get one first key by value from ExtHashmap:
    
    ExtMap<String, Integer> extHashMap = new ExtHashMap<>();
    String key = extHashMap.getFirstKeyByValue("value");
    String key = extHashMap.getFirstKeyByValue("value", ReturnType.EXCEPTION);
    

Get list of maximum two  keys by value from ExtTreemap:
    
    ExtMap<Integer, Double> extTreeMap = new ExtTreeMap<>();
    List<Integer> keys = extTreeMap.getKeysByValue(1.0, 2);
    List<Integer> keys = extTreeMap.getKeysByValue(1.0, 2, ReturnType.EXCEPTION);
    

Get a list of all keys by value from ExtLinkedHashMap:
    
    ExtMap<Character, Float> extLinkedHashMap = new ExtLinkedHashMap<>();
    List<Character> keys = extLinkedHashMap.getAllKeysByValue(3.0f);
    List<Character> keys = extLinkedHashMap.getAllKeysByValue(6.0f, ReturnType.EXCEPTION);
    





