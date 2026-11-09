def poprzednio = [
    katalog: 200,
    koszyk: 500,
    platnosc: 200,
    status: 10
]

def teraz = [
    katalog: 100,
    koszyk: 500,
    platnosc: 300,
    status: 15
]

def sredniaPoprzednio = poprzednio.values().sum() / poprzednio.size()
def sredniaTeraz = teraz.values().sum() / teraz.size()

println "Średnia poprzednio: ${sredniaPoprzednio} ms"
println "Średnia teraz: ${sredniaTeraz} ms"

def doSprawdzenia = []

poprzednio.each { nazwa, czas ->
    def nowyCzas = teraz[nazwa]
    def roznica = nowyCzas - czas
    def zmianaProcent = roznica * 100.0 / czas

    println "${nazwa}: ${czas} ms -> ${nowyCzas} ms; zmiana: ${zmianaProcent}%"

    if (zmianaProcent > 20 && roznica > 50) {
        doSprawdzenia << nazwa
    }
}

if (doSprawdzenia.isEmpty()) {
    println 'Brak istotnych spowolnień.'
} else {
    println "Do sprawdzenia: ${doSprawdzenia.join(', ')}"
}
