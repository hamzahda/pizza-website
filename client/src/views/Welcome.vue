<template>
  <section id="welcome">
    Enjoy our Pizza !
    <br>
    with one click
    <br>
    <button id="button" @click="menuBtn"> Menu </button>
  </section>
</template>
<script>
export default {
  name: "Welcome",
  components: {},
  methods:{
   menuBtn(){
     this.$router.push({ path: 'menu' })
    }
  }
};
</script>

<style scoped>


#welcome {
  margin-left: 10% ;
  font-size: 4rem;
  color: azure ;
  font-family: "Sen";
  padding: 0rem;
  height: 100vh;
}
#button{
  margin-top: 0rem;
  padding:1rem;
  color: indigo;
  background-color:yellow;
  border: none;
  width: auto;
  height:8rem;
  margin-left: 8rem;
  cursor: pointer;
}
</style>
