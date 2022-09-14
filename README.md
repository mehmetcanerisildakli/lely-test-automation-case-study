# LELY TEST AUTOMATION CASE STUDY

It is an automation project created for Lely company. It has 3 cases. Two of them are UI automation one of them is API services automation.
 
* [Case link](https://c.smartrecruiters.com/sr-company-attachments-prod-dc5/5c10eff5ee358800064886cd/4693b913-b0fc-44e2-9da6-0a656d1c44fd?r=s3-eu-central-1)

## Installation

Use git command

```bash
git clone https://github.com/mehmetcanerisildakli/lely-test-automation-case-study.git
```

## Usage
Check feature files; inside *src/test/resources/features* check the scenarios you want to run and put the tag name in the class and run
```
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty"},
        glue = "steps",
        tags = "@uiCaseTwo")
public class RunTest {
}
```

## Technology

* Java
* Selenium
* Maven
* JUnit
* Cucumber (BDD)
* REST-Assured

## License
[MIT](https://choosealicense.com/licenses/mit/)
