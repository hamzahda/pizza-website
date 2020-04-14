<template>
  <section id="menu">
    <b-tabs content-class="mt-3" align="center" fill >
      <b-tab title="Drinks" active>
        
          <Product 
          v-for="product in pizzas"
          :product="product" 
          :key="product.id" 
          />
        
      </b-tab>
      <b-tab title="Pizzas">
        <Product 
          v-for="product in pizzas" 
          :product="product" 
          :key="product.id" 
          />
      </b-tab>
      <b-tab title="Sweets">
        <Product 
          v-for="product in pizzas" 
          :product="product" 
          :key="product.id" 
          />
      </b-tab>
    </b-tabs>
  </section>
</template>
<script>
import Product from "../components/product";
import {products} from "../../data";

import { mapActions } from 'vuex'; 

export default {
  name: "menu",
  components: { Product },
  methods : {
    ...mapActions(['add'], 'cart')
  },
  data(){
    return{
      pizzas: products
    }
  },
};
</script>
<style  scoped>
#menu{
  color:azure;
  display: flex;

  min-height: 100vh;
  justify-content: center;
}
</style>