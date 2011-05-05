How to use
----------

1. Compile 'groovy-gdkpp.jar'. (Require [Gradle][])

> $ gradle

2. Put 'groovy-gdkpp.jar' on the classpath.

3. Using example

### ListExt
> use(ListExt.withStatic) {
>   assert [[1, 4], [2, 5], [3, 6]] == [1,2,3].zip([4,5,6])
> }

[gradle]: http://gradle.org/ "Gradle"