#Author: Juan Esteban Acevedo Muñoz

@Test
Feature: As an user app
  I want to find an item in Amazon web store
  To add someone product in my wish List

  @CaseOne
  Scenario Outline: Search in Amazon web store
    Given He enters to the website
    When He search products by filters: <descriptionToFind>
    Then He should be able to see in the search results: "1" with title: <productTitle>
    And  He should be able to see that is display: <TabMessage>

    Examples:
      | descriptionToFind    | productTitle                                   | TabMessage                               |
      | Software Test Design | A Practitioner's Guide to Software Test Design | Paperback tab was shown pre-selected     |
      | Software Test Design | A Practitioner's Guide to Software Test Design | Paperback tab was not shown pre-selected |