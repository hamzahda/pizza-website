<template>
   <div id="header">
       
    <nav>
      <ul>
        <li>
          <router-link to="/"> Welcome </router-link>
        </li>
        <li>
          <router-link to="/cart">
            Cart (<span id="cart" >{{ count }}</span>)
          </router-link>
        </li>
      </ul> 
      
    </nav>
    </div> 
</template>



<script>
import { mapGetters, mapActions, mapMutations } from 'vuex'; 
 export default {
  name : 'header',
  methods : {
    ...mapMutations(['addToCart'], 'cart'),
    ...mapActions(['test'], 'cart')
  },
  computed: {
    ...mapGetters(['count'], 'cart'),
  }
}
</script>



<style scoped>
#logo {
  position: absolute;
  margin-right: 2rem;
  font-size: 4rem;
  color: aliceblue;
}

nav {
  display: flex;
  justify-content: flex-end;
  margin-top: 0rem;
}

a {
  color: aliceblue ;
  text-decoration: none;
  background-image: linear-gradient(currentColor, currentColor);
  background-position: 0% 100%;
  background-repeat: no-repeat;
  background-size: 0% 2px;
  transition: background-size 0.3s;
}
a:hover,
a:focus {
  background-size: 100% 2px;
}

ul {
  display: flex;
  list-style-type: none;
  font-size: 20px;
  justify-content: flex-end;
}

li {
  margin: 1rem;
  font-family: "Sen", sans-serif;
}

li a {
  text-decoration: none;
  color:snow ;
  font-weight: bold;
}

li a:hover {
  text-decoration: underline;
}
</style>>
