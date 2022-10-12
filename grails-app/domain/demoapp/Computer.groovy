package demoapp

class Computer {

    String name
    String postingDate
    Double priceUSD
    Double pricePLN

    static constraints = {
    }

    String toString(){
        name + " " + postingDate + " priceUSD: " + priceUSD + " pricePLN: " + pricePLN
    }
}
