package demoapp

class ComputerBuyingController {

    ComputerBuyingService computerBuyingService
    SerializeToXMLService serializeToXMLService

    def index() {
        render view: 'index', model: [computerlist: Computer.list()]
    }

    def saveNewComputer(){
        computerBuyingService.saveComputer()
        redirect action: "index"
    }

    def saveXML(){
        computerBuyingService.saveAsXML()
        redirect action: "index"
    }

    //przykład użycia serializacji do tworzenia XMLa z objektu
    def serializeToXML(){
        serializeToXMLService.serializeToXML()
    }
}
