package chapter1_createdestoryobjects.item6_avoidcreatingunnecessaryobjects;

/**
 * adapters --> gramma95 
 * An adapter is an object that delegates to a backing object, providing an alternative interface.
 * Because an adapter has no sate beyond that of its backing object, there is no need to create more than one instance of a given adapter to a given object.
 *
 *keySet method of the Map interface return a Set view of the Map object, consisting of all the keys in the map.
 *Naively, it would seen that every call to keySet would have to create a new Set instance,, but every call to keySet on a given Map object may return the sam Set instance.
 *Although the returned Set instance is typically mutable, all of the returned objects are functionally identical:
 *when one of the returned objects changes, so do all the others, because they are all backed by the same Map instance.
 *While it is largely harmless to create multiple instances of the keySet view object, it is unnecessary and have no benefits.
 */
public class ImmutableObjectNotSafelyReused {

}
