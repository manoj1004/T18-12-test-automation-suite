# T18-12-test-automation-suite
A test automation suite to run through and validate a website's functionalities.

PURPOSE:-

As a part of learning efforts, for this project I have picked a simple website to run an automated test.
This website https://www.saucedemo.com/index.html has got a bunch of functionalities that can be tested 
manually or through automation.
--------------------------------------------------------------------------------

TARGET ITEMS:-

Some obvious test cases anyone would think of performing on this site would be:
1. Login , Logout 
2. Home Page - Menu Button functions- what each one of them does when clicked on
3. Navigation - in case of placing an order, shipping details, checkout and order confirmation.
4. Placing and Cancelling orders - testing if the total cart items match the user's Add/Remove actions.
5. Sorting items - to see if items order by 'Price' (high to low) or 'Name' (Z to A).
6. Error messages - to see if the page errs out if a blank form was submitted.
--------------------------------------------------------------------------------

APPROACH:-

In order to perform an automated test on our target items, I have used the following test tools.
1. Web Scraping technique - to read webelement references (XPath, CSSselector, etc) to click and fill fields actions.
2. Selenium WebDrivers    - to establish browser set up, connections and navigation throughout the process.
3. Test NG Framework      - annotations and libraries to write assertions and decide the sequence of execution.
4. Extent Report          - Although TestNG and Junit provide test reports, Extent reports provide 
                            a much comprehensive one with graphical representations. It is also more 
                            presentable by the way it displays the test execution log.
5. Maven repo - pom.xml   - to fetch libraries for selenium, testNG, junit, extent reports

--------------------------------------------------------------------------------

DEMO:-
A video of the script run - (video link goes here)



