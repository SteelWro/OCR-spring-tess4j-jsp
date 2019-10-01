> Moja własna aplikacja webowa rozpoznająca tekst na obrazie.
>
> Zainspirowana repozytorium Pana Przemka Bykowskiego https://github.com/bykowski/orc-system
>
> http://bykowski.pl
>
>

Aplikacja dostępna publicznie po adresem:
http://77.55.218.33:8080

funkcjonalności:
- pola dla użytkownika posiadają walidację:
    * dla adresu (zły format http lub gdy strona zwraca kod błędu)
    * dla pliku (plik ma zły format, nie ma go lub przekracza 20 MB)
- aplikacja zwraca odpowiednio dla pliku lub linku do pliku łańcuch znakó jaki uda mu się odczytać

 Wykorzystane technologie:
- Java
- Spring
- Tesseract [Tess4j] (https://github.com/nguyenq/tess4j)
- thymeleaf
- JavaScript
- Bootstrap

Do zrobienia:
- przy niektóych dużych i mało czytelnych plikach .pdf występują błędy. Prawdopodobnie pliki wysyłane na serwer są źle formatowane na plik



