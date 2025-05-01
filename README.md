
<h1 align="center">🍔 Food Delivery Web Application</h1>
<h3 align="center">🧪 Selenium Automated Testing Suite with Java, Maven & TestNG</h3>

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-blue.svg" />
  <img src="https://img.shields.io/badge/Tested%20With-Selenium-green.svg" />
  <img src="https://img.shields.io/badge/Framework-TestNG-yellow.svg" />
  <img src="https://img.shields.io/badge/Build-Maven-orange.svg" />
</p>

---

## 🧾 Project Summary

An automation framework developed for a **Food Delivery Web App** that ensures the core features of both **customers** and **admins** work smoothly through **automated functional testing**.

🎯 **Automated Scenarios Include**:
- 🔐 User login/logout & session timeout
- 🛒 Cart operations & price validations
- 🍽️ Food search, selection, and ordering
- 💬 Feedback submission flow
- 📦 Admin-side order and menu item management

---

## 🧰 Tech Stack

| Category            | Tools / Technologies              |
|---------------------|-----------------------------------|
| 👨‍💻 Language        | Java                              |
| 🧪 Automation Tool   | Selenium WebDriver                |
| 🧵 Test Framework    | TestNG                            |
| 🏗️ Build Tool       | Maven                             |
| 📊 Reporting Tool    | Extent Reports                   |
| 🧪 API Testing Tool  | Postman (for manual API testing)  |
| 🗃️ Version Control   | Git, GitHub                       |

---

## 🗂️ Project Structure

```
food-delivery-automation/
├── src/
│   ├── main/java/
│   │   ├── base/          → Driver Setup
│   │   ├── pages/         → Page Objects (POM)
│   │   ├── utilities/     → Helpers (e.g., wait utils, config reader)
│   ├── test/java/
│       ├── tests/         → Test Scenarios
├── resources/
│   ├── config.properties → Base URL, browser, credentials
│   ├── testdata/         → Data files for test inputs
├── test-output/          → Extent Reports (optional)
├── pom.xml               → Maven config
└── README.md
```

---

## 🚀 How to Run the Tests

1. **📥 Clone the Repository**
```bash
git clone https://github.com/your-username/food-delivery-automation.git
cd food-delivery-automation
```

2. **🛠️ Configure Settings**  
Update `config.properties` with:
   - Application URL  
   - Valid credentials  
   - Browser type  

3. **▶️ Run Tests**
```bash
mvn clean test
```

4. **📊 View Report**
   - Open the Extent Report under `test-output/` (if integrated).

---

## ✅ Sample Test Scenarios

| Test Module            | Description                                 |
|------------------------|---------------------------------------------|
| 🔐 Login Flow          | Valid/Invalid login, session timeout         |
| 🛒 Cart Functionality  | Add, update, remove items, price validation |
| 📦 Order Processing    | Place, update, cancel orders                |
| 💬 Feedback System     | Submit and verify confirmation messages     |
| 🛠️ Admin Panel         | Manage orders, food items, and users        |

---

## 🧭 Roadmap & Future Work

- 🔄 Add CI/CD Pipeline with GitHub Actions
- 📱 Enhance responsiveness testing (mobile-first testing)
- 🔒 Integrate security testing for user input
- 🔁 Expand regression coverage with data-driven tests

---

## 📎 References & Docs

- 📚 [Manual Test Case Report](#)
- 📸 Screenshots in `/appendix`
- 🧪 [Test Plan & Strategy Document](#)

---


## 👩‍💻 Our Developer Squad

> *"Built with coffee ☕, late nights 🌙, and a lot of debugging 💻."*

<table>
  <tr>
    <td align="center">
      <img src="https://github.com/pehandassanayaka.png" width="100px;" alt="Your Name"/><br />
      <b>Pehan Dassanayake</b> <br/>
      📧 pehandassanayaka@gmail.com <br/>
      <a href="https://github.com/pehandassanayaka">GitHub</a> • 
      <a href="https://linkedin.com/in/your-profile">LinkedIn</a>
    </td>
    <td align="center">
      <img src="https://github.com/janedoe.png" width="100px;" alt="Jane Doe"/><br />
      <b>Nethmini Senarathna</b> <br/>
      📧 jane.doe@email.com <br/>
      <a href="https://github.com/janedoe">GitHub</a> • 
      <a href="https://linkedin.com/in/janedoe">LinkedIn</a>
    </td>
    <td align="center">
      <img src="https://github.com/johnsmith.png" width="100px;" alt="John Smith"/><br />
      <b>Navindya Jayathilake</b> <br/>
      📧 john.smith@email.com <br/>
      <a href="https://github.com/johnsmith">GitHub</a> • 
      <a href="https://linkedin.com/in/johnsmith">LinkedIn</a>
    </td>
    <td align="center">
      <img src="https://github.com/johnsmith.png" width="100px;" alt="Alex Johnson"/><br />
      <b>Prajila Shehani</b> <br/>
      📧 alex.j@email.com <br/>
      <a href="https://github.com/alexjohnson">GitHub</a> • 
      <a href="https://linkedin.com/in/alexjohnson">LinkedIn</a>
    </td>
  </tr>
</table>



---

> ⚡ *“Quality is never an accident; it is always the result of intelligent effort.” – John Ruskin*
