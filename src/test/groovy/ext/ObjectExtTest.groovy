package ext

import spock.lang.*

class ObjectExtTest extends Specification {
  def "is collectWithIndex work?"() {
    expect:
    using{ list.collectWithIndex(clos) } == result

    where:
    list            | clos                                | result
    ['a', 'b', 'c'] | {item, idx -> "$idx:$item" }        | ['0:a', '1:b', '2:c']
    ['a', 'b', 'c'] | {item, idx -> "${item * (idx+1)}" } | ['a', 'bb', 'ccc']
  }

  def "is replicate work?"() {
    expect:
    using{ a.replicate(num) } == result
    
    where:
    // cf. http://zvon.org/other/haskell/Outputprelude/replicate_f.html
    a    | num | result
    3    | 5   | [3, 3, 3, 3, 3]
    5    | 3   | [5, 5, 5]
    'aa' | 5   | ['aa', 'aa', 'aa', 'aa', 'aa']
    [1]  | 3   | [[1], [1], [1]]
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    use(ObjectExt.withStatic) {
      return clos.call()
    }
  }
}
