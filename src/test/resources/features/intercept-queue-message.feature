Feature: Intercept queue message

  Scenario: Intercept queue message and redirect message to queue
    Given producer sends a message
    When interceptor intercepts the message
    Then consumer receives the message