# Transaction Loyalty Program

## Table of Contents

- [Overview](#overview)
- [Technologies](#technologies)
- [Features](#features)
- [File Structure](#file-structure)
- [Setup](#setup)
- [Usage](#usage)
- [Contributions](#contributions)
- [License](#license)

## Overview

This project is a simple loyalty program system for a supermarket. It allows users to earn and spend bonus points, with operations logged for tracking purposes. The system demonstrates the use of transaction handling and logging, highlighting core software engineering principles for managing transactions in Java.

## Technologies

- **Java 21**: Core programming language for the system.
- **Log4j 2**: Logging framework for managing application logs.
- **Maven**: Dependency management and build tool.

## Features

- **Earn Points**: Users can earn bonus points through purchases.
- **Spend Points**: Users can spend bonus points, with sufficient balance required.
- **Transaction Logging**: Every transaction (earning or spending points) is logged for traceability.
- **Error Handling**: Proper error handling for insufficient points during transaction processing.
- **Transaction History**: A record of all transactions (bonus points earned or spent).

## File Structure

```
src/main/java/com/sangarius/transactionloyaltyprogram/
├── exceptions/                                              # Custom exceptions
│   └── InsufficientPointsException.java
├── model/                                                   # Domain models
│   └── UserAccount.java
├── service/                                                 # Business logic services
│   ├── TransactionHistory.java
│   └── TransactionService.java
├── LoyaltyProgram.java                                      # Main application class (outside of service folder)
├── resources/
│   └── log4j2.xml                                           # Log4j2 configuration file
└── test/java/com/sangarius/transactionloyaltyprogram/
└── TransactionServiceTest.java                              # Unit tests for services
pom.xml                                                      # Maven configuration file
logs/                                                        # Folder where log files are saved
└── app.log                                                  # Log file
README.md                                                    # Project overview and setup instructions
.gitignore                                                   # Git ignore file
LICENSE                                                      # Project license file
```

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/sangariusss/transaction-loyalty-program.git
   cd transaction-loyalty-program
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the demo:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.sangarius.transactionloyaltyprogram.LoyaltyProgram"
   ```

## Usage

1. **Earn Points:**
    - The system will log a bonus points addition event when `earnPoints` is called in `TransactionService`.

2. **Spend Points:**
    - The system will log a points expenditure event and check if there are sufficient points.
    - If the points are insufficient, an error is logged.

3. **Transaction History:**
    - The system logs all transactions (earning/spending points) to the transaction history.

### Example Console Output:

```
2025-02-12 22:41:30.052 [main] INFO  com.sangarius.transactionloyaltyprogram.service.TransactionService - 50 points added for user Olexiy
2025-02-12 22:41:30.056 [main] INFO  com.sangarius.transactionloyaltyprogram.service.TransactionService - 80 points spent by user Olexiy
2025-02-12 22:41:30.056 [main] ERROR com.sangarius.transactionloyaltyprogram.LoyaltyProgram - Error: Not enough bonus points. User balance: 70 points
com.sangarius.transactionloyaltyprogram.exceptions.InsufficientPointsException: Not enough bonus points!
	at com.sangarius.transactionloyaltyprogram.service.TransactionService.spendPoints(TransactionService.java:20) ~[classes/:?]
	at com.sangarius.transactionloyaltyprogram.LoyaltyProgram.main(LoyaltyProgram.java:21) [classes/:?]
2025-02-12 22:41:30.083 [main] INFO  com.sangarius.transactionloyaltyprogram.LoyaltyProgram - Balance: 70 points
2025-02-12 22:41:30.084 [main] INFO  com.sangarius.transactionloyaltyprogram.service.TransactionHistory - 
Transaction history:
2025-02-12 22:41:30.086 [main] INFO  com.sangarius.transactionloyaltyprogram.service.TransactionHistory - +50 points added for Olexiy
2025-02-12 22:41:30.086 [main] INFO  com.sangarius.transactionloyaltyprogram.service.TransactionHistory - -80 points spent by Olexiy
```

## Contributions

Contributions are welcome! If you'd like to add features, fix bugs, or improve the system, please feel free to fork the repository and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.