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

class StringExtTest extends Specification {
  def "is camelize work?"() {
    expect:
    using{ str.camelize() } == result
    
    where:
    str              | result
    'hello_world'    | 'helloWorld'
    'a_b_c_d_e'      | 'aBCDE'
    'aa_bb_cc_dd_ee' | 'aaBbCcDdEe'
  }

  def "is pascalize work?"() {
    expect:
    using{ str.pascalize() } == result
    
    where:
    str              | result
    'hello_world'    | 'HelloWorld'
    'a_b_c_d_e'      | 'ABCDE'
    'aa_bb_cc_dd_ee' | 'AaBbCcDdEe'
  }

  def "is numberize work?"() {
    expect:
    using{ str.numberize() } == result

    where:
    str                    | result
    'internationalization' | 'i18n'
    'あいうえお'            | 'あ3お'
    'abc'                  | 'a1c'
    'ab'                   | 'ab'
    'a'                    | 'a'
    ''                     | ''
  }

  /**
   * using use block with static
   */
  def using(Closure clos) {
    use(StringExt.withStatic) {
      return clos.call()
    }
  }
}
