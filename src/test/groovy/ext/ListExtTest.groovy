package ext

import spock.lang.*

class ListExtTest extends Specification {
  def "is zip work?"() {
    expect:
    using{ list1.zip(list2) } == zipped
    
    where:
    // cf. http://zvon.org/other/haskell/Outputprelude/zip_f.html
    list1       | list2   | zipped
    [1,2,3]     | [9,8,7] | [[1,9],[2,8],[3,7]]
    [1,2,3,4,5] | [9,8]   | [[1,9],[2,8]]
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    use(ListExt.withStatic) {
      return clos.call()
    }
  }
}
