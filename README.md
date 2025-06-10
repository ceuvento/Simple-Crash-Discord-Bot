<h1 align="center">👑 Simple Crash Bot!</h1>

✅ This bot created for CRASHING DISCORD SERVERS!

## 💰 Requirements:
- JDK 23 (If Not Installed: https://adoptium.net/temurin/releases/?os=any&arch=any&version=23)
- GRADLE

## ❤️ How To Create A Bot:
  - Open https://discord.com/developers/applications/ and create a new bot!
  - In Bot Settings open the category named the "Bot", then click on the "Reset Token" and copy the token
  - Open "OAuth2" and in "OAuth2 URL Generator" select the "bot", select the "Administrator" below
  - copy the "Generated URL" and open this URL in browser, select Discord Server and click "Continue/OK"
  - Well Done!
## 🩵 How To Start Bot:
  - Copy the repository:
    ```bash
    git clone https://github.com/ceuvento/Simple-Crash-Discord-Bot.git
    cd Simple-Crash-Discord-Bot
    ```
  - Generate A Gradle Project With 23 JDK Via Intellij IDEA
  - Delete src Directory And Paste My src Directory
  - In build.gradle replace dependencies:
  - ```gradle
    dependencies {
        implementation("io.github.cdimascio:dotenv-java:3.2.0")
        implementation("net.dv8tion:JDA:5.6.1")
        implementation('org.slf4j:slf4j-api:2.0.9')
        implementation('org.slf4j:slf4j-simple:2.0.9')
    }
    ```
  - Create .env File In Source Directory
  - In .env File Paste This:
  - ```yaml
    TOKEN=<YOUR-DISCORD-BOT-TOKEN>
    LINK=<Link, That Will Be Sends In Messages)>
    MESSAGES_DELAY=<DELAY>
    CHANNELS=<COUNT OF CREATED CHANNELS>
    MESSAGES_ON_EACH=<COUNT OF MESSAGES ON EACH CHANNEL>
    AVATAR_URL=<NEW DISCORD SERVER AVATAR>
    ```
  - For Example:
  - ```yaml
    TOKEN=SADSADAS4DSDSDASDSASDASFGRYKHKFGG-ESDSDMSASDFFDS
    LINK=https://discord.gg/5su5HzqxJ6
    MESSAGES_DELAY=3
    CHANNELS=15
    MESSAGES_ON_EACH=15
    AVATAR_URL=https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/SNice.svg/1200px-SNice.svg.png
    ```
  - Start The Main.java In src/main/java/ru/cuvento (Or Start gradlew.bat - Windows; gradlew - Linux/MacOS)

## 🐜 Find A Bug?
- Contact With Me:
  - Discord: ceuvento
