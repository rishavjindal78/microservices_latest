Feature: Purchase and sale of metals such as aluminum, zinc and copper
  Scenario: A Trade is a sale of a commodity
    Given The trade is already done
    When Check the tade with id '5eb981ae2829ad6d10a7d7fe'
    Then The result of the trade is 'SELL'
    
  Scenario: A Trade is a purchase of a commodity
    Given The trade is already done
    When Check the tade with id '5eb981ae2829ad6d10a7d7fd'
    Then The result of the trade is 'BUY'

