static void main(String[] args) {
    def reader = System.in.newReader()
    print "Podaj liczbe calkowita: "

    int x = reader.readLine().toInteger()
    int z = x
    int m = 1

    for (int i=0; i<z; i+=1) {
        m = m*x
        x = x-1
    }
    print z
    print "! = "
    print m
}



/*
static void main(String[] args) {
    try {
        println "Podaj dwie liczby:"
        double liczba1 = args[0].toDouble()
        double liczba2 = args[1].toDouble()
        double srednia = (liczba1 + liczba2) / 2
        print "Średnia = "
        println srednia
    } catch (NumberFormatException blad) {
        println("Podano nieprawidłowe dane")
    }
}
*/
/*
//Tak działa
static void main(String[] args) {
    println "Podaj dwie liczby:"
    def reader = System.in.newReader()

    def x = reader.readLine() as Float
    def y = reader.readLine() as Float
    float srednia

    srednia = (x+y)/2
    print "Srednia = "
    println srednia
    println args.join(", ")

}
*/