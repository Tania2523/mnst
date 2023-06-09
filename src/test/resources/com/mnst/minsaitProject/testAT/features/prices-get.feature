Feature: Check GET /v1/price

  Scenario Outline: <id> - Check GET /v1/price - <description>
    Given the application with running status
    When the endpoint is called with the method GET and with the parameters <application_date>, <product_id_r> and <brand_id_r>
    Then the response code must be 200
    And the response body must be <response> 
    
    Examples: 
      | id      | application_date    | product_id_r | brand_id_r | response     | description                                               |
      | PR-G-01 | 2020-06-14-10.00.00 | 35455        | 1          | PR-G-01.json | Request at 10:00 on the 14th of product 35455 for brand 1 |
      | PR-G-02 | 2020-06-14-16.00.00 | 35455        | 1          | PR-G-02.json | Request at 16:00 on the 14th of product 35455 for brand 1 |
      | PR-G-03 | 2020-06-14-21.00.00 | 35455        | 1          | PR-G-03.json | Request at 21:00 on the 14th of product 35455 for brand 1 |
      | PR-G-04 | 2020-06-15-10.00.00 | 35455        | 1          | PR-G-04.json | Request at 10:00 on the 15th of product 35455 for brand 1 |
      | PR-G-05 | 2020-06-16-21.00.00 | 35455        | 1          | PR-G-05.json | Request at 21:00 on the 16th of product 35455 for brand 1 |