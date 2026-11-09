import groovy.json.JsonSlurper

// Katalog roboczy IntelliJ: folder zadania 14, ten sam, w którym leżą przed.json i po.json.

def parser = new JsonSlurper()

def wczytaj = { String nazwa ->
    def plik = new File(nazwa)
    if (!plik.exists()) {
        println "Brak pliku: ${nazwa}"
        return null
    }
    return parser.parse(plik, 'UTF-8')
}

def przed = wczytaj('przed.json')
if (przed == null) {
    return
}

def po = wczytaj('po.json')
if (po == null) {
    return
}

def klucze = (przed.keySet() + po.keySet()).unique().sort()
def zmiany = []

klucze.each { klucz ->
    if (!przed.containsKey(klucz)) {
        zmiany << "DODANO ${klucz}: ${po[klucz]}"
    } else if (!po.containsKey(klucz)) {
        zmiany << "USUNIĘTO ${klucz}: ${przed[klucz]}"
    } else if (przed[klucz] != po[klucz]) {
        zmiany << "ZMIENIONO ${klucz}: ${przed[klucz]} -> ${po[klucz]}"
    }
}

if (zmiany.isEmpty()) {
    println 'Konfiguracje są identyczne.'
} else {
    zmiany.each { println it }
}
