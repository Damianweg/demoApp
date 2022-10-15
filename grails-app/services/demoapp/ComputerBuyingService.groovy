package demoapp

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder

@Transactional
class ComputerBuyingService {

    def saveComputer(String name, String date, Double price){
        try {
            String JSON_URL = "https://api.nbp.pl/api/exchangerates/rates/a/usd/" + date
            URL url = new URL(JSON_URL)

            InputStream urlStream = null
            urlStream = url.openStream()

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream))

            JsonSlurper jsonSlurper = new JsonSlurper()
            Object result = jsonSlurper.parse(reader)

            println (result.toString())

            Double exchangeRate = result["rates"]["mid"].get(0) as Double
            Double pricePLN1 = Math.round((price * exchangeRate) * 100) / 100

            Computer.findOrSaveWhere(name: name, postingDate: date, priceUSD: price, pricePLN: pricePLN1)

        } catch (Exception e){
            e.printStackTrace()
        }
    }

    def saveAsXML(){
        def stringWriter = new StringWriter()
        def xml = new MarkupBuilder(stringWriter)

        def computers = Computer.findAll()

        xml.faktura{
            computers.each {computer->
                komputer{
                    nazwa(computer.name)
                    data_ksiegowania(computer.postingDate)
                    koszt_USD(computer.priceUSD)
                    kosz_PLN(computer.pricePLN)
                }
            }
        }
        println stringWriter.toString()
        def fileWriter = new FileWriter("src/main/resources/faktura.xml")
        fileWriter.write(stringWriter as String)
        fileWriter.close()
    }

}
