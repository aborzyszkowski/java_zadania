// Katalog roboczy IntelliJ: folder zadania 12, ten sam, w którym leży app.log.

def plikLogow = new File('app.log')
if (!plikLogow.exists()) {
    println 'Brak pliku app.log.'
    return
}

def logi = plikLogow.getText('UTF-8')

def wiersze = logi.readLines().collect { linia ->
    linia.trim().split(/\s+/, 3)
}.findAll { czesci ->
    czesci.size() == 3
}

def bledy = wiersze.findAll { it[1] == 'ERROR' }.collect { it[2] }

def grupy = bledy.groupBy { it }

def raport = grupy.collect { komunikat, wystapienia ->
    "${wystapienia.size()} x ${komunikat}"
}.join('\n') ?: 'Brak błędów ERROR.'

println raport
new File('raport.txt').setText(raport, 'UTF-8')
