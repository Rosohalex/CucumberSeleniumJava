Feature: Calculator


  Scenario: Divide two Numbers
    Given I have calculator
    When divide 100 by 2
    Then result should be 50

  Scenario Template: Divide two Numbers again
    Given I have calculator
    When divide <num1> by <num2>
    Then result should be <res>

    Examples:
    |num1 |num2 |res |
    |  6  |  2  |  3 |
    |1100 |100  |11  |
    |90   |3    |30  |

    Scenario: Open Web Page
      Given Google Chrome browser is opened
      When Open "https:\\yandex.ru" page
        And Search for "salidzini.lv"


