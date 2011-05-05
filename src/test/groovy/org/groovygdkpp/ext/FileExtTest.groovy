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

import spock.lang.*

class FileExtTest extends Specification {
  def "is pwd work?"() {
    given:
    def file = null

    when:
    using{ file = File.pwd() }

    then:
    file.name == '.'
  }

  def "is div work?"() {
    given:
    def file = null
    using{ file = File.pwd() }

    when:
    using{ file = file / 'a' }

    then:
    file.path == './a'

    when:
    using{ file = file / 'b' / 'c' }

    then:
    file.path == './a/b/c'
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    use(FileExt.withStatic) {
      return clos.call()
    }
  }
}
