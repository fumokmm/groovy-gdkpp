package ext

import spock.lang.*

class FileExtTest extends Specification {
  def "is pwd work?"() {
    given:
    def file = null

    when:
    use(FileExt.withStatic) {
      file = File.pwd()
    }

    then:
    file.name == '.'
  }

  def "is div work?"() {
    given:
    def file = null
    use(FileExt.withStatic) {
      file = File.pwd()
    }

    when:
    use(FileExt.withStatic) {
      file = file / 'a'
    }

    then:
    file.path == './a'

    when:
    use(FileExt.withStatic) {
      file = file / 'b' / 'c'
    }

    then:
    file.path == './a/b/c'
  }

}
