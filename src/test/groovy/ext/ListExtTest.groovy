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

class ListExtTest extends Specification {
  def "is zip work?"() {
    expect:
    using{ list1.zip(list2) } == zipped
    
    where:
    // cf. http://zvon.org/other/haskell/Outputprelude/zip_f.html
    list1       | list2   | zipped
    [1,2,3]     | [9,8,7] | [[1,9],[2,8],[3,7]]
    [1,2,3,4,5] | [9,8]   | [[1,9],[2,8]]
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    use(ListExt.withStatic) {
      return clos.call()
    }
  }
}
