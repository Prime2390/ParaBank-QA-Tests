<h1 align="center">ParaBank Automation Test</h1>

<h2>📌 Project Description</h2>
<p>This project contains automated tests for the <strong>ParaBank</strong> application, verifying key online banking functionalities. The tests are written in <strong>Java</strong> and utilize <strong>Selenium WebDriver, TestNG, and Page Object Model (POM)</strong>.</p>

<h2>🛠 Technologies & Tools</h2>
<ul>
  <li><strong>Java</strong> – Programming language</li>
  <li><strong>Selenium WebDriver</strong> – Browser automation</li>
  <li><strong>TestNG</strong> – Test execution framework</li>
  <li><strong>Maven</strong> – Dependency management</li>
  <li><strong>Faker</strong> – Random test data generation</li>
</ul>

<h2>📂 Project Structure</h2>
<pre>
ParaBankAutomationTest/
│── src/
│   ├── main/
│   │   └── java/pl/aplikacja/Main.java  # Main application class
│   ├── test/
│   │   ├── DominikBernas/basetest/     # Base test class
│   │   ├── DominikBernas/models/       # Test data models
│   │   ├── DominikBernas/pages/        # Page Object Model
│   │   ├── DominikBernas/tests/        # Test scenarios
│   │   ├── DominikBernas/utils/        # Utility functions
│── pom.xml  # Maven configuration
│── testng.xml  # TestNG configuration
│── README.md  # Project documentation
│── .gitignore  # Git ignored files
</pre>

<h2>🚀 Running Tests</h2>
<ol>
  <li><strong>Clone the repository:</strong>
    <pre>git clone https://github.com/Prime2390/ParaBankAutomationTest.git
cd ParaBankAutomationTest</pre>
  </li>
  <li><strong>Install dependencies:</strong>
    <pre>mvn clean install</pre>
  </li>
  <li><strong>Run tests:</strong>
    <pre>mvn test</pre>
    Or run specific tests:
    <pre>mvn test -Dtest=LoginTest</pre>
  </li>
</ol>

<h2>📝 Test Scenarios</h2>

<ul>
  <li>✅ User Registration</li>
  <li>✅ User Login</li>
  <li>✅ Password Recovery</li>
  <li>✅ Loan Request</li>
</ul>

<h2>📌 Author</h2>
<p>Project developed by <strong>DominikBernas</strong>.</p>
