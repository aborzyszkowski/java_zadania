package zadanie06

// Zadanie 6 z rozszerzeniem: tryb, ścieżka pliku i dopisywany tekst.
// Przykład argumentów w IntelliJ: oba dane/example.txt "Moja dodatkowa linia."
def tryb = args.length > 0 ? args[0] : 'oba'
def sciezka = args.length > 1 ? args[1] : 'dane/example.txt'
def nowaTresc = args.length > 2 ? args[2] : 'Dodatkowa linia tekstu.'

if (args.length > 3 || !(tryb in ['odczyt', 'dopisz', 'oba'])) {
    System.err.println 'Użycie: odczyt|dopisz|oba [ścieżka] ["tekst do dopisania"]'
    System.exit(1)
}

def plik = new File(sciezka)
try {
    if (!plik.exists()) {
        if (tryb == 'odczyt') {
            System.err.println "Plik nie istnieje: ${plik.absolutePath}"
            System.exit(1)
        }

        def katalog = plik.absoluteFile.parentFile
        if (!katalog.exists() && !katalog.mkdirs()) {
            throw new IOException("Nie można utworzyć katalogu: ${katalog}")
        }
        plik.setText('Pierwsza linia pliku.', 'UTF-8')
        println "Utworzono plik: ${plik.absolutePath}"
    }

    if (!plik.isFile()) {
        throw new IOException("Podana ścieżka nie jest plikiem: ${plik.absolutePath}")
    }

    if (tryb in ['odczyt', 'oba']) {
        println 'Zawartość pliku:'
        println plik.getText('UTF-8')
    }

    if (tryb in ['dopisz', 'oba']) {
        plik.append("\n${nowaTresc}", 'UTF-8')
        println 'Nowa zawartość została dodana.'
        println 'Zawartość po dopisaniu:'
        println plik.getText('UTF-8')
    }
} catch (IOException problem) {
    System.err.println "Błąd obsługi pliku: ${problem.message}"
    System.exit(1)
}



/*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException

// Plik danych w bieżącym katalogu roboczym.
def plik = new File('dane.txt')
def wejscie = new BufferedReader(new InputStreamReader(System.in))

def odczytajPlik = {
    if (!plik.exists()) {
        println 'Plik nie istnieje. Najpierw dodaj do niego tekst.'
        return
    }

    String zawartosc = plik.getText('UTF-8')

    println '\n--- Zawartość pliku ---'
    if (zawartosc.isEmpty()) {
        println '(plik jest pusty)'
    } else {
        println zawartosc
    }
    println '--- Koniec zawartości ---'
}

def dopiszTekst = {
    print 'Podaj tekst do dopisania: '
    System.out.flush()

    String tekst = wejscie.readLine()

    if (tekst == null || tekst.trim().isEmpty()) {
        println 'Nie podano tekstu. Plik nie został zmieniony.'
        return
    }

    boolean istnial = plik.exists()
    String separator = System.lineSeparator()
    String prefiks = ''

    // Jeśli ostatni wpis nie kończy się nową linią,
    // oddziel go od dopisywanego tekstu.
    if (istnial && plik.length() > 0) {
        String zawartosc = plik.getText('UTF-8')
        if (!zawartosc.endsWith('\n') && !zawartosc.endsWith('\r')) {
            prefiks = separator
        }
    }

    plik.append(prefiks + tekst + separator, 'UTF-8')

    println istnial
            ? 'Tekst został dopisany do pliku.'
            : 'Utworzono plik i zapisano tekst.'
}

println "Plik danych: ${plik.absolutePath}"

while (true) {
    println '''
Wybierz operację:
1 — Odczytaj plik
2 — Dopisz tekst (lub utwórz plik)
3 — Dopisz tekst, a następnie odczytaj plik
0 — Zakończ
'''
    print 'Twój wybór: '
    System.out.flush()

    String wybor = wejscie.readLine()

    if (wybor == null || wybor.trim() == '0') {
        println 'Koniec programu.'
        break
    }

    try {
        if (plik.exists() && !plik.isFile()) {
            println 'Błąd: wskazana ścieżka nie jest zwykłym plikiem.'
            continue
        }

        switch (wybor.trim()) {
            case '1':
                odczytajPlik()
                break

            case '2':
                dopiszTekst()
                break

            case '3':
                dopiszTekst()
                odczytajPlik()
                break

            default:
                println 'Nieprawidłowy wybór. Wpisz 0, 1, 2 lub 3.'
        }
    } catch (IOException e) {
        println "Błąd operacji na pliku: ${e.message}"
    } catch (SecurityException e) {
        println "Brak uprawnień do pliku: ${e.message}"
    }
}
*/