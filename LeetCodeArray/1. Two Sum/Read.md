Time Complexity: O(n) Where n is the length of the array.
Space Complexity: O(n) where n is the length of the longest array.  

Consideration:
1. Find the a pair of numbers which are stored in array without order.
2. The result will print the position of the pair. It will requires more memory to store position and value for each value in the array.
3. Map could store two values, Hash could achieve the quick searching. Hence, We could use HashMap.

Order resource:

Map Implementations
Since Map is an interface you need to instantiate a concrete implementation of the interface in order to use it. You can choose between the following Map implementations in the Java Collections API:

java.util.HashMap
java.util.Hashtable
java.util.EnumMap
java.util.IdentityHashMap
java.util.LinkedHashMap
java.util.Properties
java.util.TreeMap
java.util.WeakHashMap


¨X¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨j¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨j¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨j¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨[
¨U   Property   ¨U       HashMap       ¨U      TreeMap      ¨U     LinkedHashMap   ¨U
¨d¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨g
¨U              ¨U  no guarantee order ¨U sorted according  ¨U                     ¨U
¨U   Order      ¨U will remain constant¨U to the natural    ¨U    insertion-order  ¨U
¨U              ¨U      over time      ¨U    ordering       ¨U                     ¨U
¨d¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨g
¨U  Get/put     ¨U                     ¨U                   ¨U                     ¨U
¨U   remove     ¨U         O(1)        ¨U      O(log(n))    ¨U         O(1)        ¨U
¨U containsKey  ¨U                     ¨U                   ¨U                     ¨U
¨d¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨g
¨U              ¨U                     ¨U   NavigableMap    ¨U                     ¨U
¨U  Interfaces  ¨U         Map         ¨U       Map         ¨U         Map         ¨U
¨U              ¨U                     ¨U    SortedMap      ¨U                     ¨U
¨d¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨g
¨U              ¨U                     ¨U                   ¨U                     ¨U
¨U     Null     ¨U       allowed       ¨U    only values    ¨U       allowed       ¨U
¨U values/keys  ¨U                     ¨U                   ¨U                     ¨U
¨d¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨m¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨m¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨g
¨U              ¨U   Fail-fast behavior of an iterator cannot be guaranteed      ¨U
¨U   Fail-fast  ¨U impossible to make any hard guarantees in the presence of     ¨U
¨U   behavior   ¨U           unsynchronized concurrent modification              ¨U
¨d¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨j¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨j¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨g
¨U              ¨U                     ¨U                   ¨U                     ¨U
¨UImplementation¨U      buckets        ¨U   Red-Black Tree  ¨U    double-linked    ¨U
¨U              ¨U                     ¨U                   ¨U       buckets       ¨U
¨d¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨p¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨m¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨m¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨g
¨U      Is      ¨U                                                               ¨U
¨U synchronized ¨U              implementation is not synchronized               ¨U
¨^¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨m¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨T¨a