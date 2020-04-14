<template>
  <div id="cart">
    <div id="div">
      <ul>
        <li v-for="product in cart" :product="product" :key="product.id" class="product">
          Name : {{product.name}}
          Quantity : {{product.count}}
        </li>
      </ul>
      <div id="form">
        <input v-model="name" placeholder="Name"> <br>
        <input v-model="adress" placeholder="Adress"> <br>
        <input type="checkbox" id="accept" v-model="accept">
    </div>
  </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
export default {
  name: "Cart",
  data(){
      return{
        name :'',
        adress:'',
        accept:'',    
      }
  },
  computed: {
    ...mapGetters(["cart"], "cart")
  }
};
</script>
<style scoped>
#cart {
  display: flex;
  justify-content: center;

  min-height: 100vh;
}

</style>