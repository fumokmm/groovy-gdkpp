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
}
