package ext

/**
 * static methods extends
 */
@Category(Class)
class FileStaticExt extends StaticExt {
  private static final Class category = File

  /**
   * @return current directory's File.
   */
  File pwd() {
    checkIsAssignable(this, category)
    new File('.')
  }
}
