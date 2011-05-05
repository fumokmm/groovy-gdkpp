package ext

/**
 * instance methods extends
 */
@Category(String)
class StringExt {
  static final def withStatic = [StringExt]

  private static def replacer = { all, _1 -> // all is whole match
    _1.toUpperCase()[-1]
  }

  String camelize() {
    this.toLowerCase().replaceAll(/(_.)/, replacer)
  }

  String pascalize() {
    this.toLowerCase().replaceAll(/(^.|_.)/, replacer)
  }

  /**
   * Convert characters between characters numbers.
   * For example:
   *   assert 'i18n' == 'internationalization'.numberize()
   */
  String numberize() {
    int size = this.size()
    if (size > 2) this[0] + (size - 2).toString() + this[-1]
    else this
  }
}
