Feature: menu

Scenario: GoToPricePage
  Given a side menu and then go to PricePage
  When i get Current Page URL and get Page Name
  Then Current Page URL and Page Name equals really URL and page name