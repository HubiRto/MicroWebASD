# Backend Spring Boot Application: Algorithm Calculation Microservices 🚀

Witamy w repozytorium naszej aplikacji mikroserwisowej Spring Boot służącej do obliczeń algorytmicznych! Aplikacja ta jest zbudowana z wykorzystaniem architektury mikroserwisów, co zapewnia efektywne przetwarzanie algorytmów przy jednoczesnym utrzymaniu solidnego zarządzania użytkownikami i bezpieczeństwem dzięki AuthService. 🌟

## 🌐 Przegląd Mikroserwisów

Nasza aplikacja składa się z kilku kluczowych mikroserwisów:
- **AuthService**: Zarządza uwierzytelnianiem i funkcjonalnościami związanymi z użytkownikami, używając JWT (JSON Web Tokens) dla bezpiecznej komunikacji. Funkcje obejmują rejestrację użytkowników, logowanie, potwierdzanie e-mail oraz odnawianie tokenów.
- **API Gateway**: Punkt wejściowy dla wszystkich mikroserwisów, walidujący tokeny JWT w nagłówkach w celu zapewnienia bezpiecznego dostępu do systemu.
- **Eureka Service**: Rejestr usług utrzymujący listę wszystkich aktywnych mikroserwisów.
- **Algorithm Service**: Odpowiedzialny za obliczenia różnych algorytmów. Wykorzystuje bazy danych MongoDB i PostgreSQL do cachowania wyników i redukcji redundantnych obliczeń.

## 🚀 Algorithm Service - Serce naszych obliczeń

### Kluczowe Funkcjonalności

#### 🔄 Wykorzystanie Cache
- **Optymalizacja zapytań**: Mechanizm cachowania w MongoDB i PostgreSQL pozwala na unikanie ponownych obliczeń, co skutecznie redukuje obciążenie serwerów.
- **Hashowanie identyfikatorów wyników**: Każdy wynik w bazie ma swoje unikalne ID generowane funkcją hashującą, co ułatwia szybkie odzyskiwanie danych.

#### ⚠️ Obsługa Wyjątków
- **Customowe wyjątki**: Wprowadzenie specjalnych wyjątków pozwala na precyzyjne identyfikowanie i komunikowanie błędów w aplikacji.

#### ⏱️ Aspect-Oriented Programming (AOP)
- **Monitoring czasu wykonania**: AOP umożliwia dodawanie czasu obliczeń do odpowiedzi HTTP, co jest kluczowe dla monitorowania i optymalizacji wydajności.

### 📊 Zaimplementowane Algorytmy
Oferujemy szeroki zakres algorytmów, w tym:
- **Sortowanie**: QuickSort, MergeSort, InsertionSort, RadixSort, CountingSort
- **Przeszukiwanie**: BinSearch, BreadthFirstSearch, DepthFirstSearch
- **Inne**: Partition, HoarePartition, QuickSortPartition

### 🛠️ Przykład Użycia
Użytkownik wysyła zapytanie do API, które przekierowuje do Algorithm Service. Jeśli wynik już istnieje w bazie, jest natychmiast zwracany. W przeciwnym razie, algorytm jest przetwarzany, a wynik zapisywany i zwracany użytkownikowi.

## 🌟 Rozpoczęcie Pracy

1. Sklonuj repozytorium.
2. Zainstaluj potrzebne zależności.
3. Skonfiguruj połączenia z bazami danych oraz parametry JWT.
4. Uruchom mikroserwisy lokalnie lub na wybranym serwerze.
5. Testuj API używając narzędzi takich jak Postman.

Zapraszamy do korzystania z naszego Algorithm Service w ramach szerszej architektury mikroserwisów, które wspólnie tworzą solidną i skalowalną platformę do przetwarzania danych algorytmicznych. 💻🚀
