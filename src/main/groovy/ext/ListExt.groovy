package ext

/**
 * instance methods extends
 */
@Category(List)
class ListExt {
  static final def withStatic = [ListExt]

  /**
   * haskell like zip method
   * cf. http://zvon.org/other/haskell/Outputprelude/zip_f.html
   */
  def zip(List other) {
    [this, other].transpose()
  }
}
