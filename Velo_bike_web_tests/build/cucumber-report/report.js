$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("bdd\\menu.feature");
formatter.feature({
  "name": "SideMenu",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "GoToPricePage",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a side menu and then go to PricePage",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i get Current Page URL and get Page Name",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Current Page URL and Page Name equals really URL and page name",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});