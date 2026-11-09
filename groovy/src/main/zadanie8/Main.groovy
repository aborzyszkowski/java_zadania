// Zadanie 8: processData na danych z konsoli albo z pliku.
// Przykład argumentów: plik sortuj dane/elementy.txt
//                      konsola filtruj
// Bez argumentów skrypt pyta o źródło i operację.

def reader = System.in.newReader('UTF-8')

def processData(String dane, String operacja) {
    def elementy = dane.split(',').collect { it.trim() }.findAll { !it.isEmpty() }
    if (elementy.isEmpty()) {
        throw new IllegalArgumentException('Brak danych do przetworzenia.')
    }

    boolean liczby = elementy.every { it ==~ /-?\d+(\.\d+)?/ }
    List wynik
    String opis

    switch (operacja) {
        case 'sortuj':
            if (liczby) {
                wynik = elementy.collect { it.toBigDecimal() }.sort()
                opis = 'posortowane liczby'
            } else {
                wynik = elementy.sort { a, b -> a.compareToIgnoreCase(b) }
                opis = 'posortowane elementy'
            }
            break

        case 'filtruj':
            if (liczby) {
                wynik = elementy.collect { it.toBigDecimal() }.findAll { it > 0 }.sort()
                opis = 'liczby większe od zera'
            } else {
                wynik = elementy.findAll { it.length() >= 3 }.sort { a, b -> a.compareToIgnoreCase(b) }
                opis = 'słowa o długości co najmniej 3'
            }
            break

        default:
            throw new IllegalArgumentException("Nieznana operacja: ${operacja}")
    }

    if (wynik.isEmpty()) {
        println "Wynik (${opis}): (brak elementów)"
        return
    }

    def tekst = liczby ? wynik.collect { it.stripTrailingZeros().toPlainString() } : wynik
    println "Wynik (${opis}): ${tekst.join(', ')}"
}

def odczytajLinie = { String komunikat ->
    print komunikat
    System.out.flush()
    def linia = reader.readLine()
    if (linia == null) {
        throw new IllegalArgumentException('Przerwano wprowadzanie danych.')
    }
    return linia.trim()
}

def odczytajDane = { String zrodlo, String sciezka ->
    if (zrodlo == 'konsola') {
        return odczytajLinie('Podaj dane oddzielone przecinkami: ')
    }

    def plik = new File(sciezka)
    if (!plik.isFile()) {
        throw new IOException("Plik nie istnieje: ${plik.absolutePath}")
    }

    def tresc = plik.getText('UTF-8')
    if (tresc.startsWith('\uFEFF')) {
        tresc = tresc.substring(1)
    }
    tresc = tresc.replaceAll(/\r?\n/, ',').trim()
    println "Odczytano plik: ${plik.absolutePath}"
    return tresc
}

def zrodla = ['konsola', 'plik']
def operacje = ['sortuj', 'filtruj']
def zrodlo
def operacja
def sciezka = 'dane/elementy.txt'

if (args.length == 0) {
    zrodlo = odczytajLinie('Źródło danych (konsola/plik): ').toLowerCase()
    operacja = odczytajLinie('Operacja (sortuj/filtruj): ').toLowerCase()
    if (zrodlo == 'plik') {
        def podana = odczytajLinie("Ścieżka pliku [${sciezka}]: ")
        if (!podana.isEmpty()) {
            sciezka = podana
        }
    }
} else {
    zrodlo = args[0]
    operacja = args.length > 1 ? args[1] : 'sortuj'
    if (args.length > 2) {
        sciezka = args[2]
    }

    boolean zaDuzoArgumentow = args.length > 3 || (zrodlo == 'konsola' && args.length > 2)
    if (zaDuzoArgumentow || !(zrodlo in zrodla) || !(operacja in operacje)) {
        System.err.println 'Użycie: [konsola|plik] [sortuj|filtruj] [ścieżka]'
        System.exit(1)
    }
}

if (!(zrodlo in zrodla) || !(operacja in operacje)) {
    System.err.println 'Dozwolone źródła: konsola, plik. Dozwolone operacje: sortuj, filtruj.'
    System.exit(1)
}

try {
    def dane = odczytajDane(zrodlo, sciezka)
    processData(dane, operacja)
} catch (IOException problem) {
    System.err.println "Błąd odczytu danych: ${problem.message}"
    System.exit(1)
} catch (IllegalArgumentException problem) {
    System.err.println "Błąd danych: ${problem.message}"
    System.exit(1)
}
