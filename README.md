Rockstar Games UI Automation Project
Project Overview
This project provides a comprehensive automated UI test suite for the official Rockstar Games website. It covers a wide array of functionalities across different game sections, including general website navigation, news verification, video playback controls (for games like Red Dead Redemption 2), age verification, game search, and detailed product page inspections (for Red Dead Redemption 1). Developed using Java, Selenium WebDriver, and TestNG, it adheres to the Page Object Model (POM) for maintainability and leverages logging for detailed test execution insights. This project also includes 3-way parallel testing scenarios.

Project Goal
The main objectives of this project are to:

Automate navigation and verify key elements on the Rockstar Games main page, including news sections and logo display.

Automate the playback of game trailers (e.g., RDR2) and verify video player functionalities (quality, volume, pause).

Inspect related news and content on game-specific pages.

Automate age verification processes for restricted content.

Validate search functionality for games and filter options.

Inspect product details on game pages, including platform availability messages and trailer playback.

Showcase proficiency in Java, Selenium WebDriver, and TestNG for complex UI automation on a dynamic gaming website, including handling element locations and text manipulations.

Technologies Used
Programming Language: Java

Test Automation Framework: Selenium WebDriver

Testing Framework: TestNG

Assertion Library: TestNG SoftAssert (for non-blocking assertions)

Design Pattern: Page Object Model (POM)

Logging: java.util.logging.Logger

Setup and Run Instructions
To set up and run this project locally, follow these steps:

Clone the Repository:

git clone https://github.com/BoraSari/RockstarGamesUiAutomation.git
cd RockstarGamesUiAutomation

