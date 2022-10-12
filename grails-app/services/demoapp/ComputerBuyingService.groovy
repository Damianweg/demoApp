package demoapp

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class ComputerBuyingService {

    def saveComputer(){
        try {
            String JSON_URL = "https://api.nbp.pl/api/exchangerates/rates/a/usd/2020-01-03/?format=json"
            URL url = new URL(JSON_URL)

            InputStream urlStream = null
            urlStream = url.openStream()

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream))

            JsonSlurper jsonSlurper = new JsonSlurper()
            Object result = jsonSlurper.parse(reader)

            println (result.toString())

            Double priceUSD = 1234 as Double
            Double price = result["rates"]["mid"].get(0) as Double
            Double pricePLN = Math.round((priceUSD * price) * 100) / 100

            Computer.findOrSaveWhere(name: "Computer1", postingDate: "2020-01-03", priceUSD: priceUSD, pricePLN: pricePLN)

        } catch (Exception e){
            e.printStackTrace()
        }
    }
}
