// Katalog roboczy IntelliJ: folder zadania 15, ten sam, w którym leży zmiany.txt.

def wersja = args ? args[0] : '1.0.0'
def nazwaPliku = args.length >= 2 ? args[1] : 'zmiany.txt'

def plik = new File(nazwaPliku)
if (!plik.exists()) {
    println "Brak pliku ${nazwaPliku}. Sprawdź katalog roboczy skryptu."
    return
}

def zmiany = plik.readLines('UTF-8')
    .collect { it.trim() }
    .findAll { !it.isEmpty() }

def kategorie = [
    feat: 'Nowe możliwości',
    fix: 'Poprawki',
    perf: 'Szybsze działanie'
]

def sekcje = []

kategorie.each { prefiks, tytul ->
    def poczatek = "${prefiks}: "
    def wpisy = zmiany
        .findAll { it.startsWith(poczatek) }
        .collect { "- ${it.substring(poczatek.length())}" }

    if (!wpisy.isEmpty()) {
        sekcje << "${tytul}\n${wpisy.join('\n')}"
    }
}

def tresc = sekcje ? sekcje.join('\n\n') : 'Brak zmian dla użytkownika.'
def opis = "Wersja ${wersja}\n\n${tresc}"

new File('opis-wydania.txt').setText(opis, 'UTF-8')
println opis
