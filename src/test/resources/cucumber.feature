Feature: Shopping flow

  Scenario: Login and add product to cart
    Given user is on login page
    When user logs in with valid credentials
    Then user adds product to cart
