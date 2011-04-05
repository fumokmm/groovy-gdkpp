package ext

class FileExt {
  static {
    /** instance methods extends */
    File.metaClass.define {
      /** override '/' operator. */
      div { String other ->
        if (other in String) {
          new File(delegate, other)
        } else {
          throw new IllegalArgumentException('div allows only String.')
        }
      }
    }

    /** static methods extends */
    File.metaClass.'static'.pwd = {
      new File('.')
    }
  }
}
