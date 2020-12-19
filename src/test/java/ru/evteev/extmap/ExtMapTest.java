package ru.evteev.extmap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.evteev.extmap.enums.ReturnType;
import ru.evteev.extmap.impl.ExtHashMap;
import ru.evteev.extmap.impl.ExtLinkedHashMap;
import ru.evteev.extmap.impl.ExtTreeMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class ExtMapTest {
    private ExtMap<String, String> extHashMap;
    private ExtMap<Integer, Double> extTreeMap;
    private ExtMap<Character, Float> extLinkedHashMap;

    @Before
    public void setUp() {
        extHashMap = new ExtHashMap<>();

        extHashMap.put("k1", "v1");
        extHashMap.put("k2", "v2");
        extHashMap.put("k3", "v3");
        extHashMap.put("k4", "v3");
        extHashMap.put("k5", "v3");

        extTreeMap = new ExtTreeMap<>();
        
        extTreeMap.put(1, 1.1);
        extTreeMap.put(2, 2.2);
        extTreeMap.put(3, 3.3);
        extTreeMap.put(4, 3.3);
        extTreeMap.put(5, 3.3);

        extLinkedHashMap = new ExtLinkedHashMap<>();
        
        extLinkedHashMap.put('a', 1.0f);
        extLinkedHashMap.put('b', 2.0f);
        extLinkedHashMap.put('c', 3.0f);
        extLinkedHashMap.put('d', 3.0f);
        extLinkedHashMap.put('e', 3.0f);
    }

    // EXT HASHMAP

    // Get one key

    @Test
    public void getKeyByValueFromExtHashMapTest1() {
        String actual = extHashMap.getFirstKeyByValue("v1");
        String expected = "k1";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtHashMapTest2() {
        String actual = extHashMap.getFirstKeyByValue("v1", ReturnType.EXCEPTION);
        String expected = "k1";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtHashMapTest3() {
        String actual = extHashMap.getFirstKeyByValue("v3");
        String expected = "k3";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtHashMapTest4() {
        String actual = extHashMap.getFirstKeyByValue("v3", ReturnType.EXCEPTION);
        String expected = "k3";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtHashMapTest5() {
        String actual = extHashMap.getFirstKeyByValue("v6");
        Assert.assertNull(actual);
    }

    @Test
    public void getKeyByValueFromExtHashMapTest6() {
        Assert.assertThrows("No keys for value: v6", NoSuchElementException.class,
                () -> extHashMap.getFirstKeyByValue("v6", ReturnType.EXCEPTION));
    }

    // Get several keys

    @Test
    public void getKeysByValueFromExtHashMapTest1() {
        List<String> actual = extHashMap.getKeysByValue("v1", 1);
        List<String> expected = Collections.singletonList("k1");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest2() {
        List<String> actual = extHashMap.getKeysByValue("v1", 1, ReturnType.EXCEPTION);
        List<String> expected = Collections.singletonList("k1");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest3() {
        List<String> actual = extHashMap.getKeysByValue("v1", 2);
        List<String> expected = Collections.singletonList("k1");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest4() {
        List<String> actual = extHashMap.getKeysByValue("v1", 2, ReturnType.EXCEPTION);
        List<String> expected = Collections.singletonList("k1");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest5() {
        List<String> actual = extHashMap.getKeysByValue("v3", 1);
        List<String> expected = Collections.singletonList("k3");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest6() {
        List<String> actual = extHashMap.getKeysByValue("v3", 1, ReturnType.EXCEPTION);
        List<String> expected = Collections.singletonList("k3");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest7() {
        List<String> actual = extHashMap.getKeysByValue("v3", 2);
        List<String> expected = Arrays.asList("k3", "k4");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest8() {
        List<String> actual = extHashMap.getKeysByValue("v3", 2, ReturnType.EXCEPTION);
        List<String> expected = Arrays.asList("k3", "k4");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest9() {
        List<String> actual = extHashMap.getKeysByValue("v3", 3);
        List<String> expected = Arrays.asList("k3", "k4", "k5");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest10() {
        List<String> actual = extHashMap.getKeysByValue("v3", 3, ReturnType.EXCEPTION);
        List<String> expected = Arrays.asList("k3", "k4", "k5");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest11() {
        List<String> actual = extHashMap.getKeysByValue("v6", 2);
        List<String> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtHashMapTest12() {
        Assert.assertThrows("No keys for value: v6", NoSuchElementException.class,
                () -> extHashMap.getKeysByValue("v6", 2, ReturnType.EXCEPTION));
    }

// Get all keys

    @Test
    public void getAllKeysByValueFromExtHashMapTest1() {
        List<String> actual = extHashMap.getAllKeysByValue("v1");
        List<String> expected = Collections.singletonList("k1");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtHashMapTest2() {
        List<String> actual = extHashMap.getAllKeysByValue("v1", ReturnType.EXCEPTION);
        List<String> expected = Collections.singletonList("k1");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtHashMapTest3() {
        List<String> actual = extHashMap.getAllKeysByValue("v3");
        List<String> expected = Arrays.asList("k3", "k4", "k5");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtHashMapTest4() {
        List<String> actual = extHashMap.getAllKeysByValue("v3", ReturnType.EXCEPTION);
        List<String> expected = Arrays.asList("k3", "k4", "k5");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtHashMapTest5() {
        List<String> actual = extHashMap.getAllKeysByValue("v6");
        List<String> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtHashMapTest6() {
        String value = "v6";
        Assert.assertThrows("No keys for value: " + value, NoSuchElementException.class,
                () -> extHashMap.getAllKeysByValue(value, ReturnType.EXCEPTION));
    }

    // EXT TREEMAP

    // Get one key

    @Test
    public void getKeyByValueFromExtTreeMapTest1() {
        Integer actual = extTreeMap.getFirstKeyByValue(1.1);
        Integer expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtTreeMapTest2() {
        Integer actual = extTreeMap.getFirstKeyByValue(1.1, ReturnType.EXCEPTION);
        Integer expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtTreeMapTest3() {
        Integer actual = extTreeMap.getFirstKeyByValue(3.3);
        Integer expected = 3;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtTreeMapTest4() {
        Integer actual = extTreeMap.getFirstKeyByValue(3.3, ReturnType.EXCEPTION);
        Integer expected = 3;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtTreeMapTest5() {
        Integer actual = extTreeMap.getFirstKeyByValue(6.6);
        Assert.assertNull(actual);
    }

    @Test
    public void getKeyByValueFromExtTreeMapTest6() {
        Assert.assertThrows("No keys for value: v6", NoSuchElementException.class,
                () -> extTreeMap.getFirstKeyByValue(6.6, ReturnType.EXCEPTION));
    }

    // Get several keys

    @Test
    public void getKeysByValueFromExtTreeMapTest1() {
        List<Integer> actual = extTreeMap.getKeysByValue(1.1, 1);
        List<Integer> expected = Collections.singletonList(1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest2() {
        List<Integer> actual = extTreeMap.getKeysByValue(1.1, 1, ReturnType.EXCEPTION);
        List<Integer> expected = Collections.singletonList(1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest3() {
        List<Integer> actual = extTreeMap.getKeysByValue(1.1, 2);
        List<Integer> expected = Collections.singletonList(1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest4() {
        List<Integer> actual = extTreeMap.getKeysByValue(1.1, 2, ReturnType.EXCEPTION);
        List<Integer> expected = Collections.singletonList(1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest5() {
        List<Integer> actual = extTreeMap.getKeysByValue(3.3, 1);
        List<Integer> expected = Collections.singletonList(3);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest6() {
        List<Integer> actual = extTreeMap.getKeysByValue(3.3, 1, ReturnType.EXCEPTION);
        List<Integer> expected = Collections.singletonList(3);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest7() {
        List<Integer> actual = extTreeMap.getKeysByValue(3.3, 2);
        List<Integer> expected = Arrays.asList(3, 4);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest8() {
        List<Integer> actual = extTreeMap.getKeysByValue(3.3, 2, ReturnType.EXCEPTION);
        List<Integer> expected = Arrays.asList(3, 4);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest9() {
        List<Integer> actual = extTreeMap.getKeysByValue(3.3, 3);
        List<Integer> expected = Arrays.asList(3, 4, 5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest10() {
        List<Integer> actual = extTreeMap.getKeysByValue(3.3, 3, ReturnType.EXCEPTION);
        List<Integer> expected = Arrays.asList(3, 4, 5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest11() {
        List<Integer> actual = extTreeMap.getKeysByValue(6.6, 2);
        List<Integer> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtTreeMapTest12() {
        Assert.assertThrows("No keys for value: v6", NoSuchElementException.class,
                () -> extTreeMap.getKeysByValue(6.6, 2, ReturnType.EXCEPTION));
    }

// Get all keys

    @Test
    public void getAllKeysByValueFromExtTreeMapTest1() {
        List<Integer> actual = extTreeMap.getAllKeysByValue(1.1);
        List<Integer> expected = Collections.singletonList(1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtTreeMapTest2() {
        List<Integer> actual = extTreeMap.getAllKeysByValue(1.1, ReturnType.EXCEPTION);
        List<Integer> expected = Collections.singletonList(1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtTreeMapTest3() {
        List<Integer> actual = extTreeMap.getAllKeysByValue(3.3);
        List<Integer> expected = Arrays.asList(3, 4, 5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtTreeMapTest4() {
        List<Integer> actual = extTreeMap.getAllKeysByValue(3.3, ReturnType.EXCEPTION);
        List<Integer> expected = Arrays.asList(3, 4, 5);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtTreeMapTest5() {
        List<Integer> actual = extTreeMap.getAllKeysByValue(6.6);
        List<Integer> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtTreeMapTest6() {
        Double value = 6.6;
        Assert.assertThrows("No keys for value: " + value, NoSuchElementException.class,
                () -> extTreeMap.getAllKeysByValue(value, ReturnType.EXCEPTION));
    }

    // EXT LINKED HASHMAP

    // Get one key

    @Test
    public void getKeyByValueFromExtLinkedHashMapTest1() {
        Character actual = extLinkedHashMap.getFirstKeyByValue(1.0f);
        Character expected = 'a';
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtLinkedHashMapTest2() {
        Character actual = extLinkedHashMap.getFirstKeyByValue(1.0f, ReturnType.EXCEPTION);
        Character expected = 'a';
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtLinkedHashMapTest3() {
        Character actual = extLinkedHashMap.getFirstKeyByValue(3.0f);
        Character expected = 'c';
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtLinkedHashMapTest4() {
        Character actual = extLinkedHashMap.getFirstKeyByValue(3.0f, ReturnType.EXCEPTION);
        Character expected = 'c';
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeyByValueFromExtLinkedHashMapTest5() {
        Character actual = extLinkedHashMap.getFirstKeyByValue(6.0f);
        Assert.assertNull(actual);
    }

    @Test
    public void getKeyByValueFromExtLinkedHashMapTest6() {
        Assert.assertThrows("No keys for value: v6", NoSuchElementException.class,
                () -> extLinkedHashMap.getFirstKeyByValue(6.0f, ReturnType.EXCEPTION));
    }

    // Get several keys

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest1() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(1.0f, 1);
        List<Character> expected = Collections.singletonList('a');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest2() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(1.0f, 1, ReturnType.EXCEPTION);
        List<Character> expected = Collections.singletonList('a');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest3() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(1.0f, 2);
        List<Character> expected = Collections.singletonList('a');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest4() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(1.0f, 2, ReturnType.EXCEPTION);
        List<Character> expected = Collections.singletonList('a');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest5() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(3.0f, 1);
        List<Character> expected = Collections.singletonList('c');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest6() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(3.0f, 1, ReturnType.EXCEPTION);
        List<Character> expected = Collections.singletonList('c');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest7() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(3.0f, 2);
        List<Character> expected = Arrays.asList('c', 'd');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest8() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(3.0f, 2, ReturnType.EXCEPTION);
        List<Character> expected = Arrays.asList('c', 'd');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest9() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(3.0f, 3);
        List<Character> expected = Arrays.asList('c', 'd', 'e');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest10() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(3.0f, 3, ReturnType.EXCEPTION);
        List<Character> expected = Arrays.asList('c', 'd', 'e');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest11() {
        List<Character> actual = extLinkedHashMap.getKeysByValue(6.0f, 2);
        List<Character> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getKeysByValueFromExtLinkedHashMapTest12() {
        Assert.assertThrows("No keys for value: v6", NoSuchElementException.class,
                () -> extLinkedHashMap.getKeysByValue(6.0f, 2, ReturnType.EXCEPTION));
    }

// Get all keys

    @Test
    public void getAllKeysByValueFromExtLinkedHashMapTest1() {
        List<Character> actual = extLinkedHashMap.getAllKeysByValue(1.0f);
        List<Character> expected = Collections.singletonList('a');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtLinkedHashMapTest2() {
        List<Character> actual = extLinkedHashMap.getAllKeysByValue(1.0f, ReturnType.EXCEPTION);
        List<Character> expected = Collections.singletonList('a');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtLinkedHashMapTest3() {
        List<Character> actual = extLinkedHashMap.getAllKeysByValue(3.0f);
        List<Character> expected = Arrays.asList('c', 'd', 'e');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtLinkedHashMapTest4() {
        List<Character> actual = extLinkedHashMap.getAllKeysByValue(3.0f, ReturnType.EXCEPTION);
        List<Character> expected = Arrays.asList('c', 'd', 'e');
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtLinkedHashMapTest5() {
        List<Character> actual = extLinkedHashMap.getAllKeysByValue(6.0f);
        List<Character> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAllKeysByValueFromExtLinkedHashMapTest6() {
        Float value = 6.0f;
        Assert.assertThrows("No keys for value: " + value, NoSuchElementException.class,
                () -> extLinkedHashMap.getAllKeysByValue(value, ReturnType.EXCEPTION));
    }
}
