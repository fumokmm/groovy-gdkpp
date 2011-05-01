package ext

class StaticExt {
  protected static boolean checkIsAssignable(Class self, Class clazz) {
    if (! self.isAssignableFrom(clazz)) {
      throw new ClassCastException("${clazz.name} only.")
    }
    true
  }
}
