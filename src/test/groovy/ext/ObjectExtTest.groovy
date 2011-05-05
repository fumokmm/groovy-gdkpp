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

class ObjectExtTest extends Specification {
  def "is collectWithIndex work?"() {
    expect:
    using{ list.collectWithIndex(clos) } == result

    where:
    list            | clos                                | result
    ['a', 'b', 'c'] | {item, idx -> "$idx:$item" }        | ['0:a', '1:b', '2:c']
    ['a', 'b', 'c'] | {item, idx -> "${item * (idx+1)}" } | ['a', 'bb', 'ccc']
  }

  def "is replicate work?"() {
    expect:
    using{ a.replicate(num) } == result
    
    where:
    // cf. http://zvon.org/other/haskell/Outputprelude/replicate_f.html
    a    | num | result
    3    | 5   | [3, 3, 3, 3, 3]
    5    | 3   | [5, 5, 5]
    'aa' | 5   | ['aa', 'aa', 'aa', 'aa', 'aa']
    [1]  | 3   | [[1], [1], [1]]
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    use(ObjectExt.withStatic) {
      return clos.call()
    }
  }
}
