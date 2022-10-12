package demoapp

class ComputerBuyingController {

    ComputerBuyingService computerBuyingService

    def index() {
        render Computer.list()
    }

    def saveNewComputer(){
        computerBuyingService.saveComputer()
        redirect action: "index"
    }
}
