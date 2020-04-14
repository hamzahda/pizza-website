import axios from 'axios'
const url = "localhost:8081/";

async function getProducts(){
    await axios.get(url+"products").then( response =>{
        return response.data.products;
    });   
}
async function getProduct(id){
    await axios.get(url+"products/"+id).then( response =>{
        return response.data.product;
    });   
}


export default{
    getProducts,
    getProduct

}
