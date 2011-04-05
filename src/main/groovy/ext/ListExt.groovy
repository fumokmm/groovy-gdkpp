package ext

class ListExt {
  static {
    /** instance methods extends */
    List.metaClass.define {
      // haskell like zip method
      zip { List other ->
        [delegate, other].transpose()
      }
    }
  }
}
