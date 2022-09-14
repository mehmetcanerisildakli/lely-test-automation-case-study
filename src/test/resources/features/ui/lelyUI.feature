@runUITests
Feature: Checking website functions

  @uiCaseOne
  Scenario Outline: Search and check the keyword

    Given Go to address /en
    And Click acceptCookies
    And Click mainPageSearchButton
    Then Check whether searchFormActive is opened
    And Enter <text> into searchBox
    And Click searchButton
    Then Check searchResultTexts have <text>

    Examples:
      | text  |
      | happy |

  @uiCaseTwo
  Scenario: Check technical documents can be opened and installed

    Given Go to address /techdocs
    And Click acceptCookies
    And Click dropDown
    And Select Luna EUR from dropDownList
    And Scroll to typeDropDownList
    Then Check techDocHeader is present
    Then Check techDocHeader have LUNA EUR
    And Click viewFirstDocButton
    And Get attribute href from viewFirstDocButton
    And Switch the tab
    Then Check file is opened in the new tab
    And Switch the tab
    And Click firstDownloadButton
    Then Check the file is downloaded