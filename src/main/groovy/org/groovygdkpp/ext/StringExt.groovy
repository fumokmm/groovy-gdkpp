/*
 * Copyright 2011 the original author fumokmm, authors, .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.groovygdkpp.ext

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
