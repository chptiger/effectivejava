package chapter1_createdestoryobjects.item7_Eliminateobsoleteobjectreferences;

import static com.jayway.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/hashmap-vs-weakhashmap-java/
 * https://stackoverflow.com/questions/23038912/how-to-effectively-use-a-string-as-a-weakhashmap-key-in-java-or-an-alternative
 * 
 *HashMap
 *the object is specified as key in hashmap, it does not have any reference and it is NOT eligible for garbage collection if it is associated with HashMap
 *i.e. HashMap dominates over Garbage Collector.
 *
 *WeakHashMap:
 *if object is specified as key doesn't contain any references - it is eligible for garbage collection even though it is associated with WeakHashMap
 *i.e Garbage Collector dominates over WeakHashMap
 *
 *Diff:
 *1. Strong vs Weak References: 
 *Weak reference Objects are not the default type/clas of Reference Object and they should be explicitly specified while using them
 *this type of reference is used in WeakHashMap to reference the entry objects
 *Strong reference: this is the default type/class of Reference Object. any object which has an active strong reference are not eligible for garbage collection.
 *In HashMap, key objects have strong reference.
 *
 *2. Role of Garbage Collector:
 *In HashMap, entry object(stores key-value pairs) is not eligible for garbage collection. i.e. Hashmap is dominant over Garbage Collector.
 *In WeakHashmap. when a key is discarded then its entry is automatically removed from the map, in other words, garbage collected.
 *
 *3. Clone method implementation:
 *HashMap implements Cloneable interface, WeakHashMap does not implement Cloneable interface, it only implements Map interface. 
 *Hence, there is no clone() method in the WeakHashMap class
 */
public class WeakHashMapDemo {
//	https://www.baeldung.com/java-weakhashmap
    @Test
    public void givenWeakHashMap_whenCacheValueThatHasNoReferenceToIt_GCShouldReclaimThatObject() throws Exception {
        //given
        WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        BigImage bigImage = new BigImage("image_id");
        UniqueImageName imageName = new UniqueImageName("name_of_big_image");

        map.put(imageName, bigImage);
        assertTrue(map.containsKey(imageName));

        //when big image key is not reference anywhere
        imageName = null;
        System.gc();

        //then GC will finally reclaim that object
        await().atMost(10, TimeUnit.SECONDS).until(map::isEmpty);
    }

    @Test
    public void givenWeakHashMap_whenCacheValueThatHasNoReferenceToIt_GCShouldReclaimThatObjectButLeaveReferencedObject() throws Exception {
        //given
        WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        BigImage bigImageFirst = new BigImage("foo");
        UniqueImageName imageNameFirst = new UniqueImageName("name_of_big_image");
        WeakHashMap<String, String> stringMap = new WeakHashMap<>();
        String key = "weakHashMap";
        stringMap.put(key, "hi");
        BigImage bigImageSecond = new BigImage("foo_2");
        UniqueImageName imageNameSecond = new UniqueImageName("name_of_big_image_2");

        map.put(imageNameFirst, bigImageFirst);
        map.put(imageNameSecond, bigImageSecond);
        assertTrue(map.containsKey(imageNameFirst));
        assertTrue(map.containsKey(imageNameSecond));
System.out.println(stringMap);
        //when
        imageNameFirst = null; key = null;
        System.gc();
System.out.println(stringMap);
        //then
        await().atMost(10, TimeUnit.SECONDS).until(() -> map.size() == 1);
        await().atMost(10, TimeUnit.SECONDS).until(() -> map.containsKey(imageNameSecond));
    }


    class BigImage {
        public final String imageId;

        BigImage(String imageId) {
            this.imageId = imageId;
        }
    }

    class UniqueImageName {
        public final String imageName;

        UniqueImageName(String imageName) {
            this.imageName = imageName;
        }
    }
}
