async function getTechs(){
    const response =  await fetch("/techs");
    const json = await response.json();
    return json;
}

async function getClothes(){
    const response =  await fetch("/clothes");
    const json = await response.json();
    return json;
}

async function getCars(){
    const response =  await fetch("/cars");
    const json = await response.json();
    return json;
}

export default {
    getTechs,
    getClothes,
    getCars
}