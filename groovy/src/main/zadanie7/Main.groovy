def createDirectory(String dirPath) {
    def directory = new File(dirPath)
    if (!directory.exists()) {
        if (directory.mkdirs()) {
            println "Katalog został utworzony: ${dirPath}"
        } else {
            println "Nie udało się utworzyć katalogu."
        }
    } else {
        println "Katalog już istnieje."
    }
}

def listFilesAndDirectories(String dirPath) {
    def directory = new File(dirPath)
    if (directory.exists()) {
        println "Zawartość katalogu ${dirPath}:"
        directory.eachFile { file ->
            println "- ${file.name}" + (file.directory ? " (Katalog)" : " (Plik)")
        }
    } else {
        println "Podany katalog nie istnieje."
    }
}

/*
// Zadanie 7 z rozszerzeniem: tryb i ścieżka katalogu.
// Przykład argumentów: oba dane/nowy-katalog
def tryb = args.length > 0 ? args[0] : 'oba'
def sciezka = args.length > 1 ? args[1] : 'dane/katalog'

if (args.length > 2 || !(tryb in ['utworz', 'listuj', 'oba'])) {
    System.err.println 'Użycie: utworz|listuj|oba [ścieżka]'
    System.exit(1)
}

def katalog = new File(sciezka)

def utworzKatalog = {
    if (katalog.exists()) {
        if (!katalog.isDirectory()) {
            throw new IOException("Podana ścieżka nie jest katalogiem: ${katalog.absolutePath}")
        }
        println "Katalog już istnieje: ${katalog.absolutePath}"
        return
    }

    if (!katalog.mkdirs()) {
        throw new IOException("Nie można utworzyć katalogu: ${katalog.absolutePath}")
    }
    println "Utworzono katalog: ${katalog.absolutePath}"
}

def wylistujZawartosc = {
    if (!katalog.exists()) {
        throw new IOException("Katalog nie istnieje: ${katalog.absolutePath}")
    }
    if (!katalog.isDirectory()) {
        throw new IOException("Podana ścieżka nie jest katalogiem: ${katalog.absolutePath}")
    }

    File[] elementy = katalog.listFiles()
    if (elementy == null) {
        throw new IOException("Nie można odczytać zawartości katalogu: ${katalog.absolutePath}")
    }

    println "Zawartość katalogu: ${katalog.absolutePath}"
    if (elementy.length == 0) {
        println '(katalog jest pusty)'
        return
    }

    elementy.toList().sort { a, b -> a.name <=> b.name }.each { element ->
        def rodzaj = element.isDirectory() ? 'katalog' : 'plik'
        println "[${rodzaj}] ${element.name}"
    }
}

try {
    if (tryb in ['utworz', 'oba']) {
        utworzKatalog()
    }
    if (tryb in ['listuj', 'oba']) {
        wylistujZawartosc()
    }
} catch (IOException problem) {
    System.err.println "Błąd obsługi katalogu: ${problem.message}"
    System.exit(1)
}
*/