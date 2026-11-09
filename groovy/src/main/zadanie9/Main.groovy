static void main(String[] args) {
    def reader = System.in.newReader()
    print "Podaj liczbe calkowita n: "

    int n = reader.readLine().toInteger()
    double m = 1

    for (int i=2; i<=n; i+=1) {
        m += 1/i
    }

    if (n == 1) {
        print m
    }
    else if (n == 2) {
        print "1 + 1/2 = " + m
    } else if (n == 3) {
        print "1 + 1/2 + 1/" + n + " = " + m.round(2)
    } else {
        print "1 + 1/2 + ... + 1/" + n + " = " + m.round(2)
    }
}
