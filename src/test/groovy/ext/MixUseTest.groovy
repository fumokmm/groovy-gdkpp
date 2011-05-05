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

package ext

import spock.lang.*

class MixUseTest extends Specification {
  def "use many category class and run"() {
    given:
    def file = null
    def zipped = null

    when:
    using {
      zipped = [1,2,3].zip([4,5,6])
      file = File.pwd()
    }

    then:
    zipped == [[1,4], [2,5], [3,6]]
    file.path == '.'
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    // using list expand operator (*)
    use(*ListExt.withStatic, *FileExt.withStatic) {
      return clos.call()
    }
  }
}
