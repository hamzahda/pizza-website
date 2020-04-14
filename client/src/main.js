import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import VueRouter from "vue-router"
import App from './App.vue'
import store from '../store'

Vue.use(VueRouter)
Vue.config.productionTip = false;

const router = new VueRouter({
  routes: [
    {
      path: "/",
      name: "Welcome",
      component: () => import('./views/Welcome.vue'),
    },
    {
      path: "/menu",
      name: "Menu",
      component: ()=> import('./views/Menu.vue'),
    },
    {
      path: "/cart",
      name: "Cart",
      component: ()=> import('./views/Cart.vue'),
    }

  ]
})
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
