## Multithreaded e2e framework stub using TestNG

### This is a working multithreaded e2e framework stub using TestNG. To run execute the following:

Linux
```bash
sh mvnw clean install site
sh mvnw io.qameta.allure:allure-maven:serve
```
Windows
```bash
mvnw.cmd clean install site
mvnw.cmd io.qameta.allure:allure-maven:serve
```
#### Make sure you have browsers.json is in your /etc/selenoid folder
