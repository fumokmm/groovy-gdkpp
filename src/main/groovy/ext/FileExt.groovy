package ext

/**
 * instance methods extends
 */
@Category(File)
class FileExt {
  static final def withStatic = [FileExt, FileStaticExt]

  /**
   * override '/' operator.
   */
  File div(String other) {
    new File(this, other)
  }
}
