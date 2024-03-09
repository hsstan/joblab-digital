async function getTechs(){
    return fetch("/techs").then(r => r.body)
}

function getClothes(){

}

function getCars(){

}

module.exports = {
    getTechs,
    getClothes,
    getCars
}