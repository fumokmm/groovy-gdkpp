package ext

import spock.lang.*

class FileExtTest extends Specification {
  def "is pwd work?"() {
    given:
    def file = null

    when:
    using{ file = File.pwd() }

    then:
    file.name == '.'
  }

  def "is div work?"() {
    given:
    def file = null
    using{ file = File.pwd() }

    when:
    using{ file = file / 'a' }

    then:
    file.path == './a'

    when:
    using{ file = file / 'b' / 'c' }

    then:
    file.path == './a/b/c'
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    use(FileExt.withStatic) {
      return clos.call()
    }
  }
}
