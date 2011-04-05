package ext

class StringExt {
  static {
    def replacer = { all, _1 -> _1.toUpperCase()[-1] } // all is whole match

    /** instance methods extends */
    String.metaClass.define {
      camelize {
        delegate.toLowerCase().replaceAll(/(_.)/, replacer)
      }
      pascalize {
        delegate.toLowerCase().replaceAll(/(^.|_.)/, replacer)
      }
    }
  }
}
