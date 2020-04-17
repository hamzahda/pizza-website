<template>
  <div id="app">
    <Header/>
    <router-view></router-view>
  </div>
</template>

<script>
import Header from "./components/Header"
export default {
       
  name: "App",
  components: {
    Header,
  }
};
</script>
<style>
@import url("https://fonts.googleapis.com/css?family=Sen&display=swap");
#app {
  background-image: url("./assets/bckg.jpg");
  background-repeat: no-repeat;
  
  background-size: auto;
}
#app::-webkit-scrollbar { width: 0 !important }
* {
  box-sizing: border-box;
}

</style>