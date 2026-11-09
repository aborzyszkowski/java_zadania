def lodowka = args ? args.toList() : ['jajka', 'mleko', 'maka', 'ser']

def przepisy = [
    nalesniki: ['jajka', 'mleko', 'maka'],
    omlet: ['jajka', 'ser'],
    tosty: ['chleb', 'ser'],
    salatka: ['pomidor', 'ogorek', 'ser']
]

przepisy.each { danie, skladniki ->
    def brakuje = skladniki - lodowka

    if (brakuje.isEmpty()) {
        println "${danie}: możesz przygotować!"
    } else if (brakuje.size() == 1) {
        println "${danie}: dokup tylko ${brakuje[0]}"
    } else {
        println "${danie}: brakuje ${brakuje.join(', ')}"
    }
}
