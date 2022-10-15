package demoapp

class ComputerBuyingController {

    ComputerBuyingService computerBuyingService
    SerializeToXMLService serializeToXMLService

    def index() {
        render Computer.list()
    }

    def saveNewComputer(){
        computerBuyingService.saveComputer("Computer1", "2022-01-03", 345 as Double)
        computerBuyingService.saveComputer("Computer2", "2022-01-03", 543 as Double)
        computerBuyingService.saveComputer("Computer3", "2022-01-10", 346 as Double)
        redirect action: "showAllComputers"
    }

    def saveXML(){
        computerBuyingService.saveAsXML()
        redirect action: "showAllComputers"
    }

    def showAllComputers(){
        render view: 'showAllComputers', model: [computerList: Computer.list()]
    }

    //przykład użycia serializacji do tworzenia XMLa z objektu
    def serializeToXML(){
        serializeToXMLService.serializeToXML()
    }
}
