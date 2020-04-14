<template>
  <div id="product">
    <img src="../assets/pizza-img2.jpg" />
    <div>
      <div id="content">

      </div>
      <button class="button" @click="addToCart(product)">add to cart</button>
      <button class="button" @click="remove(product.id)">remove from cart</button>
    </div>
  </div>
</template>
<script>
import { mapActions } from "vuex";

export default {
  props: ["product"],
  methods: {
    ...mapActions(["addToCart", "remove"], "cart")
  }
};
</script>
<style scoped>
#product {
  margin-top: 1rem;
  padding: 1rem;
  border-style: none;
  background-color: cornsilk;
  color: slategrey;
  border-radius: 0.4rem;
  display: flex;
  justify-content: space-evenly;
  flex-direction: row;
  min-width: 45rem;

}


img{
height: 4rem;
width: 4rem;
}
</style>
