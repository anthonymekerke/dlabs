class DlabsQuery{

    constructor() {
        this.headers = {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': ' http://localhost:8080/singlepage/',
            'Access-Control-Allow-Credentials': 'true',
            'Access-Control-Allow-Methods': 'GET, POST, OPTIONS',
            'Access-Control-Allow-Headers': 'Origin, Content-Type, Accept'
        }

        this.url = 'http://localhost:8080/singlepage/'
    }

    configureUrl(param){
        console.log("configureUrl -> param = " + param)
        this.headers["Access-Control-Allow-Origin"] = ' http://localhost:8080/singlepage/' + param
        this.url = 'http://localhost:8080/singlepage/' + param
    }
}

export { DlabsQuery }