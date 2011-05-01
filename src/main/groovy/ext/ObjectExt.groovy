package ext

/**
 * instance methods extends
 */
@Category(Object)
class ObjectExt {
  static final def withStatic = [ObjectExt]

  def collectWithIndex(Closure clos) {
    def result = []
    this.eachWithIndex { item, idx ->
      result << clos(item, idx)
    }
    result
  }

  /**
   * Haskell like replicate.
   * cf. http://zvon.org/other/haskell/Outputprelude/replicate_f.html
   */
  def replicate(int num) {
    def result = []
    num.times{ result << this }
    result
  }
}
