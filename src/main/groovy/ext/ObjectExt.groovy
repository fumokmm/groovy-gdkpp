package ext

class ObjectExt {
  static {
    /** instance methods extends */
    Object.metaClass.collectWithIndex = { clos ->
      def result = []
      delegate.eachWithIndex { item, idx ->
        result << clos(item, idx)
      }
      result
    }
  }
}
