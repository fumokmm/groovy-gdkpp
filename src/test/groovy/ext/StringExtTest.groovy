package ext

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
