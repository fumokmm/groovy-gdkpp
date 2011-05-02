package ext

import spock.lang.*

class MixUseTest extends Specification {
  def "use many category class and run"() {
    given:
    def file = null
    def zipped = null

    when:
    using {
      zipped = [1,2,3].zip([4,5,6])
      file = File.pwd()
    }

    then:
    zipped == [[1,4], [2,5], [3,6]]
    file.path == '.'
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    // using list expand operator (*)
    use(*ListExt.withStatic, *FileExt.withStatic) {
      return clos.call()
    }
  }
}
