# SDA-Pro: Threat Intelligence Proxy Subsystem (Student B)

This project contains the implementation for **Student B**'s subsystem in the **SDA-Pro** project, developed on the branch `feature/B-threat-intel-proxy`. It implements core structural, behavioral, and creational architectural design patterns using vanilla Java (no Spring Boot, external APIs, or databases).

---

## 📂 Project Folder Structure

The Java source code is structured under the package root `com.sdapro` inside the standard Maven source directory structure `src/main/java`. Below is the complete directory structure:

```
c:\Users\Salman Yousafzai\Desktop\SDA Pro\SDA-Pro\
  ├── .gitignore                    # Git file exclusion rules
  ├── README.md                     # Project documentation (this file)
  ├── run.bat                       # Compilation & execution helper script
  ├── SDA-Pro_Submission.docx       # Assignment reference sheet
  └── src/                          # Source root directory
      └── main/
          └── java/
              └── com/
                  └── sdapro/
                      ├── Main.java                    # Application main driver entry point
                      │
                      ├── facade/                      # 1. Facade Pattern Subsystem
                      │   ├── IncidentResponseFacade.java  # Facade orchestrator
                      │   ├── ResponseService.java         # Strategy context / Mitigation service
                      │   └── ThreatIntelService.java      # Subsystem interface (Target interface)
                      │
                      ├── strategy/                    # 2. Strategy Pattern
                      │   ├── ResponseStrategy.java        # Strategy base interface
                      │   ├── AggressiveStrategy.java      # Concrete isolation action
                      │   └── ConservativeStrategy.java    # Concrete monitoring action
                      │
                      ├── adapter/                     # 3. Adapter Pattern
                      │   ├── ThirdPartyVirusTotalApi.java # Simulated proprietary external SDK (Adaptee)
                      │   └── VirusTotalAdapter.java       # Translating adapter (Adapter class)
                      │
                      ├── proxy/                       # 4. Proxy Pattern
                      │   └── ThreatIntelProxy.java        # Virtual caching & logging wrapper (Proxy)
                      │
                      └── notification/                # 5. Simple Notification Service
                          └── EmailNotifier.java           # Internal dispatch utility
```

---

## 🎨 Design Patterns Implemented

All design patterns are documented with `// PATTERN: [Name]` annotations in the source files.

### 1. Facade Pattern
- **Classes**: `IncidentResponseFacade`, `ResponseService`, `ThreatIntelService`
- **Purpose**: Simplifies incident handling. Instead of forcing clients to manually orchestrate scans, determine policy decisions, invoke strategies, and dispatch notifications, the client calls `IncidentResponseFacade.handleIncident(incidentId, ipAddress)`. The facade handles the complexity under the hood.

### 2. Strategy Pattern
- **Classes**: `ResponseStrategy` (interface), `AggressiveStrategy`, `ConservativeStrategy`
- **Purpose**: Encapsulates mitigation actions as exchangeable strategies. The system dynamically selects either `AggressiveStrategy` (for critical/malicious threats) or `ConservativeStrategy` (for low-risk/benign threats) at runtime.

### 3. Adapter Pattern
- **Classes**: `VirusTotalAdapter` (Adapter), `ThirdPartyVirusTotalApi` (Adaptee)
- **Purpose**: Adapts the third-party client (which returns reputation scores from `0` to `100` via `getIpReputationScore`) to work with our internal `ThreatIntelService` interface (which requires the `scanIp` returning a formatted text report).

### 4. Proxy Pattern
- **Classes**: `ThreatIntelProxy`
- **Purpose**: Wraps the `ThreatIntelService` to add caching of IP scans and automated access logging. If an IP has been queried previously, the proxy serves the result from its cache (`Cache HIT`), bypassing the adapted API call to optimize performance.

### 5. Simple Notification Service
- **Classes**: `EmailNotifier`
- **Purpose**: Mimics dispatching security alerts to administrative teams upon completing the incident response pipeline.

---

## 🚀 How to Compile and Run

To run the application locally on Windows:

1. Double-click the `run.bat` script in the project root directory, OR
2. Run the batch script from the PowerShell/CMD console:
   ```powershell
   .\run.bat
   ```

### Manual Commands
If you prefer to run compiling commands manually:
- **Compile**:
  ```powershell
  mkdir bin
  javac -d bin -sourcepath src\main\java src\main\java\com\sdapro\Main.java
  ```
- **Execute**:
  ```powershell
  java -cp bin com.sdapro.Main
  ```

---

## 🛠️ Git Commands for Branch feature/B-threat-intel-proxy

To commit the new code and push it to the remote repository, execute the following commands in order:

1. **Verify your modified/untracked files**:
   ```powershell
   git status
   ```

2. **Stage all your changes** (including `.gitignore` and `src/` files):
   ```powershell
   git add .
   ```

3. **Commit the changes** with a meaningful message referencing your feature scope:
   ```powershell
   git commit -m "feat(threat-intel-proxy): implement Facade, Strategy, Adapter, Proxy, and Notification patterns for Student B"
   ```

4. **Push the branch to remote origin**:
   ```powershell
   git push origin feature/B-threat-intel-proxy
   ```

5. **Create a Pull Request** via your repository server UI (GitHub/GitLab) from `feature/B-threat-intel-proxy` to the `develop` or `main` branch, as specified in your team guidelines.