def rabatProcentowy = { cena -> cena * 0.8 }

def kupon = { cena ->
    def poKuponie = cena - 10
    poKuponie < 0 ? 0 : poKuponie
}

def rabatZaProg = { cena ->
    cena >= 100 ? cena - 15 : cena
}

def obliczCene(cena, promocje) {
    def wynik = cena
    promocje.each { promocja ->
        wynik = promocja(wynik)
    }
    return wynik
}

println "Sam rabat: ${rabatProcentowy(100)} zł"
println "Sam kupon: ${kupon(100)} zł"
println "Najpierw rabat: ${obliczCene(100, [rabatProcentowy, kupon])} zł"
println "Najpierw kupon: ${obliczCene(100, [kupon, rabatProcentowy])} zł"
println "Najpierw próg: ${obliczCene(110, [rabatZaProg, rabatProcentowy])} zł"
println "Najpierw procent: ${obliczCene(110, [rabatProcentowy, rabatZaProg])} zł"
println "Kupon od 5: ${obliczCene(5, [kupon])} zł"
println "Kupon od 10: ${obliczCene(10, [kupon])} zł"
println "Bez promocji: ${obliczCene(100, [])} zł"