(Note: Replace BoraSari with your actual GitHub username if different. Adjust the repository name if it's different in your actual GitHub setup.)

Prerequisites:

Ensure Java Development Kit (JDK) 8 or higher is installed.

Have Maven (or Gradle) installed and configured for dependency management.

Download the appropriate WebDriver (e.g., ChromeDriver, GeckoDriver) for your browser and ensure it's accessible by your test environment (e.g., via WebDriverManager or system PATH).

Ensure BaseTest class correctly initializes the WebDriver.

Build the Project:

mvn clean install

(If using Gradle, replace mvn commands with gradle commands.)

Run the Tests:
Tests are configured with TestNG priorities and dependencies. You can run them via a TestNG XML suite or directly from your IDE (e.g., IntelliJ IDEA, Eclipse).

Example testng.xml:

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Rockstar Games UI Automation Suite">
    <test name="Rockstar Games Tests">
        <classes>
            <class name="RockstarGameTests.RockstarGamesTests"/>
        </classes>
    </test>
</suite>

Run with Maven:

mvn test -DsuiteXmlFile=testng.xml

Or run directly from your IDE.

Test Coverage and Scenarios
This project covers the following key scenarios for the Rockstar Games website:

checkAllGamesOWebsiteTest (Priority 1):

Description: Performs regression checks on the main page, verifying the display of game news sections, a general message, and the Rockstar Games logo.

Flow: Navigates to the main page, checks game news, and asserts the visibility of a message and the Rockstar Games logo.

checkRdr2TrailerTest (Priority 2):

Description: Tests the gameplay trailer video functionalities for Red Dead Redemption 2, including controls like quality change, volume, and pause. It also inspects related news and element locations.

Flow: Plays the RDR2 trailer, scrolls the page, interacts with video player functions, scrolls again, inspects other game news, and asserts various elements like related video titles, attributes, and text content.

legendsPageTextTest (Priority 3):

Description: Navigates to the Red Dead Redemption Legends page, fills out an age verification form, and tests search and content display functionalities.

Flow: Navigates to the Legends page, fills in age details (e.g., "06", "03", "2015"), scrolls the page up and down, clicks the game search icon, filters by games, and asserts various text values, tag names, and element displays (including handling "content not available" messages).

rdr1PageTests (Priority 4):

Description: Tests the Red Dead Redemption 1 game page, including searching for the game, trailer playback, and verifying platform availability messages.

Flow: Searches for "Red Dead Redemption", scrolls down, clicks the RDR1 game poster, starts and closes the trailer, clicks the "Buy Now" button, and asserts the length, ending character, and case-transformed text of the platforms message, as well as the non-emptiness of platform titles.

Screenshots/GIFs
(Please add screenshots or GIFs here demonstrating the test execution for various scenarios, such as the main page, RDR2 trailer playback, age verification, game search, and RDR1 page details with platform messages, to visually showcase the project's functionality.)

License
This project is licensed under the MIT License - see the LICENSE file for details.

Rockstar Games UI Otomasyon Projesi
Projeye Genel Bakış
Bu proje, resmi Rockstar Games web sitesi için kapsamlı bir otomatik UI test paketi sunar. Genel web sitesi navigasyonu, haber doğrulama, video oynatma kontrolleri (Red Dead Redemption 2 gibi oyunlar için), yaş doğrulama, oyun arama ve ayrıntılı ürün sayfası incelemeleri (Red Dead Redemption 1 için) dahil olmak üzere farklı oyun bölümlerindeki geniş bir işlev yelpazesini kapsar. Java, Selenium WebDriver ve TestNG kullanılarak geliştirilen bu proje, bakım kolaylığı için Page Object Model (POM) prensiplerine uyar ve ayrıntılı test yürütme içgörüleri için günlük kaydını kullanır. Bu proje aynı zamanda 3'lü paralel test senaryoları içermektedir.

Proje Amacı
Bu projenin temel hedefleri şunlardır:

Rockstar Games ana sayfasında navigasyonu otomatikleştirmek ve haber bölümleri ile logo görüntüsü gibi temel öğeleri doğrulamak.

Oyun fragmanlarının (örn: RDR2) oynatılmasını otomatikleştirmek ve video oynatıcı işlevlerini (kalite, ses düzeyi, duraklatma) doğrulamak.

Oyuna özel sayfalardaki ilgili haberleri ve içeriği incelemek.

Kısıtlı içerik için yaş doğrulama süreçlerini otomatikleştirmek.

Oyunlar için arama işlevselliğini ve filtreleme seçeneklerini doğrulamak.

Oyun sayfalarındaki ürün detaylarını, platform kullanılabilirlik mesajlarını ve fragman oynatmayı incelemek.

Dinamik bir oyun web sitesinde öğe konumlarını ve metin manipülasyonlarını ele alma dahil olmak üzere karmaşık UI otomasyonu için Java, Selenium WebDriver ve TestNG'deki yetkinliği sergilemek.

Kullanılan Teknolojiler
Programlama Dili: Java

Test Otomasyon Çerçevesi: Selenium WebDriver

Test Çerçevesi: TestNG

Doğrulama Kütüphanesi: TestNG SoftAssert (engellemeyen doğrulamalar için)

Tasarım Deseni: Page Object Model (POM)

Günlük Kaydı: java.util.logging.Logger

Kurulum ve Çalıştırma Talimatları
Bu projeyi yerel olarak kurmak ve çalıştırmak için aşağıdaki adımları izleyin:

Depoyu Klonlayın:

git clone https://github.com/BoraSari/RockstarGamesUiAutomation.git
cd RockstarGamesUiAutomation

(Not: BoraSari yerine gerçek GitHub kullanıcı adınızı yazın. GitHub'daki gerçek kurulumunuz farklıysa depo adını ayarlayın.)

Ön Koşullar:

Java Development Kit (JDK) 8 veya daha yüksek bir sürümün yüklü olduğundan emin olun.

Maven (veya Gradle) yüklü ve bağımlılık yönetimi için yapılandırılmış olmalıdır.

Tarayıcınız için uygun WebDriver'ı (örn: ChromeDriver, GeckoDriver) indirin ve test ortamınız tarafından erişilebilir olduğundan emin olun (örn: WebDriverManager veya sistem PATH aracılığıyla).

BaseTest sınıfının WebDriver'ı doğru bir şekilde başlattığından emin olun.

Projeyi Derleyin:

mvn clean install

(Gradle kullanıyorsanız, mvn komutlarını gradle komutlarıyla değiştirin.)

Testleri Çalıştırın:
Testler TestNG öncelikleri ve bağımlılıkları ile yapılandırılmıştır. Testleri bir TestNG XML paketi aracılığıyla veya doğrudan IDE'nizden (örn: IntelliJ IDEA, Eclipse) çalıştırabilirsiniz.

Örnek testng.xml:

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Rockstar Games UI Otomasyon Paketi">
    <test name="Rockstar Games Testleri">
        <classes>
            <class name="RockstarGameTests.RockstarGamesTests"/>
        </classes>
    </test>
</suite>

Maven ile çalıştırma:

mvn test -DsuiteXmlFile=testng.xml

Veya doğrudan IDE'nizden çalıştırın.

Test Kapsamı ve Senaryoları
Bu proje, Rockstar Games web sitesi için aşağıdaki temel senaryoları kapsar:

checkAllGamesOWebsiteTest (Öncelik 1):

Açıklama: Ana sayfada regresyon kontrolleri yapar, oyun haberleri bölümlerinin, genel bir mesajın ve Rockstar Games logosunun görüntülendiğini doğrular.

Akış: Ana sayfaya gider, oyun haberlerini kontrol eder ve bir mesajın ve Rockstar Games logosunun görünürlüğünü doğrular.

checkRdr2TrailerTest (Öncelik 2):

Açıklama: Red Dead Redemption 2 için oynanış fragmanı video işlevlerini, kalite değiştirme, ses düzeyi ve duraklatma gibi kontrolleri test eder. Ayrıca ilgili haberleri ve öğe konumlarını inceler.

Akış: RDR2 fragmanını oynatır, sayfayı kaydırır, video oynatıcı işlevleriyle etkileşime girer, tekrar kaydırır, diğer oyun haberlerini inceler ve çeşitli öğeleri gibi ilgili video başlıkları, öznitelikler ve metin içeriği doğrular.

legendsPageTextTest (Öncelik 3):

Açıklama: Red Dead Redemption Legends sayfasına gider, bir yaş doğrulama formunu doldurur ve arama ve içerik görüntüleme işlevlerini test eder.

Akış: Legends sayfasına gider, yaş bilgilerini (örn: "06", "03", "2015") doldurur, sayfayı yukarı ve aşağı kaydırır, oyun arama simgesine tıklar, oyunlara göre filtreler ve çeşitli metin değerlerini, etiket adlarını ve öğe görüntülerini (içerik mevcut değil mesajlarını ele alma dahil) doğrular.

rdr1PageTests (Öncelik 4):

Açıklama: Red Dead Redemption 1 oyun sayfasını test eder, oyunu arama, fragman oynatma ve platform kullanılabilirlik mesajlarını doğrulama dahil.

Akış: "Red Dead Redemption" araması yapar, aşağı kaydırır, RDR1 oyun posterine tıklar, fragmanı başlatır ve kapatır, "Şimdi Satın Al" düğmesine tıklar ve platformlar mesajının uzunluğunu, bitiş karakterini ve büyük/küçük harf dönüştürülmüş metnini, ayrıca platform başlıklarının boş olmamasını doğrular.

Ekran Görüntüleri/GIF'ler
![image](https://github.com/user-attachments/assets/37c26927-0652-450d-9720-6bc27411296a)


License
This project is licensed under the MIT License - see the LICENSE file for details.
