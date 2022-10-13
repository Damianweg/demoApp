package demoapp

import grails.gorm.transactions.Transactional

import java.beans.XMLEncoder

@Transactional
class SerializeToXMLService {

    private static final String SERIALIZED_FILE_NAME="fakturaSerializacja.xml"

    //Przykład użycia Serializacji do tworzenia XMLa z objektu
    def serializeToXML() {
        Double priceUSD = 1234 as Double
        Double price = 324 as Double
        Double pricePLN = Math.round((priceUSD * price) * 100) / 100
        Computer computer = new Computer(name: "Computer1", postingDate: "2020-01-01", priceUSD: priceUSD, pricePLN: pricePLN)

        XMLEncoder encoder = null

        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)))
        } catch (FileNotFoundException fileNotFound) {
            println "ERROR: While Creating or Opening the File fakturaSerializacja.xml"
        }
        encoder.writeObject(computer)
        encoder.close()
    }
}
