package demoapp

class Computer {

    String nazwa
    String data_ksiegowania
    Double koszt_USD
    Double koszt_PLN

    static constraints = {
    }

    String toString(){
        nazwa + " " + data_ksiegowania + " koszt USD: " + koszt_USD + " koszt PLN: " + koszt_PLN
    }
}
